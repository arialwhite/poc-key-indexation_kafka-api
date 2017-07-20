
package app.jersey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaApiService {

	@Value("${KAFKA_HOST:kafka}")
	private String host;

	@Value("${KAFKA_PORT:29092}")
	private String port;
	
	@Value("${KAFKA_TARGET_TOPIC:small_topic}")
	private String topic;

	
	public void sendToKafka(GradientsBase data) {
		Producer producer = new Producer(host, port, topic);
		producer.run(data);
	}

}
