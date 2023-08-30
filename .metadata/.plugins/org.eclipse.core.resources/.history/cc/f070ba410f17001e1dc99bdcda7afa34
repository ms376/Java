import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Order implements ActionListener{
	private JLabel codeLabel;
	private JTextField codeinput;
	private JPanel codePanel;
	private JLabel quanLabel;
	private JTextField quaninput;
	private JPanel quanPanel;
	private JButton insertButton;
	private JFrame order;
	
	private Connection con;
	private String id;
	private Info info;
	private PreparedStatement pstmt;
	
	public Order(){}
	public Order(Connection con, String id){
	this.con = con;
	this.id = id;
	
	codeLabel = new JLabel("코드");
	codeinput = new JTextField(5);
	codePanel = new JPanel();
	codePanel.setLayout(new BorderLayout());
	codePanel.add(codeLabel,BorderLayout.WEST);
	codePanel.add(codeinput,BorderLayout.EAST);
	
	quanLabel = new JLabel("주문량");
	quaninput = new JTextField(5);
	quanPanel = new JPanel();
	quanPanel.setLayout(new BorderLayout());
	quanPanel.add(quanLabel,BorderLayout.WEST);
	quanPanel.add(quaninput,BorderLayout.EAST);
	insertButton = new JButton("입력");
	insertButton.addActionListener(this);
	
	order = new JFrame("주문창");
	order.setLayout(new BorderLayout());
	order.add(codePanel, BorderLayout.NORTH);
	order.add(quanPanel, BorderLayout.CENTER);
	order.add(insertButton,BorderLayout.SOUTH);
	
	order.pack();
	order.setResizable(false);
	order.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == insertButton ) {
			try {

				String branch="";
				if(id.startsWith("kn")) branch =  "강남점";
				else if(id.startsWith("mr")) branch =  "모란점";
				
				String code = codeinput.getText();
				info = new Info().serch(con, code);
				String name = info.name;
				int unitprice = info.unitprice;
				int quantity = Integer.parseInt(quaninput.getText());
				int totalprice = unitprice*quantity;
				
				pstmt = con.prepareStatement("insert into  convenience.order "
						+ "( branch, orderdate, code, name, unitprice, quantity, totalprice) values (?,now(),?,?,?,?,?);");
				
				pstmt.setString(1, branch);
				pstmt.setString(2, code);
				pstmt.setString(3,name);
				pstmt.setInt(4,unitprice);
				pstmt.setInt(5,quantity);
				pstmt.setInt(6,totalprice);
				pstmt.executeUpdate();
				// 각 물음표에 넣을 값을 설정해주고 쿼리문 실행
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			

	}
}
}