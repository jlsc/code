
import java.awt.*;

import java.net.URL;

import javax.swing.BoxLayout; 

import javax.swing.*;

public class LoadImageApplet extends JApplet  {
	
	static ImagePanel imgpanel; 
	Boolean start = true;  
	static CurrentViewableImage cvi; 
	ClickableImagePanel buttonimg;
	public static URL ourCodeBase; 
	public static LoadImageApplet thisptr; 
	public static TextFieldInformation textfield; 
	
	
	public void init () {
		ourCodeBase = this.getCodeBase();
		imgpanel = new ImagePanel(); 
	//	System.out.println("Starting"); 
		
	}
	
	// my constructor was not declared correctly, therefore it was not able to be called 
	public void start() {
		imgpanel.setLayout(new BoxLayout(imgpanel, BoxLayout.Y_AXIS)); //verticle box layout 
		this.setLayout(null);
		imgpanel.setSize(900, 800); 
		add(imgpanel);
		imgpanel.setVisible(true);
		imgpanel.setBackground(Color.BLACK); //why can I set the color here but not within class 
		
		CurrentViewableImage cvi = new CurrentViewableImage(); //ImagePanel with Painting 
		cvi.setVisible(true);
		cvi.setMinimumSize(new Dimension(600, 500));
		cvi.setMaximumSize(new Dimension(900, 600));
		cvi.setPreferredSize(new Dimension(900, 600));
		cvi.setBackground(Color.BLACK);
		imgpanel.add(cvi); 
		
		textfield = new TextFieldInformation(); //Text on painting and artist 
		textfield.setVisible(true);
		textfield.setMinimumSize(new Dimension(600, 25));
		textfield.setMaximumSize(new Dimension(900, 25));
		textfield.setPreferredSize(new Dimension(900, 25));
		textfield.setBackground(Color.BLACK);
		textfield.setForeground(Color.white); 
		imgpanel.add(textfield); 
		
		buttonimg = new ClickableImagePanel(); // names of paintings 
		buttonimg.setMinimumSize(new Dimension(600, 25));
		buttonimg.setMaximumSize(new Dimension(900, 25));
		buttonimg.setPreferredSize(new Dimension(900, 25));
		buttonimg.setVisible(true); 
		textfield.setBackground(Color.BLACK);
		imgpanel.add(buttonimg); 
		start= false; 
	}
	
	public void stop() {
	//	imgpanel.setVisible(false);
		
	}
	
	

}
