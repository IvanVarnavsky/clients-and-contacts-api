package ru.unibell.clientsandcontactsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.unibell.clientsandcontactsapi.dto.EmailDto;
import ru.unibell.clientsandcontactsapi.service.EmailService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/{id}/emails")
    public List<EmailDto> getEmailsByClientId(@PathVariable Integer id) {
        return emailService.getEmailsByClientId(id);
    }

    @PostMapping("/{id}/emails")
    public Integer createEmail(@PathVariable Integer id, @RequestBody EmailDto dto) {
        return emailService.createEmail(id, dto);
    }
}
