/**
 * The core part of snake game, it has GUI components as its fields and control methods 
 * The game starts automatically
 */

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class main {
	private cell[][] list; //cell stores JPanel, used to draw every cells of game canvas
	private JFrame frame; 
	private JLabel label;
	private JPanel major; // it contains all of the cells
	private static snake snake; 
	// the move directions of snake, default move direction once the game starts is right
	public static boolean right = true;
	public static boolean left = false;
	public static boolean up = false;
	public static boolean down = false;
	// the status of the game, "endGame = true" stands for the end of game
	public static boolean endGame = false;
	
	public main() {
		list = new cell[50][50]; // the playground for the snake is a 50*50 grid
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				list[i][j] = new cell();
			}
		}
		snake = new snake();
		ArrayList<coordinate> temp = snake.getlist();
		for (int i = 0; i < temp.size(); i++) {
			coordinate curr = temp.get(i);
			int x = curr.getX();
			int y = curr.getY();
			list[x][y].changeColor(Color.black);
		}
	}
	
	// generate food at a random position
	public void food() {
		int x, y;
		do{
		int position = (int)(Math.random() * 2500 + 1);
		x = position / 50;
		y = position % 50;
		} while (this.list[x][y].getBackground() != Color.white);
		this.list[x][y].changeColor(Color.blue);
	}

	// responsible for snake's move
	public void move() {
		while (!endGame) {
			int x = this.snake.getlist().get(this.snake.size() - 1).getX();
			int y = this.snake.getlist().get(this.snake.size() - 1).getY();
			//delete snake's tail
			this.list[x][y].changeColor(Color.white);
			//determine which direction snake should move
			if (right) {
				this.snake.rightMove();
			}
			if (left) {
				this.snake.leftMove();
			}
			if (down) {
				this.snake.downMove();
			}
			if (up) {
				this.snake.upMove();
			}
			// get the new head position of snake
			int m = this.snake.getlist().get(0).getX();
			int n = this.snake.getlist().get(0).getY();
			//check if the game ends
			if (m == 50 || m == -1 || n == -1 || n == 50) {
				this.endGame = false;
				break;
			}
			//check if food is eaten by snake
			if (this.list[m][n].getBackground() == Color.blue) {
				this.snake.changeL(); //increase the length of snake
				int ans = snake.size() - 10;
				this.label.setText("Score: " + ans);
				this.snake.getlist().add(new coordinate(x,y));
				this.list[x][y].changeColor(Color.black);
				this.list[m][n].changeColor(Color.black);
				this.food(); // put a new food
				// check if snake eats itself
			} else if (this.list[m][n].getBackground() == Color.black) {
				this.endGame = false;
				break;
			} else {		
				this.list[m][n].changeColor(Color.black);			
			}
			//delay display
			try {
				Thread.sleep(150);
			} catch (Exception ex) { }
		}
	}
	
	public void setup() {
		frame = new JFrame();
		major = new JPanel();
		label = new JLabel ("Score: 0");
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
		major.setLayout(new GridLayout(50, 50, 0, 0));
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				major.add(this.list[i][j]);
			}
		}
		frame.getContentPane().add(BorderLayout.NORTH, major);
		frame.getContentPane().add(BorderLayout.CENTER, label);
		frame.addKeyListener((KeyListener) new keyboard());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}
	
	public static void main (String[] args) {
		main start = new main();
		start.setup();
		start.food();
		start.move();		
	}
	
}
