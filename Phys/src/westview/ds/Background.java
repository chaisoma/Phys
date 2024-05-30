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
	static double vf;
	static double vi;
	static double vmy;
	static double vmx;
	static double vm;
	static String str;
	static int temp;
	//SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("Boccherini-Minuet.wav", false);
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
        	str = ""+((i-1)*10);
        	if (i>10) {
        		g.drawString(str, 50*i-10, 40);
        		g.drawString(str, 15, 50*i+10);
        	}
        	if (i<=10) {
        		g.drawString(str, 50*i-5, 40);
        		g.drawString(str, 25, 50*i+10);
        	}
        }
        
        for(int i = 46; i > 33 ; i--) {
        	g.drawLine(x1*5+50,y1*5+i,x2*5+50,y2*5+i);
        }
    
    g.drawLine(x1*5+50,y1*5+46,x2*5+50,y2*5+46);
	g.drawLine(x1*5+50,y1*5+47,x2*5+50,y2*5+47);
	g.drawLine(x1*5+50,y1*5+48,x2*5+50,y2*5+48);
	g.drawLine(x1*5+50,y1*5+49,x2*5+50,y2*5+49);
	g.drawLine(x1*5+50,y1*5+50,x2*5+50,y2*5+50);
	g.drawLine(x1*5+50,y1*5+51,x2*5+50,y2*5+51);
	g.drawLine(x1*5+50,y1*5+52,x2*5+50,y2*5+52);
	g.drawLine(x1*5+50,y1*5+53,x2*5+50,y2*5+53);

	
		Particle particle = new Particle( n, n2, 0, 0, 2.1);
		g.fillOval(n*5+25, n2*5+25, 50, 50);
		finalVelocity = Math.pow(Math.pow(particle.getVy(), 2)+2*particle.getAy()*(180-n2),0.5);
		
		
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
		while(x1>180||x1<0) {
			if (x1 == 69) {
				System.out.println("What the sigma");
			}
	        System.out.println("Invalid input please try again");
	        x1 = reader.nextInt();
		}
		
		System.out.println("Now enter the the Y position: ");
		y1 = reader.nextInt();
		while(y1>180||y1<0) {
	        System.out.println("Invalid input please try again");
	        y1 = reader.nextInt();
		}
		System.out.println("Now it is time to enter the other end of the platform.");
		System.out.println("Please enter the X position: ");
		x2 = reader.nextInt(); 
		while(x2>180||x2<0) {
	        System.out.println("Invalid input please try again");
	        x2 = reader.nextInt();
		}
		System.out.println("Now enter the Y position: ");
		y2 = reader.nextInt();
		while(y2>180||y2<0) {
	        System.out.println("Invalid input please try again");
	        y2 = reader.nextInt();
		}
		System.out.println("");
		System.out.println("Thank you for entering the position of the platform.");
		System.out.println("Now enter a valid x and y cordinate between 1 and 17");
		System.out.println("Enter the X position of the particle: ");
		n = reader.nextInt(); 
		
		
		while(n < 1 || n > 179) {
			System.out.print("Invalid input please try again");
			n = reader.nextInt();
		}
		System.out.println("And finally, enter the Y position of the particle: ");
		n2 = reader.nextInt();
		while(n2 < 1 || n2 > 179) {
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
    	if((n<x1&&n<x2)||(n>x1&&n>x2)||n2>((y1-y2)/(x1-x2))*(n-x1)+y1) {
			finalVelocity = Math.pow(2*2.1*(180-n2),0.5);
			n2 = 180;
			System.out.println("running");
    	}else if(n2<((y1-y2)/(x1-x2))*(n-x1)+y1) {
    		temp = ((y1-y2)/(x1-x2))*(n-x1)+y1-1;
			vi = Math.pow(2*2.1*(temp-n2),0.5); 
    		if (y1 == y2) {
    			n2 = y1-1;
    			System.out.println(vi);
    		}
    		else if(y2>y1) {
    			double aX = Math.sin(Math.atan(Math.abs((y1-y2)/(x1-x2))));
    			vm = Math.sqrt(Math.pow(vi*aX, 2)+2*aX*2.1*(Math.sqrt(Math.pow(y2-n2, 2)+Math.pow(x2-n, 2))));
        		vmy = Math.sin(vm);
        		vmx = Math.cos(vm);
        		vf = Math.sqrt(Math.pow(vmy,2)+2*2.1*(180-y2));
        		double time = (vf-vmy)/2.1;
        		n2 = 180;
        		n = x2+(int)(time*vmx);
        		finalVelocity = Math.sqrt(Math.pow(vf,2)+Math.pow(vmx, 2));
        		System.out.println(finalVelocity);
    		}else {
    			double aX = Math.sin(Math.atan(Math.abs((y1-y2)/(x1-x2))));
    			vm = Math.sqrt(Math.pow(vi*aX, 2)+2*aX*2.1*(Math.sqrt(Math.pow(y1-n2, 2)+Math.pow(x1-n, 2))));
        		vmy = Math.sin(vm);
        		vmx = Math.cos(vm);
        		vf = Math.sqrt(Math.pow(vmy,2)+2*2.1*(180-y1));
        		double time = (vf-vmy)/2.1;
        		n2 = 180;
        		n = x1-(int)(time*vmx);
        		finalVelocity = Math.sqrt(Math.pow(vf,2)+Math.pow(vmx, 2));
        		System.out.println(finalVelocity);
    		}
    		
    		
    		
    		
    		//Particle.setY(n2*50+25);
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
