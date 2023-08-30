package DB.member;


public class Member { // DB table(member2)의 일치
	
	private String id; // id field (varchar2(20) : PK)
	private String black_id; // pw field (varchar2(20))
	
	public String getId() {
		return id;
	}
	public String getBlack_id() {
		return black_id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBlack_id(String pw) {
		this.black_id = pw;
	}
}