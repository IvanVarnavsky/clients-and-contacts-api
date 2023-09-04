package ru.unibell.clientsandcontactsapi.dto;

import java.util.List;
import java.util.Objects;

public class ContactDto {
    private List<PhoneDto> phones;
    private List<EmailDto> emails;

    public ContactDto(){}
    public ContactDto(List<PhoneDto> phones, List<EmailDto> emails) {
        this.phones = phones;
        this.emails = emails;
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
        ContactDto that = (ContactDto) o;
        return Objects.equals(phones, that.phones) && Objects.equals(emails, that.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phones, emails);
    }
}
