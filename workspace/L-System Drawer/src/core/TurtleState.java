package core;

/**
 * @author Rodrigo Lino da Costa
 *
 */
public class TurtleState {


	double x;
	double y;
	double angle;
	
	/**
	 * Constructor of the state
	 * @param x coordinate x of the state
	 * @param y coordinate y of the state
	 * @param angle angle of the state
	 */
	public TurtleState(double x, double y, double angle){
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	/**
	 * @return the coordinate X of the state
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x set the coordinate X of the state
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the coordinate Y of the state
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y set the coordinate Y of the state
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @return the angle of the state
	 */
	public double getAngle() {
		return angle;
	}
	/**
	 * @param angle sets the angle of the state
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	
}
