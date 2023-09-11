package ru.unibell.clientsandcontactsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.unibell.clientsandcontactsapi.dto.EmailDto;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.EmailEntity;
import ru.unibell.clientsandcontactsapi.exception.ClientNotFoundException;
import ru.unibell.clientsandcontactsapi.repository.ClientRepository;
import ru.unibell.clientsandcontactsapi.repository.EmailRepository;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<EmailDto> getEmailsByClientId(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return EmailDto.getEmails(client);
        }
        else
            throw new ClientNotFoundException(id);
    }

    @Override
    public Integer createEmail(Integer id, EmailDto dto) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return emailRepository.save(new EmailEntity(dto.getAddress(), client)).getId();
        }
        else
            throw new ClientNotFoundException(id);
    }

}
