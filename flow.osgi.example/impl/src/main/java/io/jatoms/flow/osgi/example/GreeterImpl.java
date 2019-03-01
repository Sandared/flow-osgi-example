package io.jatoms.flow.osgi.example;

import org.osgi.service.component.annotations.Component;

@Component
public class GreeterImpl implements GreeterService {

	@Override
	public String greet(String name) {
        return "Hello " + name;
	}

}