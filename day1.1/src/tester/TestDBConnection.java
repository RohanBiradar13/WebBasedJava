package tester;

import java.sql.Connection;

import utils.DBUtils;

public class TestDBConnection {

	public static void main(String[] args) {
	try(Connection cn = DBUtils.fetchDBCOnnection()){
		System.out.println("connected to DB "+cn);
	}catch (Exception e) {
		e.printStackTrace();
	}

	}

}
