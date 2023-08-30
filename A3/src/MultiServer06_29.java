import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MultiServer06_29
{
	 ArrayList<Member> members;
	static Connection con;
	Map<String, String> listw;
	Map<String, String> inviteM;
	Map<String, PrintWriter> waitUser; // 대기방 사용자
	Map<String, Map<String, PrintWriter>> roomN; // 공개방 해시맵
	Map<String, Map<String, PrintWriter>> roomP; // 비밀방
	Map<String, Integer> capa; // 각방의 정원
	Map<String, String> pwd; // 비밀방의 비밀번호
	static ServerSocket serverSocket;
	static Socket socket = null;
	Map<String, PrintWriter> clientMap;

	// ID를 KEY로 해서 스레드를 VALUE로 갖고 있는 HASHMAP

	Date now = new Date(System.currentTimeMillis());
	SimpleDateFormat simple = new SimpleDateFormat("(a hh:mm)");

	// 채팅내용 옆에 시간을 같이 출력하기 위해서 현재시간에 포맷을 지정

	public MultiServer06_29()
	{
		members = new ArrayList<>();
		inviteM = new HashMap<String, String>();
		waitUser = new HashMap<String, PrintWriter>();
		clientMap = new HashMap<String, PrintWriter>();
		roomN = new HashMap<String, Map<String, PrintWriter>>();
		capa = new HashMap<String, Integer>();
		pwd = new HashMap<String, String>();
		listw = new HashMap<String, String>();
		Collections.synchronizedMap(clientMap);

		listw.put("/list", "모든 사용자 리스트");
		listw.put("/waituser", "대기방 유저 리스트");
		listw.put("/rlist", "채팅방 리스트 출력");
		listw.put("/adword", "개인 금칙어 설정 추가");
		listw.put("/delword", "개인 설정 금칙어 삭제");
		listw.put("/agree", "채팅방 초대 수락 명령어");

		// 해쉬맵 동기화 설정.
		Collections.synchronizedMap(inviteM);
		Collections.synchronizedMap(waitUser);
		Collections.synchronizedMap(roomN);
		Collections.synchronizedMap(clientMap);
		Collections.synchronizedMap(capa);
		Collections.synchronizedMap(pwd);

	}

	public MultiServer06_29(Socket socket)
	{

		clientMap = new HashMap<String, PrintWriter>();
		Collections.synchronizedMap(clientMap);
	}

	public void init()
	{

		try
		{
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "MChat";
			String password = "123";
			con = DriverManager.getConnection(url, user, password);

			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");
			// Perform login process
			login(socket);
			while (true)
			{
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속하였습니다.");
				login(socket);
				Thread msr = new MultiServerT(socket);
				msr.start();
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (serverSocket != null)
				{
					serverSocket.close();
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public void list(PrintWriter out)
	{
		Iterator<String> it = clientMap.keySet().iterator();
		String msg = "사용자리스트 [";
		while (it.hasNext())
		{
			msg += (String) it.next() + ",";
		}
		msg = msg.substring(0, msg.length() - 1) + "]";
		try
		{
			out.println(msg);
		} catch (Exception e)
		{
		}
	}

	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MChat";
		String password = "123";

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("오라클 드라이버됨"); //확인용

			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("conn ="+conn); // 확인용
			stmt = conn.createStatement();
			StringBuffer sql = new StringBuffer();
			sql.append("create table test1;"); // test
			sql.append("drop table test1;"); // test
		} catch (ClassNotFoundException e)
		{
			System.out.println("오라클 드라이버 클래스를 못찾음");
		} catch (SQLException e)
		{
			System.out.println("sql오류" + e.getMessage());
		} finally
		{
			try
			{
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e)
			{
			}
		}

		MultiServer06_29 ms = new MultiServer06_29();
		ms.init();

	}

	class MultiServerT extends Thread
	{

		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		String name = "";

		public MultiServerT(Socket socket)
		{
			super();
			this.socket = socket;
			try
			{
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			} catch (Exception e)
			{
				System.out.println("예외:" + e);
			}
		}

		public void run()
		{
			String s = "";
			try
			{
				name = in.readLine();
				System.out.println("[" + name + "]님이 대화방에 입장하셨습니다.");
				sendAllMsg(name + "님이 입장하셨습니다.", "");
				clientMap.put(name, out);
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
				while ((s = in.readLine()) != null)
				{
					if (s.equals("q") || s.equals("Q"))
						break;
					if (s.trim().isEmpty())
						continue;

					System.out.println(name + " > " + s);
					if (s.equals("/list"))
						list(out);
					else
						sendAllMsg(s, name);
				}
				System.out.println("쓰레드 종료.");
			} catch (Exception e)
			{
				System.out.println("예외:" + e);
			} finally
			{
				clientMap.remove(name);
				sendAllMsg(name + "님이 퇴장하셨습니다.", "");
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
				try
				{
					in.close();
					out.close();
					socket.close();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		public void sendAllMsg(String msg, String name)
		{
			Iterator<String> it = clientMap.keySet().iterator();
			while (it.hasNext())
			{
				try
				{
					PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
					if (name.equals(""))
					{
						it_out.println(msg);
					} else
					{
						it_out.println(name + " > " + msg);
					}
				} catch (Exception e)
				{
					System.out.println("예외:" + e);
				}
			}
		}
	}

	   public static class Member {
	        private String id;
	        private String pw; // Add pw field
	        private String name;
	        private String email;

	        public String getId() {
	            return id;
	        }

	        public void setId(String id) {
	            this.id = id;
	        }

	        public String getPw() {
	            return pw;
	        }

	        public void setPw(String pw) {
	            this.pw = pw;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setName(String name) {
	            this.name = name;
	        }

	        public String getEmail() {
	            return email;
	        }

	        public void setEmail(String email) {
	            this.email = email;
	        }
	    }


	public static ArrayList<Member> getMembers() throws SQLException, Exception
	{

		Connection con = null; // Assign null to con
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Member> members = new ArrayList<Member>();
		Member member;
		String sql = "SELECT * FROM USERS";

		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mchat", "123"); // Initialize con
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// pstmt = con.createStatement(); ->
			// sql을 후에 처리 \ PraparedStatement 보다 SQL 구문 처리가 한단계
			// 늦기 때문에 SQL 처리 성능이 저하
			// rs = pstmt.executeQuery(sql);
			// ※ CallableStatement : PL/SQL 처리할때 사용

			while (rs.next())
			{
				member = new Member(); // Initialize the member object

				member.setId(rs.getString("id")); // id 필드값을 가져옴
				member.setPw(rs.getString("pw")); // pw 필드값을 가져옴

				members.add(member); // 한명의 정보 -> 전체 인원 현황 객체
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e)
		{
			System.out.println("예외처리 3:" + e.getMessage()); // 예외 메시지 (console) 인쇄
			e.printStackTrace();
		} catch (Exception e)
		{
			System.out.println("예외처리 4:" + e.getMessage());
			e.printStackTrace();
		}

		return members;
	}

//	public void login(Socket socket) {
//	    try {
//	        if (socket == null) {
//	            System.out.println("소켓이 null입니다.");
//	            return;
//	        }
//	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//	        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//	        Scanner s = new Scanner(System.in);
//
//	        ArrayList<Member> members = getMembers();  // getMembers() 메서드를 호출하여 members 리스트 초기화
//
//	        HashMap<String, String> map = new HashMap<String, String>();
//	        for (Member member : members) {
//	            map.put(member.getId(), member.getPw());  // map 해시맵에 데이터 추가
//	        }
//			while (true)
//			{	
//				out.println(map); // 코딩용 정보
//				out.println("id와 password를 입력해주세요.");
//				out.println("id :");
//				String id = in.readLine();
//
//				// Perform login validation
//				if (map.containsKey(id))
//				{
//					out.println("password :");
//					String password = in.readLine();
//					if (map.get(id).equals(password))
//					{
//						out.println("성공적으로 로그인되었습니다.");
//						System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 로그인 성공!");
//						break;
//					} else
//					{
//						out.println("비밀번호가 맞지 않습니다.");
//					}
//				} else
//				{
//					out.println("아이디가 잘못 되었습니다.");
//				}
//			}
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	public void login(Socket socket)
	{
		try
		{
			if (socket == null)
			{
				System.out.println("소켓이 null입니다.");
				return;
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			Scanner s = new Scanner(System.in);

			ArrayList<Member> members = getMembers(); // getMembers() 메서드를 호출하여 members 리스트 초기화

			HashMap<String, String> map = new HashMap<String, String>();
			for (Member member : members)
			{
				map.put(member.getId(), member.getPw()); // map 해시맵에 데이터 추가
			}

			while (true)
			{
				out.println("id와 password를 입력해주세요.");
				out.println("id :");
				String id = in.readLine();
				
				if (map.containsKey(id))
				{
					out.println("password :");
					String pw = in.readLine();
					if (id.equals(id))
					{
						out.println("성공적으로 로그인되었습니다.");
						System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 로그인 성공!");
						break;
					} else
					{
						out.println("비밀번호가 맞지 않습니다.");
					}
				} else
				{
					out.println("아이디가 잘못 되었습니다.");

					// 회원가입 기능 추가
					out.println("회원가입을 진행하시겠습니까? (Y/N)");
					String choice = in.readLine();
					if (choice.equalsIgnoreCase("Y"))
					{
						out.println("이름 : ");
						String name = in.readLine();
						out.println("비밀번호 : ");
						String pw = in.readLine();
						out.println("이메일 : ");
						String email = in.readLine();

						if (!isDuplicated(members, id))
						{ // 아이디 중복 체크
							Member newMember = new Member();
							newMember.setId(id);
							newMember.setPw(pw);
							newMember.setName(name);
							newMember.setEmail(email);

							if (addMember(newMember))
							{ // 회원 추가
								out.println("회원가입이 완료되었습니다.");
								break;
							} else
							{
								out.println("회원가입 중 오류가 발생했습니다.");
							}
						} else
						{
							out.println("이미 사용 중인 아이디입니다. 다른 아이디를 선택해주세요.");
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean isDuplicated(ArrayList<Member> members, String id) 
	{
		for (Member member : members)
		{
			if (member.getId().equals(id))
			{
				return true; // 중복된 아이디가 있음
			}
		}
		return false; // 중복된 아이디
	}
	public boolean addMember(Member member) {
        try {
            // Check if the member already exists
            if (isDuplicated(members, member.getId())) {
                return false;
            }

            // Add the member to the list
            members.add(member);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
}

