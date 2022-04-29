package com.example.demo.exam.client;

import com.example.demo.exam.client.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    public boolean validName(String name) {
        return Optional.ofNullable(name).filter(n -> n.length() > 3).isPresent();
    }

    public boolean validClient(Client client) {
        return validName(client.getFirstName()) && validName(client.getLastName());
    }
}
