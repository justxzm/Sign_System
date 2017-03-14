package just.ca.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExitFrame extends JFrame implements ActionListener{
	JButton yes;
	JButton no;
	String username;
	public ExitFrame(String username){
		this.username=username;
		JPanel panel=new JPanel(new BorderLayout());
		JLabel label=new JLabel("Do you want to exit the system?");
		label.setFont(new Font("ÀŒÃÂ",Font.BOLD,24));
		label.setForeground(Color.red);
		panel.add(label,BorderLayout.NORTH);
		panel.add(createCenterPanel(),BorderLayout.CENTER);
		this.add(panel);
		this.setTitle("Ã· æ£°");
		this.setSize(450,110);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	private Component createCenterPanel() {
		JPanel panel=new JPanel(new GridLayout(1,2));
		yes=new JButton("YES");
		yes.addActionListener(this);
		no=new JButton("NO");
		no.addActionListener(this);
		panel.add(yes);
		panel.add(no);
		return panel;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==no){
			this.setVisible(false);
			MenuFrame frame=new MenuFrame(username);
			frame.setVisible(true);
		}else if(e.getSource()==yes){
			this.setVisible(false);
			System.exit(0);
		}
	}
}
