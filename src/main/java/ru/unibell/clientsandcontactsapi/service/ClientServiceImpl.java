package ru.unibell.clientsandcontactsapi.service;

import org.springframework.stereotype.Service;
import ru.unibell.clientsandcontactsapi.dto.ClientDto;
import ru.unibell.clientsandcontactsapi.dto.ContactDto;
import ru.unibell.clientsandcontactsapi.dto.EmailDto;
import ru.unibell.clientsandcontactsapi.dto.PhoneDto;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.EmailEntity;
import ru.unibell.clientsandcontactsapi.entity.PhoneEntity;
import ru.unibell.clientsandcontactsapi.repository.ClientRepository;
import ru.unibell.clientsandcontactsapi.repository.EmailRepository;
import ru.unibell.clientsandcontactsapi.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;
    private final EmailRepository emailRepository;

    public ClientServiceImpl(ClientRepository clientRepository, PhoneRepository phoneRepository, EmailRepository emailRepository) {
        this.clientRepository = clientRepository;
        this.phoneRepository = phoneRepository;
        this.emailRepository = emailRepository;
    }

    @Override
    public List<ClientDto> getAll() {
        List<ClientDto> list = new ArrayList<>();
        Iterable<ClientEntity> clients = clientRepository.findAll();
        for (ClientEntity client : clients) {
            list.add(new ClientDto(client.getId(), client.getName(), getPhones(client), getEmails(client)));
        }
        return list;
    }

    @Override
    public ClientDto getById(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return new ClientDto(client.getId(), client.getName(), getPhones(client), getEmails(client));
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public Integer create(ClientDto dto) {
        return clientRepository.save(new ClientEntity(dto.getName())).getId();
    }

    @Override
    public void update(Integer id, ClientDto dto) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            client.setName(dto.getName());
            clientRepository.save(client);
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public void delete(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            clientRepository.deleteById(id);
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public List<PhoneDto> getPhonesByClientId(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return getPhones(client);
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public Integer createPhone(Integer id, PhoneDto dto) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return phoneRepository.save(new PhoneEntity(dto.getNumber(), client)).getId();
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public List<EmailDto> getEmailsByClientId(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return getEmails(client);
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public Integer createEmail(Integer id, EmailDto dto) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return emailRepository.save(new EmailEntity(dto.getAddress(), client)).getId();
        }
        else
            throw new RuntimeException("Client not found");
    }

    @Override
    public ContactDto getContactById(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return new ContactDto(getPhones(client), getEmails(client));
        }
        else
            throw new RuntimeException("Client not found");
    }

    public List<PhoneDto> getPhones(ClientEntity client) {
        List<PhoneDto> phones = new ArrayList<>();;
        for (PhoneEntity phone : client.getPhones()){
            phones.add(new PhoneDto(phone.getNumber()));
        }
        return phones;
    }

    public List<EmailDto> getEmails(ClientEntity client) {
        List<EmailDto> emails = new ArrayList<>();;
        for (EmailEntity email : client.getEmails()){
            emails.add(new EmailDto(email.getAddress()));
        }
        return emails;
    }
}
