
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class TextFieldInformation extends JPanel {
	static String[] textfields; // all textfields on artists and their work 
	static String textmsg; 
	
	
	public TextFieldInformation() {
		textfields = new String[6]; 
		textfields[0] = new String("Pieter Bruegel The Elder, Children's Games 1559-60");
		textfields[1] = new String("Pieter Bruegel The Elder, Harvesters 1565");
		textfields[2] = new String("Winslow Homer, Snap The Whip, 1872"); 
		textfields[3] = new String("Winslow Homer, Country School House, 1871"); 
		textfields[4] = new String("Georges Seurat, Circus, 1891"); 
		textfields[5] = new String("Georges Seurat, Circus Sideshow, 1887-88"); 
		
		this.setPreferredSize(new Dimension(800, 25)); 
		this.setMaximumSize(new Dimension(800, 25)); 
		this.setMinimumSize(new Dimension(800, 25)); 
		textmsg = new String(textfields[0]); 
		
	}
	public void paint( Graphics g){
		g.drawString(textmsg, 3, 12); 
		
	}
	
}
