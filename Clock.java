import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;



public class Clock extends JPanel {
	private int w,h,minutes,hours;
	private Timer t;
	private int [] x= new int [4];
	private int [] y= new int [4];
	
	public Clock() {
		minutes = -90;
		hours = -90;
		t = new Timer();
		t.schedule(new myTimerTask(), 1000, 100);

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		w = getWidth();
		h = getHeight();
		
		int xc =w/2;
		int yc= h/2;
		//setting background:
		setBackground(Color.orange);
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, w, h);
		g.setColor(Color.white);
		g.fillOval(20, 20, w-40, h-40);
		//drawing the numbers:
		Font f= new Font ("Arial",Font.BOLD,50);
		g.setFont(f);
		g.setColor(Color.black);
		for(int a = -60, i = 1; a<=270;a+=30,i+=1){
			int x = (int)((w/2)/1.05+((w/2)/1.25)*(Math.cos(a*Math.PI/180)));
			int y = (int)((h/2)*1.1+(h/2/1.25)*(Math.sin(a*Math.PI/180)));
		    g.drawString(String.format("%d", i), x, y);
		}//drawing the scale marks:
		for(int a =-90; a<270 ; a+=6) {
			if(a%5==0) {
				g.setColor(Color.red);
			}
			else {
				g.setColor(Color.blue);
			}
			g.drawLine((int)((w/2)+(w/2/1.2)*(Math.cos(a*Math.PI/180))),
					(int)((h/2)+(h/2/1.2)*Math.sin(a*Math.PI/180)),
					(int)((w/2)+(w/2)*(Math.cos(a*Math.PI/180))),
					(int)((h/2)+(h/2)*Math.sin(a*Math.PI/180)));
		}
		//minute hand:
		x[0]=(int)((xc)+((xc)/1.3)*Math.cos(minutes*Math.PI/180));
		y[0]=(int)((yc)+((yc)/1.3)*Math.sin(minutes*Math.PI/180));;
		x[1]=(int)((xc)+((xc)/5)*Math.cos((-40+minutes*Math.PI)/180));
		y[1]=(int)((yc)+((yc)/5)*Math.sin((-40+minutes*Math.PI)/180));
		x[2]=xc;
		y[2]=yc;
		x[3]=(int)((xc)+((xc)/5)*Math.cos((40+minutes*Math.PI)/180));
		y[3]=(int)((yc)+((yc)/5)*Math.sin((40+minutes*Math.PI)/180));

		g.setColor(Color.orange);
		g.fillPolygon(new Polygon (x,y,4));
		g.setColor(Color.black);
		g.drawPolygon(new Polygon(x, y, 4));
		//hour hand:
		x[0]=(int)((xc)+((xc)/2)*Math.cos(hours*Math.PI/180));
		y[0]=(int)((yc)+((yc)/2)*Math.sin(hours*Math.PI/180));;
		x[1]=(int)((xc)+((xc)/5)*Math.cos((-40+hours*Math.PI)/180));
		y[1]=(int)((yc)+((yc)/5)*Math.sin((-40+hours*Math.PI)/180));
		x[2]=xc;
		y[2]=yc;
		x[3]=(int)((xc)+((xc)/5)*Math.cos((40+hours*Math.PI)/180));
		y[3]=(int)((yc)+((yc)/5)*Math.sin((40+hours*Math.PI)/180));
		
		g.setColor(Color.orange);
		g.fillPolygon(new Polygon (x,y,4));
		g.setColor(Color.black);
		g.drawPolygon(new Polygon(x, y, 4));
		//middle circle
		g.setColor(Color.ORANGE);
		g.fillOval(xc-20, yc-25, 50, 50);
		g.setColor(Color.black);
		g.drawOval(xc-20, yc-25, 50, 50);
	}
	class myTimerTask extends TimerTask {
		public void run() {
			minutes++;
			if (minutes == 270) {
				minutes = -90;
				hours += 30;
			}
			repaint();
		}

	}
	
	public void setMinutes(int m) {
		this.minutes=-90+6*m;
	}

	public void setHours(int h) {
		this.hours=-90+30*h;
	}

}
