import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Info { //상품코드를 기반으로 상품리스트에서 정보를 가져오는 클래스
	public String name;
	public int unitprice;
	Connection con;
	java.sql.Statement stmt;
	
	public Info serch(Connection con, String code) throws SQLException {
		this.con = con;
		Info info = new Info();
		
		stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select name, unitprice from product where code='"+code+"'"); //code와 일치하는 행을 찾아서 
		rs.next();
		info.name = rs.getString("name"); //제품이름과
		info.unitprice = rs.getInt("unitprice"); //단가를 멤버변수에 대입해서
		return info; //info객체 반환
		
		
	}
}