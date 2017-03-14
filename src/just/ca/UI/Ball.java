package just.ca.UI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball {
	int x,y;
	int r;
	Color color;
	int direction;
	int speed;
	JPanel panel;
	//定义方向常量
	public static final int LEFT_UP=0;
	public static final int LEFT_DOWN=1;
	public static final int RIGHT_UP=2;
	public static final int RIGHT_DOWN=3;
	public Ball(int x, int y, int r, Color color, int direction, int speed,
			JPanel panel) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
		this.color = color;
		this.direction = direction;
		this.speed = speed;
		this.panel = panel;
	}
	public void draw(Graphics g){
		g.setColor(color);
		g.fillArc(x, y, 2*r,2*r, 0, 360);	
	}
	public void move(){
		switch(direction){
		case LEFT_UP:x-=speed;
		             y-=speed;
		             if(y<=0){this.direction=LEFT_DOWN;} 
		             if(x<=0){this.direction=RIGHT_UP;} 	  
			         break;
		case LEFT_DOWN:x-=speed;
		               y+=speed;
		               if(x<=0){this.direction=RIGHT_DOWN;}
		               if(y>=panel.getHeight()-2*r){this.direction=LEFT_UP;}
		               break;
		case RIGHT_UP:x+=speed;
		              y-=speed;
		              if(x>=panel.getWidth()-2*r){this.direction=LEFT_UP;}
		              if(y<=0){this.direction=RIGHT_DOWN;}
		              break;
		case RIGHT_DOWN:x+=speed;
		                y+=speed;
		                if(x>=panel.getWidth()-2*r){this.direction=LEFT_DOWN;}
		                if(y>=panel.getHeight()-2*r){this.direction=RIGHT_UP;}
		                break;	  
			default:
				break;
		
		}
	}
}
