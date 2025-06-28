package dto;

public class GameDTO {
	
	 public Long id;
	    public String nom;
	    public String image;
	    public String genre;
	    public String description;
	    public Integer numEdition;
	    public Long categoryId;
	    public Long publisherId;
	    public Long authorId;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getNumEdition() {
			return numEdition;
		}
		public void setNumEdition(Integer numEdition) {
			this.numEdition = numEdition;
		}
		public Long getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}
		public Long getPublisherId() {
			return publisherId;
		}
		public void setPublisherId(Long publisherId) {
			this.publisherId = publisherId;
		}
		public Long getAuthorId() {
			return authorId;
		}
		public void setAuthorId(Long authorId) {
			this.authorId = authorId;
		}

}
