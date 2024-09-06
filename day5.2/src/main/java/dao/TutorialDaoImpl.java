package dao;

import static utils.DBUtils.fetchDBCOnnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Tutorial;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;

	public TutorialDaoImpl() throws ClassNotFoundException, SQLException {
		// //get cn
		cn = fetchDBCOnnection();
		// pst1 : join query to fetch tut names for a specific topic
		pst1 = cn.prepareStatement(
				"select t1.name from tutorials t1 inner join topics t2 on t1.topic_id=t2.id where t2.name=?");
        pst2=cn.prepareStatement("select * from tutorials where name=? order by visits desc");
        pst3=cn.prepareStatement("update tutorials set visits=visits+1 where name=?");	
	    System.out.println("tutorials dao created");
	}

	@Override
	public List<String> getAllTutorialsByTopics(String topicName) throws SQLException {
		List<String> tutNames = new ArrayList<String>();
		// set IN params :topic name
		pst1.setString(1, topicName);
		try (ResultSet rst1 = pst1.executeQuery()) {
			while (rst1.next())
				tutNames.add(rst1.getString(1));
		}
		return tutNames;

	}
	@Override
	public Tutorial getTutorialDetails(String tutName) throws SQLException {
		//set params : tutName
		pst2.setString(1, tutName);
		try(ResultSet rst = pst2.executeQuery()){
			if(rst.next())
				return new Tutorial(rst.getInt(1), tutName, rst.getString(3), rst.getDate(4), rst.getInt(5), rst.getInt(6),rst.getString(7));
		}
		return null;
	}

	@Override
	public String updateVisitCount(String tutName) throws SQLException {
		// set IN params
		pst3.setString(1, tutName);
		int updateCount=pst3.executeUpdate();
		if(updateCount == 1)
		return "Visits Updated";
		return "Visits Updation Failed..";
	}
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			System.out.println("tutorials dao cleaned up");

		}
	}

	
}
