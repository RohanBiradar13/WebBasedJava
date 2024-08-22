package dao;

import java.sql.Connection;
import java.sql.*;



import static utils.DBUtils.fetchDBCOnnection;

public class BankAccountDaoImpl implements IBankAccountDao{
	private Connection cn;
	private CallableStatement cst1;
	
	public BankAccountDaoImpl() throws ClassNotFoundException,SQLException{
		//get cn
		cn = fetchDBCOnnection();
		//create CST to execute stored procedure
		String invocationSyntax = "{call transfer_funds_proc(?,?,?,?,?)}";//? => placeholder for IN/ OUT/ IN OUT
		cst1 = cn.prepareCall(invocationSyntax);
		//register out parameter : OUT / IN OUT
		// => Must inform the JDBC data type of the OUT params to JVM before execution of
		//the stored procedure/function---o.w exception is thrown!
		//Method of CST : public void registerOutParameter(int paramsPos, int jdbcType)
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
	
	}

	@Override
	public String transferFunds(int srcId, int destId, double amount) throws SQLException {
		//Set In params(inherited from PST)
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, amount);
		//execute stored procedure
		//public boolean execute() throws SQL exception
		cst1.execute();
		//use CST's getter to get the results stored in OUT paramter
		StringBuilder sb = new StringBuilder("Funds transfered !");
		sb.append("Updated Src balance "+cst1.getDouble(4));
		sb.append(" Updated dest balance "+cst1.getDouble(5));
		return sb.toString();
	}
	public void cleanUp() throws SQLException{
		if(cst1 != null)
			cst1.close();
		if(cn != null)
			cn.close();
		System.out.println("account dao cleaned up !");
	}

}
