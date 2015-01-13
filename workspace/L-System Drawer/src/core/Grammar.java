package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import jsjf.ArrayList;

/**
 * @author Rodrigo Lino da Costa
 *
 */
public class Grammar {
	
	
	int count;
	double angle;
	ArrayList<Rule> rules;
	
	/**
	 * Constructor of the grammar
	 * @param grammar name of the grammar to be created
	 */
	public Grammar(String grammar){
		rules = new ArrayList<Rule>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_PATH + "/" + grammar));
			String line = null;
			angle = Double.parseDouble(reader.readLine());
			
			while ((line = reader.readLine()) != null) {
				String[] ruleAsStrings = line.split(" -> ");
				Rule rule = new Rule(ruleAsStrings[0].charAt(0), ruleAsStrings[1]);
		    	rules.add(rule);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Grammar not found");
		}
	}
	
	/**
	 * @param head the head of the tail that will be returned
	 * @return the tail of the passed head
	 */
	public String getTail(char head){
		
		Iterator it = rules.iterator();
		while(it.hasNext()){
			Rule aux = (Rule)it.next();
			if (aux.getHead() == head){
				return aux.getTail();
			}
		}
		return "";
	}
	
	/**
	 * @return the angle of the grammar
	 */
	public double getAngle() {
		return angle;
	}
	
	@Override
	public String toString(){
		StringBuilder grammarInfoBuilder = new StringBuilder();
		
		grammarInfoBuilder.append(this.getAngle());
		
		Iterator it = rules.iterator();
		while(it.hasNext()){
			Rule aux = (Rule)it.next();
			grammarInfoBuilder.append("\n");
			grammarInfoBuilder.append(aux.toString());
		}
		
		return grammarInfoBuilder.toString() + "\n";
	}
}
