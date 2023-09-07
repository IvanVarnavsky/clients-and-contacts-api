package ru.unibell.clientsandcontactsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.unibell.clientsandcontactsapi.entity.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {
}
