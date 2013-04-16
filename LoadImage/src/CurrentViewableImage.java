import java.awt.*; 
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.imageio.*;

public class CurrentViewableImage extends JPanel {
	 JPanel ImageArea; 
 	 static String CurrentImage; 
 	 static String newfname; 
 	 JTextArea TextForImage ;  
 	 ClickableImagePanel ClickableImages ; 
 	 JPanel clickimg; 
	 JPanel TextPanel ; 
	 static BufferedImage img = null; 
 	
	 // for constuctor load Children's Games by Brueghel which can be found in the imgs folder with 
	 // all other images 
	 public CurrentViewableImage (){
		// immediately load the first image in the constructor  
		CurrentImage = new String("imgs/Child-1.png"); 
		try {
			URL url = new URL(LoadImageApplet.ourCodeBase, CurrentImage);
			img = ImageIO.read(url); 
			Graphics g = img.getGraphics();
			g.drawImage(img, 0, 0, null);
			
		}catch (IOException e) {
			
		}
		repaint(); 
	 }
		
		
		
	 //not used 
		public CurrentViewableImage (String fname){
			// immediately load the first image in the constructor  
			CurrentImage = new String(fname); 
			try {
				URL url = new URL(LoadImageApplet.ourCodeBase, CurrentImage);
				img = ImageIO.read(url); 
				Graphics g = img.getGraphics();
				g.drawImage(img, 0, 0, null);
				
			}catch (IOException e) {
				
			}	
			repaint(); 	
			
		
		}
		
	// not used 
	public void LoadNewImage (String fname){
		// immediately load the first image in the constructor  
		
		try {
			
			URL url = new URL(LoadImageApplet.ourCodeBase, fname);
			img = ImageIO.read(url); 
			Graphics g = img.getGraphics();
			g.drawImage(img, 0, 0, null);
			
		}catch (IOException e) {
			
		}	
		repaint(); 	
		
	
	}
	//used by constructor and then called to repaint by ClickableImagePanel 
	// by LoadImageApplet.imgpanel.repaint();
	 public void  paint ( Graphics g ){
		if (ClickableImagePanel.First == true){
			g.drawImage(img, 0, 0, null);
			//System.out.println("In CurrentView viewing true" + ClickableImagePanel.newfname);
		}
		else {
			g.drawImage(ClickableImagePanel.currentImage, 0, 0, null ); 
			//System.out.println("In CurrentView viewing false " + ClickableImagePanel.newfname); 
		}
	}
	
	
}
