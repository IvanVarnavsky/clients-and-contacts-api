package ru.unibell.clientsandcontactsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.unibell.clientsandcontactsapi.dto.PhoneDto;
import ru.unibell.clientsandcontactsapi.service.PhoneService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/{id}/phones")
    public List<PhoneDto> getPhonesByClientId(@PathVariable Integer id) {
        return phoneService.getPhonesByClientId(id);
    }

    @PostMapping("/{id}/phones")
    public Integer createPhone(@PathVariable Integer id, @RequestBody PhoneDto dto) {
        return phoneService.createPhone(id, dto);
    }
}
