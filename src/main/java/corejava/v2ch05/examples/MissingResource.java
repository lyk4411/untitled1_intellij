package corejava.v2ch05.examples;

import java.util.ResourceBundle;

public class MissingResource {

	public static void main(String[] args) {
		ResourceBundle myResources = 
						ResourceBundle.getBundle("resources");
		String name = myResources.getString("name");
		String surname = myResources.getString("surname");
		String age = myResources.getString("age");
		System.out.println(String.format("Hello! I'm %s %s, %s years old",name, surname, age));
	}

}
