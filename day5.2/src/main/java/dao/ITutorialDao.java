package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Tutorial;

public interface ITutorialDao {
	//add a method to return list of tutorial names for a chosen topic
List<String> getAllTutorialsByTopics(String topicName) throws SQLException;
//add a method to return selected tutorials details
Tutorial getTutorialDetails(String tutName) throws SQLException;
//add a method to update visit count
String updateVisitCount(String tutName) throws SQLException;
}
