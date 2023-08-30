import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Branch implements ActionListener{
	private JLabel label;
	private JTextArea dateshow;
	private JTextArea dataOut;
	private JLabel sumlabel;
	private JTextArea sumOut;
	private JButton showButton;
	private JButton orderButton;
	private JPanel headPanel;
	private JPanel functionPanel;
	private JPanel sumPanel;
	private JPanel buttonPanel;
	private JFrame jframe;
	
	
	
	private Connection con;
	private String id;
	
	
	public Branch() {};
	public Branch(String id,Connection con) {
		this.id = id;
		this.con = con;
		label = new JLabel("지점");
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat simple= new SimpleDateFormat("YY/MM-dd");
		dateshow = new JTextArea();
		
		dateshow.setText(simple.format(now));
		dateshow.setEditable(false);
		headPanel = new JPanel();
		headPanel.setLayout(new BorderLayout());
		headPanel.add(label,BorderLayout.WEST);
		headPanel.add(dateshow,BorderLayout.EAST);
		
		dataOut= new JTextArea(30,30);
		
		
		
		sumlabel = new JLabel("매출합계");
		sumOut = new JTextArea();
		sumPanel = new JPanel();
		sumPanel.setLayout(new BorderLayout());
		sumPanel.add(sumlabel,BorderLayout.WEST);
		sumPanel.add(sumOut,BorderLayout.CENTER);
		
		showButton = new JButton("조회");
		showButton.addActionListener(this);
		
		orderButton = new JButton("주문");
		orderButton.addActionListener(this);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(showButton,BorderLayout.CENTER);
		buttonPanel.add(orderButton,BorderLayout.AFTER_LAST_LINE);
		
		
		functionPanel = new JPanel();
		functionPanel.setLayout(new BorderLayout());
		functionPanel.add(sumPanel,BorderLayout.NORTH);
		functionPanel.add(buttonPanel,BorderLayout.CENTER);
		
		jframe = new JFrame("재고관리 프로그램");
		jframe.setLayout(new BorderLayout());
		jframe.add(headPanel,BorderLayout.NORTH);
		jframe.add(dataOut,BorderLayout.CENTER);
		jframe.add(functionPanel,BorderLayout.EAST);
		
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		
		
	}
	public static void main(String[] args) {

		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();

		if(obj == showButton) {
			String code,name="";
			Date receiving,saledate;
			int quantity,unitprice,totalprice;
			Timestamp expiry;
			String sql="";
			if(id.startsWith("kn")) sql = "select * from convenience.kangnam order by expiry;";
			else if(id.startsWith("mr")) sql = "select * convenience.moran order by expiry;";
			try {
				PreparedStatement psmt = (PreparedStatement)con.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				dataOut.setText("");
				dataOut.append("코드	품명	수량	단가	금액	입고날짜	판매일	유통기한");
				while(rs.next()) {
					code = rs.getString("code");
					name = rs.getString("name");
					quantity = rs.getInt("quantity");
					unitprice = rs.getInt("unitprice");
					totalprice = rs.getInt("totalprice");
					receiving = rs.getDate("receiving");
					saledate = rs.getDate("saledate");
					expiry = rs.getTimestamp("expiry");
					// 값을 한 줄씩 읽어와서 변수에 대입하고 dataOut에 출력
					dataOut.append(code+ "\t"+name + "\t"+quantity + "\t"+unitprice 
							+ "\t"+totalprice +"\t"+receiving + "\t"+saledate + "\t"+expiry+"\n");
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		else if(obj == orderButton) {
			new Order(con,id);
			
			
		}
		
	}

}