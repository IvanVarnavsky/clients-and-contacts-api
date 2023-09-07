package ru.unibell.clientsandcontactsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.PhoneEntity;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, Integer> {

    void deleteAllByClient(ClientEntity client);

}
