package es.inetum.quarkus.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import es.inetum.quarkus.service.GreetingService;
import io.quarkus.logging.Log;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService {

	@ConfigProperty(name="greeting.message")
	String message;
	
	@ConfigProperty(name="greeting.name")
	String name;
	
	@ConfigProperty(name="greeting.suffix", defaultValue = "!")
	String suffix;
	
	@Override
	public String greet() {
		return message+" "+name+suffix;
	}
	
	public void onStart(@Observes StartupEvent ev) {
		Log.info("Greeting Service is starting...");
	}
	
	public void onStop(@Observes ShutdownEvent ev) {
		Log.info("Greeting Service is stopping...");
	}

}
