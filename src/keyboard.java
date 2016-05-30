/**
 * Use keyboard: up down right left to control snake's move
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyboard extends KeyAdapter{
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	if (main.down) {
	        		break;
	        	}
	        	main.left = false;
	            main.right = false;
	            main.up = true;
	            break;
	        case KeyEvent.VK_DOWN:
	            if (main.up) {
	            	break;
	            }
	            main.down = true;
	            main.left = false;
	            main.right = false;
	            break;
	        case KeyEvent.VK_LEFT:
	            if (main.right) {
	            	break;
	            }
	            main.left = true;
	            main.up = false;
	            main.down = false;
 	            break;
	        case KeyEvent.VK_RIGHT :
	            if (main.left) {
	            	break;
	            }
	            main.right = true;
	            main.up = false;
	            main.down = false;
	            break;
	     }
	} 
}
