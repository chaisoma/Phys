
package westview.ds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Particle{
	
	

	
	static int x, y;						//position of the object
	static double vx, vy;	
	static double ay = -9.8;//movement variables		
	static double ground = 330;

	public Particle(int iX, int n2, int iVx, int iVy, double iAy) {
		
		//alter these
		
		
		x = iX;
		y = n2;
		vx = iVx;
		vy = iVy;
		ay = iAy;
		
		
		
		
		
						//initialize the location of the image
									//use your variables
		
	}
	
	public static void setX(int ix) {
		x = ix;
	}
	public int getX() {
		return x;
	}
	public static void setY(int iy) {
		y = iy;
	}
	public int getY() {
		return y;
	}
	public static void setVx(double ivx) {
		vx = ivx;
	}
	public double getVx() {
		return vx;
	}
	public static void setVy(double ivy) {
		vy = ivy;
	}
	public double getVy() {
		return vy;
	}
	public double getAy() {
		return ay;
	}
	public static void setAy(double iay) {
		ay = iay;
	}

	
	public static void setGround(double iground) {
		ground = iground;
	}
	public double getGround() {
		return ground;
	}
//	public boolean collided(int x, int y, int width, int height) {
//		Rectangle otherObject = new Rectangle(x,y,width,height);
//		Rectangle thisObject = new Rectangle((int)this.x+23,(int) this.y+45, this.width, this.height);
//		if (otherObject.intersects(thisObject)) {
//			return true;
//		}else {
//			return false;
//		}
//	}
	
	


	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		 g.setColor(Color.RED);
		g.fillOval(100,100,100,100);
		
		
		x+=vx;
		y+=vy;	
		vy+=ay;
		
		if (y == ground) {
			vy = 0;
			
		}
		
	
	}
}
		
		
		
	
		
	
	



