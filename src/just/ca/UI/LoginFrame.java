package just.ca.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import just.ca.Dao.AdministratorDao;
import just.ca.Dao.AdministratorDaoImpl;
import just.ca.UI.MenuFrame;
import just.ca.einity.Administrator;

public class LoginFrame extends JFrame implements ActionListener{
	JPasswordField pwdField;
	JTextField idField ;
	JLabel errorLabel;
	JButton login;
	JButton registered;
	JButton modifypwd;
	JButton cancel;
	public LoginFrame(){
		init();                                                                     
	}
	private void init() {
		this.setTitle("计协培训签到系统登陆1.1.1");
		this.setSize(450,280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(createContentPanel());   
		this.setResizable(false);
	}
	private Component createContentPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10,10,10,10));  
		ImageIcon icon = new ImageIcon(this.getClass().getResource("login.png"));
		panel.add(BorderLayout.NORTH, new JLabel(icon));
		panel.add(createCenterPane(),BorderLayout.CENTER);
		panel.add(createButtonPane(),BorderLayout.SOUTH);
		return panel;
	}
	private Component createButtonPane() {
		JPanel panel=new JPanel(new GridLayout(1,4));
	    login=new JButton("Login");
		login.addActionListener(this);
		login.setVerticalTextPosition(JButton.BOTTOM);
		login.setHorizontalTextPosition(JButton.CENTER);
		cancel=new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){    
			public void actionPerformed(ActionEvent e) { 
	        	   pwdField.setText(null);
	        	   idField.setText(null) ;
	        	   errorLabel.setText(null);
	          }
		});
		registered=new JButton("Registered");
		registered.addActionListener(this);
		modifypwd=new JButton("ModifyPwd");
		modifypwd.addActionListener(this);
		panel.add(login);
		panel.add(registered);
		panel.add(modifypwd);
		panel.add(cancel);
		return panel;
	}
	private Component createCenterPane() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(8,8,0,8));
		panel.add(createIdPwdnewPane(),BorderLayout.NORTH);
		errorLabel=new JLabel("",JLabel.CENTER);
		panel.add(errorLabel,BorderLayout.CENTER);
		return panel;
	}
	private Component createIdPwdnewPane() {
		JPanel panel=new JPanel(new GridLayout(3,1));  
		panel.add(createIdPane());
		panel.add(new JPanel());
		panel.add(creatPwdPane());
		return panel;
	}
	private Component creatPwdPane() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(BorderLayout.WEST,new JLabel("Password："));
		pwdField=new JPasswordField();
		panel.add(pwdField,BorderLayout.CENTER);
		return panel;
	}
	private Component createIdPane() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(BorderLayout.WEST,new JLabel("   Account："));
        idField=new JTextField();
		panel.add(idField,BorderLayout.CENTER);
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			int administratorNumber=getadministratorNumber();
			AdministratorDao dao=new AdministratorDaoImpl();
			boolean isExit=false;
			try{
				List<Administrator> administrators=dao.findAll();
				for(Administrator administrator:administrators){
					if(administrator.getNumber()==administratorNumber){
						isExit=true;
					}
		  	  }
				if(isExit){
					String administratorPwd=pwdField.getText();
					Administrator administrator=dao.findById(administratorNumber);
		    		if(administrator.getPassword().equals(administratorPwd)){
		    			AdministratorDao dao2=new AdministratorDaoImpl();
		    			Administrator test=new Administrator();
		    			test=dao2.findById(getadministratorNumber());
		    			String str1=test.getName();
		    			String str2=test.getPassword();
		    			dao2.modify(getadministratorNumber());
		    			dao2.insert2(getadministratorNumber(), str1, str2,0);	    		
		    			this.setVisible(false);
		    			MenuFrame frame=new MenuFrame(str1);
		    			frame.setVisible(true);
		    		}else{
		    			showError("密码错误，请重新输入！");
		    		}
				}else{
					showError("用户名不存在，请重新输入！");
				}
			}catch(Exception el){
				el.printStackTrace();
			}
		}else if(e.getSource()==registered){
			this.setVisible(false);
			RegisteredFrame frame=new RegisteredFrame();		
			frame.setVisible(true);
		}else if(e.getSource()==modifypwd){
			this.setVisible(false);
			ModifyFrame frame=new ModifyFrame();
			frame.setVisible(true);
		}
	}
	private void showError(String string) {
		errorLabel.setText(string);
		errorLabel.setForeground(Color.red);	
	}
	private int getadministratorNumber() {
		String numstr=idField.getText();
		int administratorNumber=Integer.parseInt(numstr);
		return administratorNumber;
	}
}
