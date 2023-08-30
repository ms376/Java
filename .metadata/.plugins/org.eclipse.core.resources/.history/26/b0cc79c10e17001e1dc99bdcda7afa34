import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Stockmanage implements ActionListener {
	  
	   
	    private JPanel idPanel;
	    
	    private JLabel idlabel;
	    private JTextField idInput;
	    private JLabel passlabel;
	    private JTextField passInput;
	    private JPanel passPanel;
	    private JButton loginButton;
	    
	    private JFrame jframe;
	   
	    private Connection con;
	    

	   public Stockmanage() {
		   
		   idlabel = new JLabel("ID");
		   idInput = new JTextField(15);
		   idPanel = new JPanel();
		   idPanel.setLayout(new BorderLayout());
		   idPanel.add(idlabel,BorderLayout.WEST);
		   idPanel.add(idInput,BorderLayout.CENTER);
		   
		   passlabel = new JLabel("비밀번호");
		   passInput = new JTextField(15);
		   passPanel = new JPanel();
		   passPanel.setLayout(new BorderLayout());
		   passPanel.add(passlabel,BorderLayout.WEST);
		   passPanel.add(passInput,BorderLayout.CENTER);
		   
		   
		   loginButton = new JButton("로그인");
		   loginButton.addActionListener(this);
		   
		
		   
		   jframe = new JFrame("재고관리 프로그램");
		   jframe.setLayout(new BorderLayout());
		   jframe.add(idPanel,BorderLayout.NORTH);
		   jframe.add(passPanel,BorderLayout.CENTER);
		   jframe.add(loginButton,BorderLayout.SOUTH);
		   
		   jframe.pack();
		   jframe.setLocationRelativeTo(null);
		   jframe.setVisible(true);
		   
		   
		      
	   }
	   
		@Override
		public void actionPerformed(ActionEvent e) {
			  Object obj = e.getSource();

			  
		        if(obj == loginButton) {
		        	String id = idInput.getText();
		        	String password = passInput.getText();
		        	
		        	if(id.equals("head") && password.equals( "0000")) {
		        		jframe.setVisible(false);
		        		try {
		        			con = Connect.makeConnection();
							new Head(con);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		        		
		        	}
		        	else if((id.equals("knbranch")|| (id.equals("mrbranch")))&& password.equals("0011")) {
		        		jframe.setVisible(false);
		        		con = Connect.makeConnection();
		        		new Branch(id,con);
		        		
		        	}
		        	else {
			   				JOptionPane.showMessageDialog(null, "일치하는 계정정보가 없습니다. "
			   						+ "다시 확인하세요","알림", JOptionPane.ERROR_MESSAGE);
			   
		        	}
		        }
		       
			
		}
	

	public static void main(String[] args) {
		new Stockmanage();

	}


}