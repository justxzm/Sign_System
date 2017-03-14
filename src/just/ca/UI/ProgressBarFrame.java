package just.ca.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBarFrame extends JFrame implements ActionListener{
	int count2 = 0;	
	int count = 0;
	JButton button;
	private static final long serialVersionUID = 1L;
	private Thread threadA; 
	private Thread threadB;

	public ProgressBarFrame(){
		this.add(JoinTest());
	}
	public JPanel JoinTest() {	
		final JProgressBar progressBar = new JProgressBar(); 
		final JProgressBar progressBar2 = new JProgressBar();
		JPanel panel=new JPanel(new GridLayout(5,1));
		panel.add(new JLabel("当前:"));
		panel.add(progressBar);	
		panel.add(new JLabel("全部:"));
		panel.add(progressBar2);
		button=new JButton("Show");
		panel.add(button);
		button.setEnabled(false);
		button.addActionListener(this);		
		progressBar.setStringPainted(true); 
		progressBar2.setStringPainted(true);	
		threadA = new Thread(new Runnable() {	
			public void run() { 
				while (true) {
					int n=(int)(3+Math.random()*8);
					count+=n;
					progressBar.setValue(count); 
					try {
						Thread.sleep(50); 					
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(count>=100){
						count=0;
						if(count2>=100){
							button.setEnabled(true);
							break;
						}
					}
				}
			}
		});
		threadA.start(); 
		threadB = new Thread(new Runnable() {
			public void run() {
				while (true) {
					int n=(int)(2+Math.random()*5);
					count2+=n;
					progressBar2.setValue(count2); 
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (count2>=100){
						break; 
					}
				}
			}
		});
		threadB.start();
		return panel;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button){
				this.setVisible(false);
				PreviewFrame frame=new PreviewFrame();
				frame.setVisible(true);			
		}
	}
}
