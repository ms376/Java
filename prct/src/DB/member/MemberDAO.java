package DB.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDAO implements DAO {

	/* (non-Javadoc)
	 * @see com.kysoft.member.DAO#getConnection()
	 */
	@Override
	public Connection getConnection() throws ClassNotFoundException, Exception {
		
		Connection con = null; // JDBC와의 연결 객체 초기화
		
		try{
		Class.forName(oracleDriver); // JDBC Driver 검색
		con = DriverManager.getConnection(oracleURL,oracleId,oraclePw); // JDBC URL -> DB 연결
		
		} catch(ClassNotFoundException e){ // JDBC driver 부재시 예외처리
			System.out.println("예외처리 1:"+e.getMessage()); // 예외 메시지 (console) 인쇄
			e.printStackTrace();
		} catch(Exception e){ // 모든 예외상황 처리
			System.out.println("예외처리 2:"+e.getMessage());
			e.printStackTrace();
		} finally {
			// System.out.println("JDBC 드라이버와 연결되었습니다");
		}
		return con;
	}

	/* (non-Javadoc)
	 * @see com.kysoft.member.DAO#getMembers()
	 */
	@Override
	public ArrayList<Member> getMembers() throws SQLException, Exception {
		
		Connection con = null;
		PreparedStatement pstmt = null; // 미리처리하기 때문에 쓴다. (빠르다)
		// Statement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Member> members = new ArrayList<Member>();
		Member member;
		// DB Table 의 1개의 레코드(record : row)를 불러오기 위한 temp(임시) 변수
		
		con = getConnection();
		String sql = "SELECT * FROM MEMBER2";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
					//pstmt = con.createStatement(); -> 
					//sql을 후에 처리 \ PraparedStatement 보다 SQL 구문 처리가 한단계 
                                        //늦기 때문에 SQL 처리 성능이 저하
					//rs = pstmt.executeQuery(sql);
					//※ CallableStatement : PL/SQL 처리할때 사용
					
			while(rs.next()){
				
				member = new Member(); // temp
				
				member.setId(rs.getString("id")); // id 필드값을 가져옴
				member.setBlack_id(rs.getString("black_id")); // pw 필드값을 가져옴
				
				members.add(member); // 한명의 정보 -> 전체 인원 현황 객체
			}
		
			 rs.close();
			 pstmt.close();
			 con.close();
			
		} catch(SQLException e) {
			System.out.println("예외처리 3:"+e.getMessage()); // 예외 메시지 (console) 인쇄
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("예외처리 4:"+e.getMessage());
			e.printStackTrace();
		}
		
		return members;
	}
//	try {
//		pstmt = con.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		
//				//pstmt = con.createStatement(); -> 
//				//sql을 후에 처리 \ PraparedStatement 보다 SQL 구문 처리가 한단계 
//                                    //늦기 때문에 SQL 처리 성능이 저하
//				//rs = pstmt.executeQuery(sql);
//				//※ CallableStatement : PL/SQL 처리할때 사용
//				
//		while(rs.next()){
//			
//			member = new Member(); // temp
//			
//			member.setId(rs.getString("id")); // id 필드값을 가져옴
//			member.setPw(rs.getString("pw")); // pw 필드값을 가져옴
//			
//			members.add(member); // 한명의 정보 -> 전체 인원 현황 객체
//		}
//	
//		 rs.close();
//		 pstmt.close();
//		 con.close();
//		
//	} catch(SQLException e) {
//		System.out.println("예외처리 3:"+e.getMessage()); // 예외 메시지 (console) 인쇄
//		e.printStackTrace();
//	} catch(Exception e) {
//		System.out.println("예외처리 4:"+e.getMessage());
//		e.printStackTrace();
//	}
//	
//	return members;
//}
}

