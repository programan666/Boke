package programan.pojo;

public class Article {
	
	private int id;
	private String text;
	private String articleName;
	private ArticleType articleType;
	private String articleLink;
	private String creationDT;
	private Author author;
	private String articleIntroduction;
	private int visitsNumber;
	private int poiontsNumber;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public ArticleType getArticleType() {
		return articleType;
	}
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}
	public String getArticleLink() {
		return articleLink;
	}
	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}
	public String getCreationDT() {
		return creationDT;
	}
	public void setCreationDT(String creationDT) {
		this.creationDT = creationDT;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getArticleIntroduction() {
		return articleIntroduction;
	}
	public void setArticleIntroduction(String articleIntroduction) {
		this.articleIntroduction = articleIntroduction;
	}
	public int getVisitsNumber() {
		return visitsNumber;
	}
	public void setVisitsNumber(int visitsNumber) {
		this.visitsNumber = visitsNumber;
	}
	public int getPoiontsNumber() {
		return poiontsNumber;
	}
	public void setPoiontsNumber(int poiontsNumber) {
		this.poiontsNumber = poiontsNumber;
	}

}
