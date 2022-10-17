package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Sample2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
Statement stat = conn.createStatement();
String query = "insert into student(first_name,last_name,address)values('raja','hn','india')";
int result = stat.executeUpdate(query);
if(result==1)
{
	System.out.println("created");
}
else
{
	System.out.println("no");
}
	}

}
