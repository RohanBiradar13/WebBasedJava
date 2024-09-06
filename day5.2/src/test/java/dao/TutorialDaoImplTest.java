package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pojo.Tutorial;

class TutorialDaoImplTest {
	private TutorialDaoImpl dao;

	@BeforeEach
	void setUp() throws Exception {
		dao=new TutorialDaoImpl();
	}
	@AfterClass
	void cleanUpp() throws Exception{
		System.out.println("in clean up method");
		dao.cleanUp();
	}

	@Test
	void testGetAllTutorialsByTopics() throws SQLException {
		List<String> allTutorialsByTopic=dao.getAllTutorialsByTopics("Spring Framework");
		System.out.println(allTutorialsByTopic);
		assertEquals(true, allTutorialsByTopic.contains("Spring MVC"));
	}
	@Test
	void testGetTutorialsDetails() throws Exception{
	Tutorial tutorialDetails =	dao.getTutorialDetails("Spring Core");
	System.out.println(tutorialDetails);
	assertEquals("Priti",tutorialDetails.getAuthor());
	}

	@Test
	void testUpdateVisits() throws Exception{
	String updateVisits	=dao.updateVisitCount("Spring Boot");
	System.out.println(updateVisits);
	assertEquals("Visits Updated", updateVisits);
	}
	
}
