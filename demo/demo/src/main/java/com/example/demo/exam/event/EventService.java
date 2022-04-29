package com.example.demo.exam.event;

import com.example.demo.exam.client.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    public void addClientToEvent(Event event, Client client) {
       List<Client> clientList =  event.getClientsSubscribed();
       clientList.add(client);
       event.setClientsSubscribed(clientList);
    }
}
