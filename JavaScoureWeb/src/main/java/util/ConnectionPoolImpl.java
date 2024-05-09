package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPoolImpl implements ConnectionPool {

	public String driver;
	public String username;
	public String password;
	public String url;
	
	private Stack<Connection> pool;
	
	public ConnectionPoolImpl() {
		//xđ trình điều khiển
		this.driver = "com.mysql.cj.jdbc.Driver";
		
		//
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// xđ tk làm việc
		this.username = "truongweb";
		this.password = "123456789@";
		
		//
		this.url ="jdbc:mysql://localhost:3306/2023it6080001_data";
		
		this.pool = new Stack();
	}
	
	@Override
	public Connection getConnection(String objectName) throws SQLException {
		// TODO Auto-generated method stub
		
		if(this.pool.isEmpty()) {
			System.out.println(objectName + "đã khơi tạo kết nối mới");
			return DriverManager.getConnection(this.url, this.username, this.password);
		} else {
			System.out.println(objectName + "đã lấy ra một kết nối");
			return this.pool.pop();
		}
	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println(objectName + "đã thu hồi một kết nối");
		this.pool.push(con);
	}

	protected void finalize()throws Throwable{
		this.pool.clear();
		this.pool = null;
		
		System.out.println("CPool đã kết thúc để CPool mới ra đời.");
	}
}
