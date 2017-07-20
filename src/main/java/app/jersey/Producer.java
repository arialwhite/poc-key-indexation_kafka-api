
package app.jersey;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
	
	private final GradientsBase data;
	
	Producer(GradientsBase data) {
		this.data = data;
	}
	
    public void run() {
		Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:29092");
        props.put("client.id", "GradientsProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
    	try {
	        for (final Gradients gradients : data.getGradients()) {
	        	for (final String style : gradients.getStyles()) {
	
	                ProducerRecord<String, String> data = new ProducerRecord<String, String>(
	                    "small_topic", gradients.getColor(), style);
	                producer.send(data);
	            }	
	        }
    	} finally {
    		producer.close();
    	}
    }
}