package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String,Double> nameToHeight = new HashMap < > ();
		
		nameToHeight.put("Sindhu", 65.0);
		nameToHeight.put("Ramya", 63.0);
		nameToHeight.put("Cai", 75.0);
		nameToHeight.put("David", 71.0);
		
		System.out.println("Enter in a name:");
		String name = in.next();
		
		while(!name.equals("quit")){
				
			if(nameToHeight.containsKey(name)== true) {
				System.out.println("the height of " + name + " is " + nameToHeight.get(name));
	
				}
			else {
				System.out.println("invalid name, no height associated.");
			}
			System.out.println("Enter in a name: ");
			name= in.next();
	    }

	}
}
