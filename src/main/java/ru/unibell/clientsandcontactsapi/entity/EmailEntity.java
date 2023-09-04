package ru.unibell.clientsandcontactsapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
    private String address = "";
    @ManyToOne
    @JoinColumn(name = "client_id")
    ClientEntity client;

    public EmailEntity(){}

    public EmailEntity(String address, ClientEntity client) {
        this.address = address;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
