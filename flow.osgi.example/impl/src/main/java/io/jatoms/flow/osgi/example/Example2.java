package io.jatoms.flow.osgi.example;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.osgi.service.event.propertytypes.EventTopics;

@Route("e2")
@Component(scope=ServiceScope.PROTOTYPE, service = HasElement.class)
@EventTopics("myevent")
public class Example2 extends VerticalLayout implements EventHandler{

    @Reference
    private GreeterService greeter;

    @Activate
    void acitvate () {
        Notification.show(greeter.greet("World"));
    }

	@Override
	public void handleEvent(Event event) {
        System.out.println("Event Received!");
        Notification.show(greeter.greet("Thomas"));
	}

}