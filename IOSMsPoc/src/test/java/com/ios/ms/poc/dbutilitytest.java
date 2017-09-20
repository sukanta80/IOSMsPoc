package Test.java.com.ios.ms.poc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import main.java.com.ios.ms.poc.Dbutilityfile;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class dbutilitytest {
	static Connection connect=null;
	static Statement stmttest=null;
	static ResultSet rstest=null;
	static Dbutilityfile dbfile=new Dbutilityfile();
	
	@BeforeClass
	public static void beforeClass() throws ClassNotFoundException, SQLException //BeforeClass & Get connection
	{    
        connect = dbfile.getConnection();
       // assertEquals(connect != null, true);
        assertNotNull(connect);
    }
    
	@AfterClass
    public static void afterClass() throws SQLException 				//AfterClass & Close Connection
    	{
    		if (connect != null){
    		dbfile.closeConnection(connect);
    		assertTrue(connect.isClosed());
    		
    	}    	    	
    }

	
    @Test
	public void test1() throws SQLException     //Test: call Get result method @Dbutilityfile
	{
    	Scanner scanner = null;
    	try {
    	    scanner = new Scanner(System.in);
         	System.out.println("Enter Customer Order Number");  
    		String cust_order_id =scanner.next();
    		assertEquals(cust_order_id,dbfile.getresultset(connect,cust_order_id));
    		}    	
    	finally 
    	{
    	    if(scanner!=null)
    	      scanner.close();
    	        	}
	}
    
    @Test
    public void test2() throws SQLException {				// Close Result set
    	stmttest=connect.createStatement();
    	rstest=stmttest.getResultSet();
        dbfile.closeResultset(rstest);  
        assertTrue(rstest.isClosed());
    }

    @Test
    public void test3() throws SQLException 				// Close Statement
    {				
        dbfile.closeStatement(stmttest);
        assertTrue(stmttest.isClosed());
     }
    }


