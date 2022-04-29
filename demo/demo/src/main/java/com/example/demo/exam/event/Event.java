package com.example.demo.exam.event;

import com.example.demo.exam.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToMany
    List<Client> clientsSubscribed;

}
