package just.ca.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import just.ca.Dao.AdministratorDao;
import just.ca.Dao.AdministratorDaoImpl;
import just.ca.Dao.MemberDao;
import just.ca.Dao.MemberDaoImpl;
import just.ca.einity.Administrator;
import just.ca.einity.Member;

public class SignFrame extends JFrame implements ActionListener{
	JLabel text;
	JTextField text2;
	JLabel errorlabel;
	JLabel errorlabel2;
	JComboBox jc;
	JButton sign;
	JButton back;
	JButton clear;
	JLabel label;
	String username;
	public SignFrame(String username){
		this.username=username;
		this.setTitle("��Э��ѵǩ��");
		this.setSize(410,270);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(createPanel());
		this.setResizable(false);
	}
	private Component createPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		ImageIcon icon=new ImageIcon(this.getClass().getResource("sign-in.png"));
		panel.add(new JLabel(icon),BorderLayout.NORTH);
		panel.add(createCenterPanel(),BorderLayout.CENTER);
		panel.add(createDownPanel(),BorderLayout.SOUTH);
		return panel;
	}
	private Component createDownPanel() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(createButtonPanel(),BorderLayout.NORTH);
		AdministratorDao dao3=new AdministratorDaoImpl();
		Administrator test2=new Administrator();
		try {
			test2=dao3.findById(1445536125);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label=new JLabel("�˴���ѵ����"+test2.getTimes()+"��ǩ��");
		panel.add(label,BorderLayout.EAST);
		return panel;	
	}
	private Component createButtonPanel() {
		JPanel panel=new JPanel(new GridLayout(1,3));
		sign=new JButton("Sign");
		sign.addActionListener(this);
		clear=new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jc.setSelectedItem("null");
				text2.setText("");	
				errorlabel.setText("");
				errorlabel2.setText("");
			}
		});
		back=new JButton("Back");
		back.addActionListener(this);
		panel.add(sign);
		panel.add(clear);
		panel.add(back);
		return panel;
	}
	private Component createCenterPanel() {
		JPanel panel=new JPanel(new GridLayout(2,3));
		JLabel label=new JLabel("��ѡ��רҵ��");
		label.setFont(new Font("����",Font.BOLD,13));
		panel.add(label);	
		String []str={"null","�ƿ�","У�����","�Ź�","�������","ұ��","����","����","����","��ľ","����"};
		jc=new JComboBox(str);
		jc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jc.getSelectedItem()=="15У�����"){
					text.setText("152219605");
				}else if(jc.getSelectedItem()=="null"){
					text.setText("");
				}else if(jc.getSelectedItem()=="��ľ"){
					text.setText("152211511");
				}else if(jc.getSelectedItem()=="�Ź�"){
					text.setText("152211554");
				}else if(jc.getSelectedItem()=="����"){
					text.setText("152219502");
				}else if(jc.getSelectedItem()=="ұ��"){
					text.setText("152219702");
				}else if(jc.getSelectedItem()=="����"){
					text.setText("152219703");
				}else if(jc.getSelectedItem()=="����"){
					text.setText("152219802");
				}else if(jc.getSelectedItem()=="����"){
					text.setText("");
				}else if(jc.getSelectedItem()=="�ƿ�"){
					text.setText("158111541");
				}else if(jc.getSelectedItem()=="У�����"){
					text.setText("152219605");
				}else if(jc.getSelectedItem()=="�������"){
					text.setText("158111545");
				}else if(jc.getSelectedItem()=="����"){
					text.setText("152219502");
				}
			}
		});
		panel.add(jc);
		errorlabel=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel);
		JLabel label2=new JLabel("����ѧ�Ž���ǩ����");
		label2.setFont(new Font("����",Font.BOLD,13));
		panel.add(label2);
		panel.add(createText());
		errorlabel2=new JLabel("",JLabel.CENTER);
		panel.add(errorlabel2);
		return panel;
	}
	private Component createText() {
		JPanel panel=new JPanel(new BorderLayout());
		text=new JLabel("");
		panel.add(text,BorderLayout.WEST);
		text2=new JTextField();
		panel.add(text2,BorderLayout.CENTER);
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back){
			this.setVisible(false);
			MenuFrame frame=new MenuFrame(username);
			frame.setVisible(true);
		}else if(e.getSource()==sign){
			if(jc.getSelectedItem()=="null"){
				errorlabel.setText("רҵ����Ϊ�գ�");
				errorlabel.setForeground(Color.red);
			}else{
				errorlabel.setText("");
				long number=Long.parseLong(text.getText()+text2.getText());
				MemberDao dao=new MemberDaoImpl();
				try {
					List<Member> members=dao.findAll();
					boolean isExit1=false;
				for(Member member:members){
					if(member.getNumber()==number){
						isExit1=true;
					}
				}
				if(!isExit1){
					errorlabel2.setText("�Ǳ�Э���Ա��");
					errorlabel2.setForeground(Color.red);
				}else{
					errorlabel2.setText("");
				}
				if(isExit1){
					MemberDao dao2=new MemberDaoImpl();
	    			Member test=new Member();
	    			test=dao2.findById(number);
	    			String str1=test.getName();
	    			String str2=test.getSex();
	    			String str3=test.getProfession();
	    			String str4=test.getPhone();
	    			String str5=test.getQqnumber();
	    			int n=test.getTimes()+1;
	    			dao2.delete(number);
	    			dao2.insert(number,str1,str2,str3,str4,str5,n);
	    			JOptionPane.showMessageDialog(this, "��ϲ"+str1+",���ѳɹ�ǩ������ȷ������"); 
	    			AdministratorDao dao5=new AdministratorDaoImpl();
	    			Administrator test5=new Administrator();
	    			try {
	    				test5=dao5.findById(1445536125);
	    			} catch (Exception e1) {
	    				e1.printStackTrace();
	    			}
	    			int i=test5.getTimes();
	    			label.setText("�˴���ѵ����"+ ++i +"��ǩ��");
	    			jc.setSelectedItem("null");
	    			text.setText("");
	    			text2.setText("");
	    			AdministratorDao dao3=new AdministratorDaoImpl();
	    			Administrator test2=new Administrator();
	    			test2=dao3.findById(1445536125);
	    			int times=test2.getTimes()+1;
	    			String str6=test2.getName();
	    			String str7=test2.getPassword();
	    			dao3.modify(1445536125);
	    			dao3.insert2(1445536125, str6, str7,times);
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		}	
	}
}