
package app.jersey;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
	
	private final String servers;
	private final String topic;
	
	Producer(String host, String port, String topic) {
		this.servers = new StringBuilder()
						   .append(host)
						   .append(":")
						   .append(port)
						   .toString();
		this.topic = topic;
	}
	
    public void run(GradientsBase data) {
		Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("client.id", "GradientsProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
    	try {
	        for (final Gradients gradients : data.getGradients()) {
	        	for (final String style : gradients.getStyles()) {
	        		
	        		final String color = gradients.getColor();
	                final ProducerRecord<String, String> r = new ProducerRecord<>(topic, color, style);
	                
	                producer.send(r);
	            }	
	        }
    	} finally {
    		producer.close();
    	}
    }
}