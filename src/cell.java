import java.awt.Color;

import javax.swing.*;

public class cell extends JPanel {
	public cell() {
		this.setBackground(Color.white);
	}
	
	public void changeColor(Color a) {
		this.setBackground(a);	
		this.repaint();		
	}
}
