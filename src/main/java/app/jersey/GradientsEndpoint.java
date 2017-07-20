
package app.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/gradients")
public class GradientsEndpoint {

	private final Service service;

	public Endpoint(Service service) {
		this.service = service;
	}

	@GET
	public String message() {
		return "kafka-api is alive";
	}	
	
	@POST
	@Consumes({"application/json"})
	public Response placeOrder(GradientsBase data) {
		for (Gradients gradients : data.getGradients()) {
			for (String style : gradients.getStyles()) {
				System.out.println("got gradient "+style);
			}
		}
		
		this.service.sendToKafka(data);
		return Response.accepted().build();
	}

}
