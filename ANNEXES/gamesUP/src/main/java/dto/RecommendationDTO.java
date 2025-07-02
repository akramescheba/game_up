package dto;

public class RecommendationDTO {

  private Integer game_id;
  private String game_name;
  private Double rating;

  public String getGame_name() {
    return game_name;
  }

  public void setGame_name(String game_name) {
    this.game_name = game_name;
  }

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
