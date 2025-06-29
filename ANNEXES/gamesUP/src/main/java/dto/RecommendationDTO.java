package dto;

public class RecommendationDTO {
	   private Integer game_id;
	    private Double rating;
	    
		public Integer getGame_id() {
			return game_id;
		}
		public void setGame_id(Integer game_id) {
			this.game_id = game_id;
		}
		public Double getRating() {
			return rating;
		}
		public void setRating(Double rating) {
			this.rating = rating;
		}
}
