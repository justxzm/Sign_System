package just.ca.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BallPanel extends JPanel{
	public static Image background;
    List<Ball>balls;//·ºÐÍ
    public BallPanel(){
    	balls=new ArrayList<Ball>();
    	for(int i=0;i<10;i++){
    		int r=(int)(Math.random()*5)+10;
    		int x=(int)(Math.random()*800);
    		int y=(int)(Math.random()*600);
    		int r1=(int)(Math.random()*256);
    		int g1=(int)(Math.random()*256);
    		int b1=(int)(Math.random()*256);
    		Color color=new Color(r1,g1,b1);
    		int direction=(int)(Math.random()*4);
    		int speed=(int)(Math.random()*5)+1;
    	   Ball ball=new Ball(x,y,r,color,direction,speed,this);
    	   balls.add(ball);
    	}
    	background=Toolkit.getDefaultToolkit().createImage(
				this.getClass().getResource("ball.png"));
    	//System.out.println(balls.size());
    }
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(background,0,0,this); 
			//this.setBackground(new Color(15,250,150));
		/*for(int i=0;i<balls.size();i++){
			Ball ball=balls.get(i);
			ball.draw(g);
		}*/
			
		for(Ball ball:balls){
			ball.draw(g);
		}
	}
	void startrun(){
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while(true){
					for(Ball ball:balls){
						ball.move();
					}
					repaint();
					try {
						Thread.sleep(12);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
	}
}
