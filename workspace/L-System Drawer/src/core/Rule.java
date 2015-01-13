package core;

public class Rule {
	
	char head;
	String tail;
	
	/**
	 * @param head head of the rule
	 * @param tail tail of the rule
	 */
	public Rule(char head, String tail){
		this.head = head;
		this.tail = tail;
	}

	/**
	 * @return the head of the rule
	 */
	public char getHead() {
		return head;
	}

	/**
	 * @param head the head of the rule
	 */
	public void setHead(char head) {
		this.head = head;
	}

	/**
	 * @return the rail of the rule
	 */
	public String getTail() {
		return tail;
	}

	/**
	 * @param tail tail of the rule
	 */
	public void setTail(String tail) {
		this.tail = tail;
	}
	
	@Override
	public String toString(){
		return head + " -> " + tail;
	}

}
