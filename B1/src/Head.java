import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class Head implements ActionListener, ItemListener{
	private JLabel label;
	private JTextArea dateshow;
	private JTextArea dataOut;
	private JLabel sumlabel;
	private JTextArea sumOut;
	private JComboBox<String> branchc;
	private JButton showOrder;
	private JButton aprOrder;
    private Container tab;
    private CardLayout clayout;
	private JPanel headPanel;
	private JPanel buttonPanel1;
	private JPanel buttonPanel2;
	private JPanel functionPanel;
	private JPanel sumPanel;
	private JFrame jframe;
	
	private Connection con;
	private PreparedStatement pstmt;
	private HashMap<String, String> brtablelist;
	
	
	public Head() {}
	public Head(Connection con) throws SQLException {
		this.con = con;
		label = new JLabel("본사");
		brtablelist = new HashMap<String,String>();
		// 보완필요 if문 반복을 피하기 위해서 hashmap으로 코드를 짰는데 프로그램 실행할 때마다 반복해서 put메서드를 실행해줘야 하는게... 
		brtablelist.put("강남점", "kangnam");
		brtablelist.put("모란점", "moran");
		
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat simple= new SimpleDateFormat("YY-MM-dd");
		dateshow = new JTextArea();
		dateshow.setText(simple.format(now)); // textArea에 날짜 표시
		dateshow.setEditable(false);
		
		headPanel = new JPanel();
		headPanel.setLayout(new BorderLayout());
		headPanel.add(label,BorderLayout.WEST);
		headPanel.add(dateshow,BorderLayout.EAST);
		
		dataOut= new JTextArea(40,30);
		 JScrollPane jsp = new JScrollPane(dataOut,
	        		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	        		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		 String[]list = {"지점선택","본사","강남점","모란점"};
		branchc = new JComboBox<String>(list);
		branchc.addItemListener(this);
		
		showOrder = new JButton("주문조회");
		showOrder.addActionListener(this);
		buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BorderLayout());
		buttonPanel1.add(showOrder,BorderLayout.CENTER);		
		aprOrder = new JButton("승인");
		aprOrder.addActionListener(this);
		buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BorderLayout());
		buttonPanel2.add(aprOrder,BorderLayout.CENTER);
		
		
		
		 tab = new JPanel();
	     clayout = new CardLayout();
	     tab.setLayout(clayout);
	     tab.add(buttonPanel1, "show");
	     tab.add(buttonPanel2, "approve");
	     
		sumlabel = new JLabel("매출합계");
		sumOut = new JTextArea();
		sumPanel = new JPanel();
		sumPanel.setLayout(new BorderLayout());
		sumPanel.add(sumlabel,BorderLayout.WEST);
		sumPanel.add(sumOut,BorderLayout.CENTER);
		
		functionPanel = new JPanel();
		functionPanel.setLayout(new BorderLayout());
		functionPanel.add(branchc,BorderLayout.NORTH);
		functionPanel.add(tab,BorderLayout.CENTER);
		functionPanel.add(sumPanel,BorderLayout.SOUTH);
		
		clayout.show(tab, "show");
		jframe = new JFrame("재고관리 프로그램");
		jframe.setLayout(new BorderLayout());
		jframe.add(headPanel,BorderLayout.NORTH);
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(functionPanel,BorderLayout.EAST);
		
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if( obj== showOrder) {

			String branch,code,name="";
			Date aprdate,orderdate;
			int idx,unitprice,quantity,totalprice=0;
			try {
				dataOut.setText(""); //데이터창 초기화
				dataOut.append("주문번호	주문지점	주문일	코드	품명	단가	수량	금액	처리일"); //컬럼명 출력
				dataOut.append("\n");
				pstmt = con.prepareStatement("select * from convenience.order order by aprdate;");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					idx = rs.getInt("idx");
					//서로다른 지점에서 같은 날 같은제품을 주문했을 경우에 구분이 필요해서 PK로 지정할 일련번호? 주문번호가 필요함
					branch = rs.getString("branch");
					orderdate = rs.getDate("orderdate");
					code = rs.getString("code");
					name = rs.getString("name");
					unitprice = rs.getInt("unitprice");
					quantity = rs.getInt("quantity");
					totalprice = rs.getInt("totalprice");
					aprdate = rs.getDate("aprdate");
				//값을 하나씩 읽어와서 변수에 대입
				dataOut.append( idx +"\t"+branch+"\t"+orderdate+"\t"+code+"\t"+ name +"\t"
				+ unitprice+"\t"+quantity +"\t"+  totalprice+"\t"+aprdate);
				//데이터 창에 출력
				dataOut.append("\n");
			}
			clayout.show(tab, "approve"); //버튼 바꾸기
			} catch (Exception ex) {
				// TODO: handle exception
			}	
		}
		else if(obj==aprOrder) {
			try {
	
				pstmt = con.prepareStatement("select idx, aprdate from  convenience.order where aprdate is null;");
				//승인일란이 공란인 데이터를 가져옴
				ResultSet rs = pstmt.executeQuery(); //쿼리문 실행
				ArrayList<Integer>list = new ArrayList<Integer>(); //idx를 넣을 arraylist 변수 선언
				while(rs.next()) {
					list.add(rs.getInt("idx")); //각 데이터의 idx(주문번호)를 가져와서 list에 넣음
				}
				int size = list.size();
				for(int i=0;i<size;i++) {
				pstmt = con.prepareStatement("update convenience.order set aprdate = now() where idx = ?;"); 
				// 내부함수를 써서 오늘 날짜로 승인일 변경
				pstmt.setInt(1, list.get(i)); 
				//list에서 값을 하나씩 읽어서 order테이블에서 일치하는 행의 데이터를 가져와서 오늘 날짜로 승인일 입력
				pstmt.executeUpdate();
				//본사 재고에서 빼서 지점 재고로 넣는 코드 필요 
				}
				
				clayout.show(tab, "show");
			} catch (Exception e2) {
				// TODO: handle exception
			}	
						
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		
		String code,name,shpoint="";
		Date shipping,receiving;
		int quantity,unitprice,totalprice=0;
		Timestamp expiry;
		
		String choice = branchc.getSelectedItem().toString();
	try {
		if(choice.equals("지점선택")){} //지점선택은 아무런 행동 x
		
		else if(choice.equals("본사")) { //본사 테이블과 지점 테이블 컬럼이 달라서 본사만 따로 분리
			pstmt = (PreparedStatement)con.prepareStatement("select * from convenience.head order by expiry;");
			ResultSet rs = pstmt.executeQuery();
			dataOut.setText("");
			dataOut.append("코드	품명	수량	단가	금액	입고날짜	출고날짜	유통기한	출고지점");
			dataOut.append("\n");
			
			while(rs.next()) {
				code = rs.getString("code");
				name = rs.getString("name");
				quantity = rs.getInt("quantity");
				unitprice = rs.getInt("unitprice");
				totalprice = rs.getInt("totalprice");
				receiving = rs.getDate("receiving");
				shipping = rs.getDate("shipping");
				expiry = rs.getTimestamp("expiry");
				shpoint = rs.getString("shpoint");
				
				dataOut.append(code+"\t"+ name + "\t"+quantity + "\t"+unitprice + "\t"+totalprice +"\t"+receiving +"\t"+ shipping + "\t"+expiry + "\t"+shpoint);
				dataOut.append("\n");
			}
		}
		
		else  {
			Date saledate;


			dataOut.setText("");
			dataOut.append("코드	품명	수량	단가	금액	입고날짜	판매일	유통기한");
			dataOut.append("\n");
			String branch=brtablelist.get(choice); //한글지점명을 key로 value인 영어 테이블 값을 가져와서 branch에 대입
			
		
				if(branch!=null) {
					PreparedStatement pstmt = con.prepareStatement("select * from convenience."+branch+ " order by expiry;");
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {

						code = rs.getString("code");
						name = rs.getString("name");
						quantity = rs.getInt("quantity");
						unitprice = rs.getInt("unitprice");
						totalprice = rs.getInt("totalprice");
						receiving = rs.getDate("receiving");
						saledate = rs.getDate("saledate");
						expiry = rs.getTimestamp("expiry");
						
						dataOut.append(code+ "\t"+name + "\t"+quantity +"\t"+ unitprice + "\t"+totalprice +"\t"+receiving +"\t"+ saledate +"\t"+ expiry);
						dataOut.append("\n");
					}
				}
			
			}	
			
					
		
	} catch (Exception e) {
		// TODO: handle exception
	}	
		
		
	}

}