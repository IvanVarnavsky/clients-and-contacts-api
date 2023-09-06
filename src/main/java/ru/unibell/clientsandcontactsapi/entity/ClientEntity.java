package ru.unibell.clientsandcontactsapi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = 0;
    private String name = "";
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<PhoneEntity> phones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<EmailEntity> emails;

    public ClientEntity() {

    }

    public ClientEntity(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }

    public List<EmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailEntity> emails) {
        this.emails = emails;
    }
}
