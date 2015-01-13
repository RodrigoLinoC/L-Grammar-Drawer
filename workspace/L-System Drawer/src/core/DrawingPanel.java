package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JPanel;

/**
 * @author Rorigo Lino da Costa
 * Class that draw the L-grammar
 */
public class DrawingPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default width of the drawing panel
	 */
	static final int PREFERRED_WIDTH = 500;
	
	/**
	 * Default height of the drawing panel
	 */
	static final int PREFERRED_HEIGHT = 380;
	
	Grammar grammar;
	int level;
	LogoTurtle t;
	
	/**
	 * Drawing panel constructor
	 */
	public DrawingPanel() {
		setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
		t = new LogoTurtle();
		grammar = new Grammar(((new File(Constants.FILE_PATH)).listFiles())[0].getName());
	}
	
	/**
	 * Define the grammar that will be used
	 * @param grammar name of the grammar
	 */
	public void setGrammar(String grammar) {
		this.grammar = new Grammar(grammar);
		repaint();
	}
	
	/**
	 * Define the level that will be drawn
	 * @param level the level to be drawn 
	 */
	public void setGrammarLevel(int level){
		this.level = level;
		repaint();
	}
	
	/**
	 * @param s current head of the grammar
	 * @param currentLevel the level of the current state
	 * @param t turtle that is taking care of the actual draw
	 */
	private void display (String s, int currentLevel, LogoTurtle t) {
		if (grammar != null)
			displayAux(s, currentLevel, t);
	}
	
	/**
	 * @param s current head of the grammar
	 * @param currentLevel the level of the current state
	 * @param t turtle that is taking care of the actual draw
	 */
	private void displayAux(String s, int currentLevel, LogoTurtle t) {
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case '+' : 	t.turnLeft(grammar.getAngle()); 
							break;
				case '-' : 	t.turnRight(grammar.getAngle());
							break;
				case '[' :	t.saveState();
							break;
				case ']' :	t.recoverState();
							break;
				default  :	if (currentLevel > 0)
								displayAux(grammar.getTail(s.charAt(i)),
										   currentLevel-1, t);
							else 
								t.forward();
			}
		}
	}
	
	/**
	 * Draw the defined grammar at the selected level
	 * @param g  graphic component of the panel
	 */
	public void showCurve (Graphics g) {
		t.resetTurtle(getBounds(), g);
		t.penUp();
		display("S", level, t);
		t.scale();
		t.penDown();
		display("S", level, t);	
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		if (grammar != null)
			showCurve(g);
	}

}
