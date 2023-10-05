package edu.examples.java_classes.input;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Display {
	
	public void printMenu(ConcreteMenu m) {
		Set <Map.Entry<Integer, String>> items = m.getItems();
		System.out.println(m.getTitle());

		for(Map.Entry<Integer, String> item : items) {
			System.out.println(item.getKey() + " " + item.getValue());
		}
	}

	public void printString(String str){
		System.out.println(str);
	}

}
