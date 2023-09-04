package ru.unibell.clientsandcontactsapi.controller;

import org.springframework.web.bind.annotation.*;
import ru.unibell.clientsandcontactsapi.dto.ClientDto;
import ru.unibell.clientsandcontactsapi.dto.ContactDto;
import ru.unibell.clientsandcontactsapi.dto.EmailDto;
import ru.unibell.clientsandcontactsapi.dto.PhoneDto;
import ru.unibell.clientsandcontactsapi.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDto> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable Integer id) {
        return clientService.getById(id);
    }

    @PostMapping
    public Integer create(@RequestBody ClientDto dto) {
        return clientService.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ClientDto dto) {
        clientService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        clientService.delete(id);
    }

    @GetMapping("/{id}/phones")
    public List<PhoneDto> getPhonesByClientId(@PathVariable Integer id) {
        return clientService.getPhonesByClientId(id);
    }

    @PostMapping("/{id}/phones")
    public Integer createPhone(@PathVariable Integer id, @RequestBody PhoneDto dto) {
        return clientService.createPhone(id, dto);
    }

    @GetMapping("/{id}/emails")
    public List<EmailDto> getEmailsByClientId(@PathVariable Integer id) {
        return clientService.getEmailsByClientId(id);
    }

    @PostMapping("/{id}/emails")
    public Integer createEmail(@PathVariable Integer id, @RequestBody EmailDto dto) {
        return clientService.createEmail(id, dto);
    }

    @GetMapping("/{id}/contacts")
    public ContactDto getContactById(@PathVariable Integer id) {
        return clientService.getContactById(id);
    }
}
