package com.example.demo.exam.client;

import com.example.demo.exam.config.exceptions.ClientAlreadyExistsException;
import com.example.demo.exam.config.exceptions.InvalidClientException;
import com.example.demo.exam.config.exceptions.NoClientsFoundException;
import com.example.demo.exam.event.Event;
import com.example.demo.exam.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    ClientService clientService;


    @PostMapping("/addClient")
    public void addClient(@RequestBody Client client) throws InvalidClientException, ClientAlreadyExistsException {
        if (!clientService.validClient(client)) {
            throw new InvalidClientException("Not a valid client");
        }
        if (clientRepository.existsById(client.getId())) {
            throw new ClientAlreadyExistsException("Client already exists");
        }

        clientRepository.save(client);
    }

    @PostMapping("/subscribe/{name}")
    public void subscribeToEvent(@RequestParam String name) {

    }

    @GetMapping("{clientId}/allEvents")
    public List<Event> displayAllEventsAClientSubscribed(@RequestParam Long clientId) throws NoClientsFoundException {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            return client.get().getSubscribedEvents();
        } else {
            throw new NoClientsFoundException("No such client found");
        }

    }
}
