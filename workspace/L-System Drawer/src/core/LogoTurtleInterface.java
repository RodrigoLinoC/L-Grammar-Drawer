package core;

/**
 * @author Rodrigo
 * Interface that defines what a LogoTurtle needs  
 */
public interface LogoTurtleInterface {

	/**
	 * Change the current angle in currentAngle + angle
	 * @param angle how much to change the current angle
	 */
	public abstract void turnLeft(double angle);

	/**
	 * Change the current angle in currentAngle - angle
	 * @param angle how much to change the current angle
	 */
	public abstract void turnRight(double angle);

	/**
	 * Put the pen down, which means that when the turtle walk it will draw a line
	 */
	public abstract void penUp();

	/**
	 * Put the pen up, which means that when the turtle walk it will not draw a line
	 */
	public abstract void penDown();

	/**
	 * Change the current location of the turtle, based on the angle and the current line length
	 */
	public abstract void forward();
	
	/**
	 * Defines a new start point and a new line lenght based on the last drawn
	 */
	public abstract void scale();

	/**
	 * Save the current state of the turtle on a stack
	 */
	public abstract void saveState();

	/**
	 * Set the state of the turtle to the last saved state
	 */
	public abstract void recoverState();

}
