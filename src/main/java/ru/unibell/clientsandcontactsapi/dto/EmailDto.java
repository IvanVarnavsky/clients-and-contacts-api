package ru.unibell.clientsandcontactsapi.dto;

import java.util.Objects;

public class EmailDto {
    private String address = "";

    public EmailDto () {

    }

    public EmailDto(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDto emailDto = (EmailDto) o;
        return Objects.equals(address, emailDto.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
