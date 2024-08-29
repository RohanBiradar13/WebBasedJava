package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopicDaoImplTest {
	private TopicDaoImpl topicDao;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("in set up");
		topicDao = new TopicDaoImpl();
	}

	@Test

	void testGetAllTopics() throws Exception {
		List<String> allTopicNames = topicDao.getAllTopics();
		System.out.println("All Topics: " + allTopicNames);
		assertNotNull(allTopicNames, "The list of topics should not be null.");
		assertFalse(allTopicNames.isEmpty(), "The list of topics should not be empty.");
		assertEquals(4, allTopicNames.size(), "The list should contain 4 topics.");
	}

}
