from models import UserData
from data_loader import load_training_data
from sklearn.metrics.pairwise import cosine_similarity
import pandas as pd
from sklearn.neighbors import NearestNeighbors


def generate_recommendations(user_data: UserData):
    # Définition du chemin d'accès et chargement du fichier d'entrainement du ML
    df = load_training_data("data/data.csv")
    tableau = df.pivot_table(
        index='user_id',
        columns='game_id',
        values='rating'
    ).fillna(0)

    for p in user_data.purchases:
        tableau.loc[user_data.user_id, p.game_id] = p.rating
    #  Entraînement du ML
    n_neighbors = min(3, len(tableau))
    model_knn = NearestNeighbors(n_neighbors=n_neighbors, metric='cosine')
    model_knn.fit(tableau.values)

    # Recherche des voisins
    distances, indices = model_knn.kneighbors(
        tableau.loc[[user_data.user_id]],
        n_neighbors=n_neighbors
    )
    similar_users = tableau.index[indices[0][1:]].tolist()
    # Moyenne des ratings des voisins
    recs_series = (
        df[df['user_id'].isin(similar_users)]
        .groupby('game_id')['rating']
        .mean()
        .sort_values(ascending=False)
    )
    # Recupération des tops 5 des jeux
    already = df[df['user_id'] == user_data.user_id]['game_id'].tolist()
    top_ids = recs_series.drop(already, errors='ignore').head(5).index.tolist()
    # Récupération des game_name à partir des game_id
    recommendations = []
    for gid in top_ids:
        matches = df[df['game_id'] == gid]
        if not matches.empty:
            # Prend le premier game_name trouvé
            game_name = matches.iloc[0]['game_name']
        else:
            game_name = "Inconnu"
        recommendations.append({
            "game_id": gid,
            "game_name": game_name,
            "rating": float(recs_series[gid])
        })
    return recommendations
