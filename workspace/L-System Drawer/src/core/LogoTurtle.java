package core;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Stack;


public class LogoTurtle implements LogoTurtleInterface {

	/**
	 * Default start angle
	 */
	static final int INIT_DIRECTION = 270;
	/**
	 * Default start line length
	 */
	static final int INIT_LINE_LENGTH = 5;
	/**
	 * Offset from the border to the draw
	 */
	static final int OFFSET = 30;

	int	width, height;
	double initHorz, initVert, horz, vert;
	double maxHorz, minHorz, maxVert, minVert;
	double direction;
	double lineLength;
	boolean penIsDown;
	Graphics g;
	Stack<TurtleState> savedStates;
	
	public LogoTurtle () {
	}
	
	/**
	 * Set the turtle to its default state
	 * @param d the rectangle that can be filled
	 * @param gr the graphic component to draw
	 */
	public void resetTurtle(Rectangle d, Graphics gr) {
		width = d.width;					// get the window width and
		height = d.height;					// height of the canvas
		maxHorz = minHorz = horz = initHorz = width/2;
		maxVert = minVert = vert = initVert = height/2;
		
		direction = INIT_DIRECTION;
		lineLength = INIT_LINE_LENGTH;
		penIsDown = true;
		g = gr;
		
		savedStates = new Stack<TurtleState>();
	}
	

	public void turnLeft (double angle) {
		direction -= angle;
	}


	public void turnRight (double angle) {
		direction += angle;
	}
	

	public void penUp () {
		penIsDown = false;
	}


	public void penDown () {
		penIsDown = true;
	}
	

	public void forward () {
		double newHorz = horz + Math.cos(Math.toRadians(direction)) * lineLength;
		double newVert = vert + Math.sin(Math.toRadians(direction)) * lineLength;
		if (penIsDown) 
			g.drawLine( (int) Math.round(horz),
						(int) Math.round(vert),
						(int) Math.round(newHorz),
						(int) Math.round(newVert));
		horz = newHorz;
		vert = newVert;
		
		maxHorz = Math.max(horz, maxHorz);
		minHorz = Math.min(horz, minHorz);
		
		maxVert = Math.max(vert, maxVert);
		minVert = Math.min(vert, minVert);

	}

	public void scale () {
		int windowsize = Math.min(width, height);
		
		double maxsize = Math.max(maxHorz - minHorz, maxVert - minVert);
		double scalefactor = (windowsize - (2 * OFFSET)) / maxsize;
		lineLength = (lineLength * scalefactor);
		
		direction = INIT_DIRECTION;
		
		horz = Math.round((initHorz - minHorz) * scalefactor + ((width - (maxHorz - minHorz) * scalefactor) / 2.0));
		vert = Math.round((initVert - minVert) * scalefactor + ((height - (maxVert - minVert) * scalefactor) / 2.0));
	
	}

	@Override
	public void saveState() {
		TurtleState turtleState = new TurtleState(horz, vert, direction);
		savedStates.push(turtleState);
	}



	@Override
	public void recoverState() {
		TurtleState turtleState = savedStates.pop();
		this.horz = turtleState.getX();
		this.vert = turtleState.getY();
		this.direction = turtleState.getAngle();
	}
	
}
