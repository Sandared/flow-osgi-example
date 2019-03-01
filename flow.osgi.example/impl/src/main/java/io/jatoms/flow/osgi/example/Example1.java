package io.jatoms.flow.osgi.example;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Route("e1")
@Component(scope=ServiceScope.PROTOTYPE, service = HasElement.class)
public class Example1 extends VerticalLayout{

    @Reference
    private  GreeterService greeter;

    // Here we use @Activate on a constructor
    @Activate
    public Example1() {
        Button button = new Button("Click me",
                event -> Notification.show(greeter.greet("Thomas")));
        add(button);
    }

}
