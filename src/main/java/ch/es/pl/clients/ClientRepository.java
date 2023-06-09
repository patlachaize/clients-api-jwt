package ch.es.pl.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {
    Optional<ClientEntity> findClientEntityByLogin(String login);
}