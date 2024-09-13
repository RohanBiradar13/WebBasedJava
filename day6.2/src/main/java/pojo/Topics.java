package pojo;

public class Topics {
	private int topicId;
	private String topicsName;
	public Topics() {
		// TODO Auto-generated constructor stub
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicsName() {
		return topicsName;
	}
	public void setTopicsName(String topicsName) {
		this.topicsName = topicsName;
	}
	@Override
	public String toString() {
		return "Topics [topicId=" + topicId + ", topicsName=" + topicsName + "]";
	}
	
}