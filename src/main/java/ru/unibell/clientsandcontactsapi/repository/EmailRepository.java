package ru.unibell.clientsandcontactsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.EmailEntity;

@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Integer> {

    void deleteAllByClient(ClientEntity client);

}
