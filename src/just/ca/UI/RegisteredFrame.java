package just.ca.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import just.ca.Dao.AdministratorDao;
import just.ca.Dao.AdministratorDaoImpl;
import just.ca.einity.Administrator;

public class RegisteredFrame extends JFrame implements ActionListener{
	JButton registered;
	JButton clear;
	JButton back;
	JLabel errorlabel1;
	JLabel errorlabel2;
	JLabel errorlabel3;
	JLabel errorlabel4;
	JLabel errorlabel5;
	JPasswordField textField1;
	JTextField textField2;
	JTextField textField3;
	JPasswordField textField4;
	JPasswordField textField5;
	public RegisteredFrame(){
		init();
	}
	private void init() {
		this.setTitle("高级管理员用户注册");			
		this.setSize(350,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(createContentPanel());
		this.setResizable(false);
	}
	private Component createContentPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(createUpPanel(),BorderLayout.NORTH);
		panel.add(createCenterPanel(),BorderLayout.CENTER);
		panel.add(createDownPanel(),BorderLayout.SOUTH);
		return panel;
	}
	private Component createUpPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(this.getClass().getResource("register.png"));
		panel.add(new JLabel(icon,JLabel.CENTER),BorderLayout.NORTH);
		JLabel label=new JLabel("注册高级管理员用户需先输入正确的会长手机号！");
		label.setFont(new Font("宋体",Font.BOLD,14));
		panel.add(label,BorderLayout.CENTER);
		return panel;
	}
	private Component createDownPanel() {
		JPanel panel=new JPanel(new GridLayout(1,2));
		panel.setBorder(new EmptyBorder(5,5,5,5));
		registered=new JButton("Registered");
		registered.addActionListener(this);
		registered.setVerticalTextPosition(JButton.BOTTOM);
		registered.setHorizontalTextPosition(JButton.CENTER);
		clear=new JButton("Clear");
		clear.addActionListener(new ActionListener(){    
			public void actionPerformed(ActionEvent e) { 
	        	   textField1.setText(null);
	        	   textField2.setText(null) ;
	        	   textField3.setText(null);
	        	   textField4.setText(null);
	        	   textField5.setText(null);
	          }
		});
		back=new JButton("Back");
		back.addActionListener(this);   
		panel.add(registered);
		panel.add(clear);
		panel.add(back);
		return panel;
	}
	private Component createCenterPanel() {
		JPanel panel=new JPanel(new GridLayout(5,3));
		panel.setBorder(new EmptyBorder(8,8,0,8));
		panel.add(new JLabel("Phone Number:"));
		textField1=new JPasswordField();
		panel.add(textField1);
		errorlabel1=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel1);
		panel.add(new JLabel("New Acount:"));
		textField2=new JTextField();
		panel.add(textField2);
		errorlabel2=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel2);
		panel.add(new JLabel("Name:"));
		textField3=new JTextField();
		panel.add(textField3);
		errorlabel3=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel3);
		panel.add(new JLabel("Password:"));
		textField4=new JPasswordField();
		panel.add(textField4);
		errorlabel4=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel4);
		panel.add(new JLabel("Confirm Pwd:"));
		textField5=new JPasswordField();
		panel.add(textField5);
		errorlabel5=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel5);
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			this.setVisible(false);
			 LoginFrame frame=new LoginFrame();
			   frame.setVisible(true);
		}else if(e.getSource()==registered){
			boolean tf1=textField1.getText().equals("123456789");
			if(!tf1){
				if(textField1.getText().equals("")){
					errorlabel1.setText("请先输入手机号！");
					errorlabel1.setForeground(Color.red);
				}else{
					errorlabel1.setText("手机号输入错误！");
					errorlabel1.setForeground(Color.red);
				}	
			}else{
				errorlabel1.setText("");
			}
			boolean tf2=textField4.getText().equals(textField5.getText());
			if(!tf2){
				errorlabel5.setText("请重新输入密码！");
				errorlabel5.setForeground(Color.red);
			}else{
				errorlabel5.setText("");
			}
			if(tf1&&tf2){
				AdministratorDao dao=new AdministratorDaoImpl();
				int n=Integer.parseInt(textField2.getText());
				try {
					dao.insert2(n, textField3.getText(), textField4.getText(),0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "恭喜你成功申请高级管理员用户！按确定返回"); 
				this.setVisible(false);
				LoginFrame frame=new LoginFrame();
			    frame.setVisible(true);
			}
		}
	}
}
