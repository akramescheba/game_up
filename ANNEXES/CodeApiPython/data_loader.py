import pandas as pd


def load_training_data(file_path="data/data.csv"):
    # Ex: Charger un fichier CSV contenant les données d'utilisateur, jeux, etc.
    return pd.read_csv(file_path, usecols=['user_id', 'game_id', 'rating', 'game_name'])
