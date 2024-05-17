package westview.ds;

import java.awt.*;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.*;

public class Background extends JPanel implements ActionListener, KeyListener{
    
	static int n;
	static int n2;
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	static double finalVelocity;
	static String str;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set background color
        this.setBackground(Color.WHITE);
        
        // Draw something on the background
        g.setColor(Color.BLACK);
        g.drawRect(50,50,900,925);
        g.drawRect(51,51,898,923);
        g.drawRect(52,52,896,921);
        g.drawRect(53,53,894,919);
        g.drawRect(54,54,892,917);
        g.setFont(new Font("TimesRoman",Font.PLAIN,20));
        for (int i = 1; i<20;i++) {
        	g.drawLine(50*i,50,50*i,975);
        	g.drawLine(50, 50*i, 950, 50*i);
        	str = ""+(i-1);
        	if (i>10) {
        		g.drawString(str, 50*i-10, 40);
        		g.drawString(str, 15, 50*i+10);
        	}
        	if (i<=10) {
        		g.drawString(str, 50*i-5, 40);
        		g.drawString(str, 25, 50*i+10);
        	}
        }
        
    
		g.drawLine(x1*50+50,y1*50+46,x2*50+50,y2*50+46);
		g.drawLine(x1*50+50,y1*50+47,x2*50+50,y2*50+47);
		g.drawLine(x1*50+50,y1*50+48,x2*50+50,y2*50+48);
		g.drawLine(x1*50+50,y1*50+49,x2*50+50,y2*50+49);
		g.drawLine(x1*50+50,y1*50+50,x2*50+50,y2*50+50);
		g.drawLine(x1*50+50,y1*50+51,x2*50+50,y2*50+51);
		g.drawLine(x1*50+50,y1*50+52,x2*50+50,y2*50+52);
		g.drawLine(x1*50+50,y1*50+53,x2*50+50,y2*50+53);
		Particle particle = new Particle( n, n2, 0, 0, 9.8);
		g.fillOval(n*50+25, n2*50+25, 50, 50);
		finalVelocity = Math.pow(Math.pow(particle.getVy(), 2)+2*particle.getAy()*(18-n2),0.5);
		
		
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Background");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 1050);
        Scanner reader = new Scanner(System.in);  
        System.out.println("Please enter valid x and y cordinates between 0 and 18");
        System.out.println("First things first you are going to enter to x and y positions of one side of the platform.");
        System.out.println("Enter the X position first: ");
		x1 = reader.nextInt(); 
		while(x1>18||x1<0) {
			if (x1 == 69) {
				System.out.println("What the sigma");
			}
	        System.out.println("Invalid input please try again");
	        x1 = reader.nextInt();
		}
		
		System.out.println("Now enter the the Y position: ");
		y1 = reader.nextInt();
		while(y1>18||y1<0) {
	        System.out.println("Invalid input please try again");
	        y1 = reader.nextInt();
		}
		System.out.println("Now it is time to enter the other end of the platform.");
		System.out.println("Please enter the X position: ");
		x2 = reader.nextInt(); 
		while(x2>18||x2<0) {
	        System.out.println("Invalid input please try again");
	        x2 = reader.nextInt();
		}
		System.out.println("Now enter the Y position: ");
		y2 = reader.nextInt();
		while(y2>18||y2<0) {
	        System.out.println("Invalid input please try again");
	        y2 = reader.nextInt();
		}
		System.out.println("");
		System.out.println("Thank you for entering the position of the platform.");
		System.out.println("Now enter a valid x and y cordinate between 1 and 17");
		System.out.println("Enter the X position of the particle: ");
		n = reader.nextInt(); 
		
		
		while(n < 1 || n > 17) {
			System.out.print("Invalid input please try again");
			n = reader.nextInt();
		}
		System.out.println("And finally, enter the Y position of the particle: ");
		n2 = reader.nextInt();
		while(n < 1 || n > 17) {
			System.out.print("Invalid input please try again");
			n2 = reader.nextInt();
		
		}
		int n3 = reader.nextInt();
		if(n3==69420) {
			run();
			
		}
		
		
		
		reader.close();
		
		
		
		System.out.println("The final velocity of the particle is -"+ finalVelocity+ " pixels per second");
        Background background = new Background();
        frame.add(background);
        
        frame.setVisible(true);
    }
    public void keyPressed(KeyEvent k) {
    	System.out.println(k.getKeyCode());
    }
    public static void run() {
    	if((n<x1&&n<x2)||(n>x1&&n>x2)) {
			finalVelocity = Math.pow(2*9.8*(18-n2),0.5);
			n2 = 18;
			System.out.println("running");
    	}else {
    		for(int i = 0; i < n2; i++) {
    			if()
    		}
    	}
		
    }
//    public void whatTheSigma() {
//    	double finalVelocity = Math.sqrt(Math.pow(particle.getVy(), 2)+2*particle.getAy());
//		System.out.println(1);
//    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
