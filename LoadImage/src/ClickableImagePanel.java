import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.*;
import javax.swing.*; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class ClickableImagePanel extends JPanel implements ActionListener {
	
	 JButton but1, but2, but3, but4, but5, but0;  
	 public String[] iconfname = {"imgs/Child-1.png",  "imgs/Harv-9-1.jpg",  "imgs/SnapTheWhipOhio.png", 
	 "imgs/TheCountrySchool.png", "imgs/SeuratCircus.png", "imgs/Seurat-SideshowMET.png"}; 
	 
	 static BufferedImage currentImage; 
	 static String newfname; 
	 
	 ImageIcon[] imgicon; 
	 
	 
	 String[] pictname = {"Children's Games", "Harvest",  "Snap The Whip", "The Country School", "Circus", "Circus Sideshow"}; 
	
	 static CurrentViewableImage newImageLoaded; 
	 static LoadImageApplet thisptr;
	 static Boolean First; 
	 
	 // my constructor was not declared correctly, therefore it was not able to be called 
	 public  ClickableImagePanel(){
		
		First = true; 
		//System.out.println("First Image Loaded"); 
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(800,200);
		this.setBackground(Color.black);
		
		// initiate all buttons at once 
		but0 = new JButton(); 
		but0.setText(pictname[0]); 
		but0.setMaximumSize(new Dimension(150,100)); 
		but0.setMinimumSize(new Dimension(150,100)); 
		but0.setPreferredSize(new Dimension(150,100)); 
		this.add(but0);
		but0.setEnabled(true); 
		but0.addActionListener(this);
		
		but1 = new JButton(); 
		but1.setText(pictname[1]); 
		but1.setMaximumSize(new Dimension(150,100)); 
		but1.setMinimumSize(new Dimension(150,100)); 
		but1.setPreferredSize(new Dimension(150,100)); 
		this.add(but1);
		but1.setEnabled(true); 
		but1.addActionListener(this);
		
		but2 = new JButton(); 
		but2.setText(pictname[2]); 
		but2.setMaximumSize(new Dimension(150,100)); 
		but2.setMinimumSize(new Dimension(150,100)); 
		but2.setPreferredSize(new Dimension(150,100)); 
		this.add(but2);
		but2.setEnabled(true); 
		but2.addActionListener(this);
		
		but3 = new JButton(); 
		but3.setText(pictname[3]); 
		but3.setMaximumSize(new Dimension(150,100)); 
		but3.setMinimumSize(new Dimension(150,100)); 
		but3.setPreferredSize(new Dimension(150,100)); 
		this.add(but3);
		but3.setEnabled(true); 
		but3.addActionListener(this);
		
		but4 = new JButton(); 
		but4.setText(pictname[4]); 
		but4.setMaximumSize(new Dimension(150,100)); 
		but4.setMinimumSize(new Dimension(150,100)); 
		but4.setPreferredSize(new Dimension(150,100)); 
		this.add(but4);
		but4.setEnabled(true);
		but4.addActionListener(this);
		
		but5 = new JButton(); 
		but5.setText(pictname[5]); 
		but5.setMaximumSize(new Dimension(150,100)); 
		but5.setMinimumSize(new Dimension(150,100)); 
		but5.setPreferredSize(new Dimension(150,100)); 
		this.add(but5);
		but5.setEnabled(true); 
		but5.addActionListener(this);
		
		//initially it needs to be childrens games 
		try {
			URL url = new URL(LoadImageApplet.ourCodeBase, "imgs/Child-1.png");
			currentImage = ImageIO.read(url); 
			
		}catch (IOException e) {
			
		}
		
	
	}
	
 //when button is pressed, replace with correct image and correct text that accompanies it 
	public void actionPerformed(ActionEvent e){
		
	    String labelname ; 
	    int i,j; 
	    First = false; 
	 
	    if (e.getActionCommand() == "Children's Games") {
	    	newfname =  this.iconfname[0]; 
	    	TextFieldInformation.textmsg = new String (TextFieldInformation.textfields[0]);
	    }
	     else  if (e.getActionCommand() == "Harvest") {
	    	newfname =  this.iconfname[1]; 
	    	TextFieldInformation.textmsg = new String (TextFieldInformation.textfields[1]);
	     }
	    else  if (e.getActionCommand() == "Snap The Whip") {
	    	newfname =  this.iconfname[2]; 
	    	TextFieldInformation.textmsg = new String (TextFieldInformation.textfields[2]);
	    }
	    else  if (e.getActionCommand() == "The Country School") {
	    	newfname =  this.iconfname[3]; 
	    	TextFieldInformation.textmsg = new String (TextFieldInformation.textfields[3]);
	    }
	    else  if (e.getActionCommand() == "Circus") {
	    	newfname =  this.iconfname[4]; 
	    	TextFieldInformation.textmsg = new String (TextFieldInformation.textfields[4]);
	    }
	    else  if (e.getActionCommand() == "Circus Sideshow") {
	    	newfname =  this.iconfname[5]; 
	    	TextFieldInformation.textmsg = new String (TextFieldInformation.textfields[5]);
	    }
	    
	    //System.out.println("Loading " + newfname);
	    
	   // LoadImageApplet.thisptr.cvi.CurrentImage =  new String (CurrentViewableImage.newfname); 
	    currentImage = LoadThisImage(newfname); 
	    CurrentViewableImage.img = currentImage; 
	    LoadImageApplet.imgpanel.repaint(); // I DO NOT KNOW WHY THIS WORKS AND THE OHER ATTEMPTS DO NOT  
	   //repaint();
	    //ALL NULL POINTER EXCEPTIONS 
	   //LoadImageApplet.thisptr.cvi.img = img; 
	  // CurrentViewableImage.repaint(); 
	   // LoadImageApplet.thisptr.cvi.repaint();
	    
	  
	}
	
	//load the image for CurrentViewableImage here 
   // this was very hard to figure out and this was the best
	// solution I came up with
	public BufferedImage LoadThisImage(String fname){	
	BufferedImage img ;
	try {
		URL url = new URL(LoadImageApplet.ourCodeBase, fname);
		img = ImageIO.read(url); 
		return img; 
		
	}catch (IOException e) {
		return null; 
		
	}	
 	
	}
	

}	
