package edu.examples.java_classes.input;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ConcreteMenu {
	
	private String title;
	private Map<Integer, String> items = new HashMap<>();
	
	public ConcreteMenu(String title) {
		this.title = title;
	}

	public Set<Map.Entry<Integer, String>> getItems() {
		return items.entrySet();
	}

	public void setItems(Integer key, String item) {
		items.put(key, item);
	}

	public String getTitle() {
		return title;
	}
	
}
