package dbconection;

import java.sql.*;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dbconection {
	public static Connection conect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	final private String host= "localhost;3306";
	final private String user = "root";
	final private String password = "1234";
	public final String database ="instagram";
	public Object connect;
	public void conecToDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
					+ database + "?" + "user=" + user + "&password=" + password);
			if (conect !=null) {
				System.out.println("connect successfully !!");
			}
		} catch (Exception e) {
			System.out.println("connect fail !!");
		}
	}
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement !=null) {
				statement.close();
			}
			if (conect !=null) {
				conect.close();
			}
		} catch (Exception e) {

		}
	}
}
