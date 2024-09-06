package dao;

import static utils.DBUtils.fetchDBCOnnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TopicDaoImpl implements ITopicDao {
     private Connection cn;
     private PreparedStatement pst1;
     public TopicDaoImpl() throws ClassNotFoundException, SQLException {
		cn=fetchDBCOnnection();
		pst1=cn.prepareStatement("select name from topics");
		System.out.println("Topic Dao Created...");
	}
	@Override
	public List<String> getAllTopics() throws SQLException {
		List<String> topicNames= new ArrayList<String>();
		try(ResultSet rst1 = pst1.executeQuery()){
			while(rst1.next())
				 topicNames.add(rst1.getString(1));
		}
		return topicNames;
	}
	public void cleanUp() throws SQLException {
		if(pst1 != null)
			pst1.close();
		System.out.println("Topic Dao cleaned Up....");
	}

}
