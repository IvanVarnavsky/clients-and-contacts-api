package ru.unibell.clientsandcontactsapi.dto;

import java.util.Objects;

public class PhoneDto {
    private String number = "";

    public PhoneDto(){

    }

    public PhoneDto(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneDto phoneDto = (PhoneDto) o;
        return Objects.equals(number, phoneDto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
