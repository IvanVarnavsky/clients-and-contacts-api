package ru.unibell.clientsandcontactsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.unibell.clientsandcontactsapi.dto.ClientDto;
import ru.unibell.clientsandcontactsapi.dto.ContactDto;
import ru.unibell.clientsandcontactsapi.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

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

    @GetMapping("/{id}/contacts")
    public ContactDto getContactById(@PathVariable Integer id) {
        return clientService.getContactById(id);
    }
}
