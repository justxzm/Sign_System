package just.ca.UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

public class MenuFrame extends JFrame implements ActionListener{
	JButton sign;
	JButton edit;
	JButton help;
	JButton exit;
	JButton label;
	String username;
	public MenuFrame(String username){
		this.username=username;
		this.setSize(550,400);
		this.setTitle("欢迎["+username+"]登陆计协签到系统1.1.1");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.add(createContentPanel());
		this.setResizable(false);
	}
	private Component createContentPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		ImageIcon icon=new ImageIcon(this.getClass().getResource("smile.png"));
		label=new JButton(icon);
		label.setBorderPainted(false);
		label.addActionListener(this);
		panel.add(label,BorderLayout.NORTH);
		panel.add(createCenterPanel(),BorderLayout.CENTER);
		JLabel eLabel=new JLabel("版权所有，盗版必杀！科大计协2015",JLabel.RIGHT);
		panel.add(eLabel,BorderLayout.SOUTH);
		return panel;
	}
	private Component createCenterPanel() {
		 JPanel panel=new JPanel(new BorderLayout());
		 JLabel WelLabel=new JLabel("欢迎加入计协！",JLabel.CENTER);
		 panel.add(WelLabel,BorderLayout.NORTH);
		 panel.add(createButtonPanel(),BorderLayout.CENTER);
		 return panel;  
	}
	private Component createButtonPanel() {
		JPanel panel=new JPanel();
		   sign=createImageButton("sign.png","Sign");
		   sign.addActionListener(this);
		   edit=createImageButton("preview.png","Preview");
		   edit.addActionListener(this) ;
		   help=createImageButton("help.png","Help");
		   help.addActionListener(this) ;
		   exit=createImageButton("exit.png","Exit");
		   exit.addActionListener(this) ;
		   panel.add(sign);
		   panel.add(edit);
		   panel.add(help);
		   panel.add(exit);
		   return panel;
	}
	private JButton createImageButton(String img, String text) {
		ImageIcon icon=new ImageIcon(this.getClass().getResource(img));
		JButton button=new JButton(text,icon);
		button.setVerticalTextPosition(JButton.BOTTOM);    
		button.setHorizontalTextPosition(JButton.CENTER);
		return button;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==label){
			JFrame frame=new JFrame();
			frame.setTitle("请记住我的微笑");
			frame.setSize(505,310);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			SmilePanel panel=new SmilePanel();
			panel.SleepMethodTest();
			panel.startRun();
			frame.add(panel);
			frame.setResizable(false);
		}else if(e.getSource()==exit){
			this.setVisible(false);
			ExitFrame frame=new ExitFrame(username);
			frame.setVisible(true);
		}else if(e.getSource()==help){
			JFrame frame=new JFrame();
			frame.setTitle("计协简介");
			frame.setSize(402,566);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			BallPanel panel=new BallPanel();
			panel.startrun();
			frame.add(panel);
		}else if(e.getSource()==sign){
			this.setVisible(false);
			SignFrame frame=new SignFrame(username);
			frame.setVisible(true);
		}else if(e.getSource()==edit){
			ProgressBarFrame frame=new ProgressBarFrame();
			frame.setTitle("读取数据");
			frame.setSize(330,150);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
		}
	}
}
