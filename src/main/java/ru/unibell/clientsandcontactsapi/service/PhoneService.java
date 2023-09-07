package ru.unibell.clientsandcontactsapi.service;

import ru.unibell.clientsandcontactsapi.dto.PhoneDto;

import java.util.List;

public interface PhoneService {

    List<PhoneDto> getPhonesByClientId(Integer id);

    Integer createPhone(Integer id, PhoneDto dto);
}
