package ru.unibell.clientsandcontactsapi.service;

import ru.unibell.clientsandcontactsapi.dto.ClientDto;
import ru.unibell.clientsandcontactsapi.dto.ContactDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getAll();

    ClientDto getById(Integer id);

    Integer create(ClientDto dto);

    void update(Integer id, ClientDto dto);

    void delete(Integer id);

    ContactDto getContactById(Integer id);
}
