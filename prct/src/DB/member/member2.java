package DB.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class member2
{
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		Connection con = null;
		Statement stmt = null;
		boolean success = false;
		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234");
			stmt = con.createStatement();
			con.setAutoCommit(false);
//----------------------------------------------------------------------------
			String sql = "insert into test3 values('홍길동2', '1111')";
			stmt.execute(sql);
			System.out.println("11111");

			sql = "insert into test3 values('전우치2', '2222')";
			stmt.execute(sql);
			System.out.println("22222");

			sql = "insert into test3 values('손오공2', '3333')";
			stmt.execute(sql);
			System.out.println("33333");
			success = true;
		} catch (SQLException sqle)
		{
			sqle.printStackTrace();
		} finally
		{
			try
			{
				if (success)
				{
					System.out.println("44444");
					con.commit();
				} else
				{
					System.out.println("55555");
					con.rollback();
				}
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle)
			{
			}
		}

	}

}