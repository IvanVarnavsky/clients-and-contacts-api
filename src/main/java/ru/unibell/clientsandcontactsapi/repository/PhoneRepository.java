package ru.unibell.clientsandcontactsapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;
import ru.unibell.clientsandcontactsapi.entity.PhoneEntity;

public interface PhoneRepository extends CrudRepository<PhoneEntity, Integer> {

    public void deleteAllByClient(ClientEntity client);
}
