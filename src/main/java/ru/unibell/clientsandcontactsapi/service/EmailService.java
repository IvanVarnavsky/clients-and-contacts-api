package ru.unibell.clientsandcontactsapi.service;

import ru.unibell.clientsandcontactsapi.dto.EmailDto;

import java.util.List;

public interface EmailService {

    List<EmailDto> getEmailsByClientId(Integer id);

    Integer createEmail(Integer id, EmailDto dto);

}
