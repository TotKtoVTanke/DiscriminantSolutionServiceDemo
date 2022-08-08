package ru.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.demo.soap_service.DiscriminantSolutionService;

import javax.xml.ws.Endpoint;

@Component
public class ApplicationStartEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ApplicationContext applicationContext;

    @Value("${myServiceAddress}")
    String myServiceAddress;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        DiscriminantSolutionService discriminantSolutionService = applicationContext.getBean(DiscriminantSolutionService.class);

        Endpoint.publish(myServiceAddress, discriminantSolutionService);
    }
}
