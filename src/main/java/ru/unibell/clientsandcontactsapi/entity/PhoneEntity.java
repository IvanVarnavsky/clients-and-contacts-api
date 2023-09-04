package ru.unibell.clientsandcontactsapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
    private String number = "";
    @ManyToOne
    @JoinColumn(name = "client_id")
    ClientEntity client;

    public PhoneEntity() {
    }

    public PhoneEntity(String number, ClientEntity client) {
        this.client = client;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
