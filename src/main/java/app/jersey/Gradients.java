
package app.jersey;

import java.util.List;
import java.util.ArrayList;

public class Gradients {
	
	private String color = "";
	private List<String> styles = new ArrayList<String>();
	
	Gradients() {}

	public List<String> getStyles() {
		return styles;
	}

	public void setStyles(List<String> styles) {
		this.styles = styles;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
