package ru.unibell.clientsandcontactsapi.dto;

import java.util.List;
import java.util.Objects;

public class ClientDto {
    private Integer id;
    private String name;
    private List<PhoneDto> phones;
    private List<EmailDto> emails;

    public ClientDto() {

    }

    public ClientDto(Integer id, String name, List<PhoneDto> phones, List<EmailDto> emails) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.emails = emails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }

    public List<EmailDto> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDto> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) && Objects.equals(name, clientDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
