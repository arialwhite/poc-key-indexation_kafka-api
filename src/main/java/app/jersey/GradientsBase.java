
package app.jersey;

import java.util.List;
import java.util.ArrayList;

public class GradientsBase {

	private List<Gradients> gradients = new ArrayList<Gradients>();
	
	GradientsBase() {}

	public List<Gradients> getGradients() {
		return gradients;
	}

	public void setGradients(List<Gradients> gradients) {
		this.gradients = gradients;
	}
}
