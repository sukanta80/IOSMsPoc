package main.java.com.ios.ms.poc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Dbutilityfile {
	static Connection conn = null;
	static ResultSet rs=null;
	static Statement stmt=null;
	public static Properties prop = null;
		
	 public  Connection getConnection() throws SQLException, ClassNotFoundException
	{
		       
    try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");        
            
         conn=DriverManager.getConnection("jdbc:oracle:thin:@pie.ams.com:1521:tap821","ops$smisra_infce","smisra_infce");  
         System.out.println(conn);
         System.out.println("Connection Established successfully !!!");
                       
    }
    catch (Exception e)
	{
		e.printStackTrace();
	}
	return conn;
	
	}
	 
	 public String getresultset(Connection conn, String cust_order_number) throws SQLException 
	 {	 
		String customer_order_id=cust_order_number;
        stmt=conn.createStatement();
        String sql="select * from sxp_tbl_srvord_info where CUSTOMER_ORDER_ID='"+customer_order_id+"'";
        rs=stmt.executeQuery(sql);
        if (rs.next()) 
        {
        	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+" "+rs.getString(31) ); 
        }        
        return rs.getString(31);
   }


	 public Connection closeConnection(Connection conn) {
		 try {
			 if (null != conn)
			 {
				 conn.close();
				 conn = null;
			 }
		 } 
    catch (SQLException e)
    {
        e.printStackTrace();

    }
		 return conn;
	}

	 public  ResultSet closeResultset(ResultSet rs) {
		 try {
			 if (null != rs) {
				 rs.close();
				 rs = null;
			 }
        
    } catch (SQLException e) {
        e.printStackTrace();

    }
		 return rs;
}

public Statement closeStatement(Statement stmt) {
    try {
        if (null != stmt) {
            stmt.close();
            stmt = null;
        }
    } catch (SQLException e) {
        e.printStackTrace();

    }
    return stmt;
}


/*public static void main(String [] arg) throws ClassNotFoundException, SQLException
{	
	Dbutilityfile db_file= new Dbutilityfile();
	String cust_order_number="SRV461";
	System.out.println("test1");
	db_file.getConnection();
	System.out.println("test2");
	db_file.getresultset(conn,cust_order_number);
	System.out.println("test3");
	db_file.closeResultset(rs);
	System.out.println("test4");
	db_file.closeStatement(stmt);
	System.out.println("test5");
	db_file.closeConnection(conn);
	System.out.println("test6..complete");
	
}*/

}
    	
    
	