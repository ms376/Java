import java.sql.*;


public class Connect {
	
	public static Connection makeConnection()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 주소
		String id = "root"; 
		String password = "1234";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
			
		return con;
	}
}