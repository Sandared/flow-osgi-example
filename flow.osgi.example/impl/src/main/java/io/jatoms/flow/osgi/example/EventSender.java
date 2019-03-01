package io.jatoms.flow.osgi.example;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

@Component(immediate = true)
public class EventSender extends TimerTask{

    @Reference
    private EventAdmin ea;

    private Timer timer = new Timer();
    private Event event;

    @Activate
    void activate() {
        event = new Event("myevent", new HashMap<String, Object>());
        timer.scheduleAtFixedRate(this, 0, 5000);
    }

    @Deactivate
    void deactivate(){
        timer.cancel();
    }

	@Override
	public void run() {
        ea.sendEvent(event);
        System.out.println("Event Sent!");
	}
}