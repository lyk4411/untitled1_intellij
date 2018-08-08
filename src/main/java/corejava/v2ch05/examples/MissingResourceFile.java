package corejava.v2ch05.examples;

import java.util.ResourceBundle;

public class MissingResourceFile {

	public static void main(String[] args) {
		//this will throw the exception
		ResourceBundle myResources = ResourceBundle.getBundle("test");
		
	}

}
