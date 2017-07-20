
package app.jersey;

import org.springframework.stereotype.Component;

@Component
public class KafkaApiService {
	
	public void sendToKafka(GradientsBase data) {
		Producer producer = new Producer(data);
		producer.run();
	}

}
