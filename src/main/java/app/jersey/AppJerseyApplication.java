
package app.jersey;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppJerseyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new AppJerseyApplication()
				.configure(new SpringApplicationBuilder(AppJerseyApplication.class))
				.run(args);
	}

}
	