package just.ca.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

//1.必须是面板类
public class SmilePanel extends JPanel{
	private static Color[] color = { Color.BLACK, Color.BLUE, Color.CYAN,
		Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED,
		Color.PINK, Color.LIGHT_GRAY };
	private Thread t;
private static final Random rand = new Random();
private static Color getC() {
	return color[rand.nextInt(color.length)];
}
	int[] xx;
	int[] yy;
	public static Image img;
	String []str;
	public SmilePanel(){
		xx=new int[150];
		yy=new int[150];
		for(int i=0;i<xx.length;i++){
			xx[i]=(int)(Math.random()*480);
			yy[i]=(int)(Math.random()*300);
		}
		str=new String[150];
		String []t={"0","1","2","3","4","5","6","7","8","9"};
		for(int j=0;j<150;j++){
			int n=(int)(Math.random()*10);
			str[j]=t[n];
		}
		img=Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("smile-in.png"));
		//System.out.println(Arrays.toString(yy));
	} 
//在面板里面画东西必须重写它的paint()	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, this);
		Font []fonts;
		fonts=new Font[10];
		for(int i=0;i<fonts.length;i++){
		fonts[i]=new Font("宋体",Font.BOLD,2*i+15);
		}
		for(int i=0;i<yy.length;i++)
		{
			g.setFont(fonts[i%fonts.length]);
			int r1=(int)(Math.random()*256);
			int g1=(int)(Math.random()*256);
			int b1=(int)(Math.random()*256);
			/*int m=(int)(Math.random()*770);
			int n=(int)(Math.random()*570);*/
		//g.setFont(new Font("宋体",Font.BOLD,24));
		Color d=new Color(r1,g1,b1);
		g.setColor(d);
		g.drawString(str[i], xx[i], yy[i]);//★
		}	
		
	}
	public void SleepMethodTest() {
		t = new Thread(new Runnable() {
			int x =0;
			int y =0;		
			public void run() {
				while (true) {
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
					Graphics graphics = getGraphics();
					graphics.setColor(getC());	
					graphics.drawLine(x, y, 510, y++);
					if (y >= 320) {
						y =0;
					}
				}
			}
		});
		t.start();// 启动线程
	}
	void startRun(){
		Thread t1=new Thread(){
			//在线程里发布任务必须重写run()方法
			public void run() {
				super.run();
				while(true){
					//1.所有星星的纵坐标+1
					for(int i=0;i<yy.length;i++){
						if(xx[i]%2==0){
							yy[i]++;
						}else{
							yy[i]--;
						}
						boolean t=true;
						if(yy[i]==320){
							yy[i]=0;
							t=false;
						}
						if(yy[i]==0&&t){
							yy[i]=320;
						}
					}
					repaint();
					//2.停一下
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		t1.start();
	}
}
