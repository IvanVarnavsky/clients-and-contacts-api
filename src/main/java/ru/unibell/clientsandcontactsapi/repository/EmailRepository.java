package ru.unibell.clientsandcontactsapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.EmailEntity;

public interface EmailRepository extends CrudRepository<EmailEntity, Integer> {

    public void deleteAllByClient(ClientEntity client);
}
