package ru.unibell.clientsandcontactsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.unibell.clientsandcontactsapi.dto.PhoneDto;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.PhoneEntity;
import ru.unibell.clientsandcontactsapi.repository.ClientRepository;
import ru.unibell.clientsandcontactsapi.repository.PhoneRepository;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<PhoneDto> getPhonesByClientId(Integer id) {
        if (clientRepository.findById(id).isPresent()) {
            ClientEntity client = clientRepository.findById(id).get();
            return PhoneDto.getPhones(client);
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

}
