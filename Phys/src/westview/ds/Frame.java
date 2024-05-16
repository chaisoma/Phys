package westview.ds;

import java.awt.Color;




public class Frame extends JPanel {
	
	Particle particle = new Particle(100, 100, 100, 0, 0, -9.8);
	
	public void paint(Graphics g) {
		 
		super.paintComponent(g);
		
		// Fill background
		g.setColor(Color.BLACK); // Set background color
		g.fillRect(0, 0, 1000, 1000); // Fill the entire panel with the background color
		
		// Draw particle
		particle.paint(g);
		
		// Draw something on top of the background
		g.setColor(Color.RED);
		g.fillRect(300, 300, 200, 200); // Example rectangle
		
		
	}
	
	
	
	
	
}

