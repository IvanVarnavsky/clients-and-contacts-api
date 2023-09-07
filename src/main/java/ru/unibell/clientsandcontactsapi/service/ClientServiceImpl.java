package ru.unibell.clientsandcontactsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.unibell.clientsandcontactsapi.dto.ClientDto;
import ru.unibell.clientsandcontactsapi.dto.ContactDto;
import ru.unibell.clientsandcontactsapi.dto.EmailDto;
import ru.unibell.clientsandcontactsapi.dto.PhoneDto;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDto> getAll() {
        List<ClientDto> list = new ArrayList<>();
        Iterable<ClientEntity> clients = clientRepository.findAll();
        for (ClientEntity client : clients) {
            list.add(new ClientDto(client.getId(), client.getName(), PhoneDto.getPhones(client), EmailDto.getEmails(client)));
        }
        return list;
    }

    @Override
    public ClientDto getById(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return new ClientDto(client.getId(), client.getName(), PhoneDto.getPhones(client), EmailDto.getEmails(client));
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
    public ContactDto getContactById(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return new ContactDto(PhoneDto.getPhones(client), EmailDto.getEmails(client));
        }
        else
            throw new RuntimeException("Client not found");
    }

}
