package ru.unibell.clientsandcontactsapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
}
