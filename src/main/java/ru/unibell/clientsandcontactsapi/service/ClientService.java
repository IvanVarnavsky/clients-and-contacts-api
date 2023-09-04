package ru.unibell.clientsandcontactsapi.service;

import ru.unibell.clientsandcontactsapi.dto.ClientDto;
import ru.unibell.clientsandcontactsapi.dto.ContactDto;
import ru.unibell.clientsandcontactsapi.dto.EmailDto;
import ru.unibell.clientsandcontactsapi.dto.PhoneDto;

import java.util.List;

public interface ClientService {

    public List<ClientDto> getAll();

    public ClientDto getById(Integer id);

    public Integer create(ClientDto dto);

    public void update(Integer id, ClientDto dto);

    public void delete(Integer id);

    public List<PhoneDto> getPhonesByClientId(Integer id);

    public Integer createPhone(Integer id, PhoneDto dto);

    public List<EmailDto> getEmailsByClientId(Integer id);

    public Integer createEmail(Integer id, EmailDto dto);

    public ContactDto getContactById(Integer id);
}
