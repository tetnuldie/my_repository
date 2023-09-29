package edu.examples.java_classes.input;

import java.util.HashMap;
import java.util.Map;

public class MenuSelectionSystem {
	
	private Map<Menu, ConcreteMenu> menu = new HashMap<>();
	
	
	public MenuSelectionSystem() {}
	
	public void add(Menu key, ConcreteMenu m) {
		menu.put(key, m);
	}
	
	
	public ConcreteMenu getMenu(Menu key) {
		return menu.get(key);
	}	

}
