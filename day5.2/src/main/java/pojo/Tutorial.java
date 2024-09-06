package pojo;

import java.sql.Date;

public class Tutorial {
	private int tutorialId;
	private String tutotialName;
	private String author;
	private Date publishDate;
	private int visits;
	private int topicId;//FK ----> PK of the topics(topicsID)
	private String contents;
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}
    
	

	public Tutorial(int tutorialId, String tutotialName, String author, Date publishDate, int visits, int topicId,
			String contents) {
		super();
		this.tutorialId = tutorialId;
		this.tutotialName = tutotialName;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.topicId = topicId;
		this.contents = contents;
	}



	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public String getTutotialName() {
		return tutotialName;
	}
	public void setTutotialName(String tutotialName) {
		this.tutotialName = tutotialName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}



	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", tutotialName=" + tutotialName + ", author=" + author
				+ ", publishDate=" + publishDate + ", visits=" + visits + ", topicId=" + topicId + ", contents="
				+ contents + "]";
	}

	
	
    
}
