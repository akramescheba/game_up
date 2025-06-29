# recommendation.py
from models import UserData
from data_loader import load_training_data
from sklearn.metrics.pairwise import cosine_similarity
import pandas as pd
from sklearn.neighbors import NearestNeighbors

def generate_recommendations(user_data: UserData):
    # Définition du chemin d'accès au fichier d'entrainement du ML
    df = load_training_data("data/data.csv")
    
    tableau = df.pivot_table(index ='user_id', columns ='game_id', values ='rating').fillna(0)
    
    for p in user_data.purchases:
        tableau.loc[user_data.user_id, p.game_id] = p.rating
        
    tableau = tableau.fillna(0)
    
    
    n_users = len(tableau)
    n_neighbors = min(3, n_users)
    
  # Algorithme du KNN
    model_knn = NearestNeighbors(n_neighbors=n_neighbors, metric='cosine')
    model_knn.fit(tableau.values)

    distances, indices = model_knn.kneighbors(
        tableau.loc[[user_data.user_id]],
        n_neighbors=n_neighbors
    )


    similar_users = tableau.iloc[indices[0][1:]].index.tolist()

    # Reconnaissance des jeux du user
    recommended_games = df[df['user_id'].isin(similar_users)].groupby('game_id')['rating'].mean().sort_values(ascending=False)

    # Filtrage les jeux déjà achetés
    already_rated = df[df['user_id'] == user_data.user_id]['game_id'].tolist()
    recommendations = recommended_games.drop(already_rated, errors='ignore').head(5).index.tolist()

    return [{"game_id": gid, "rating": gid} for gid in recommendations]