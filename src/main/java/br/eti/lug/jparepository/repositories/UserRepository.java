package br.eti.lug.jparepository.repositories;

import br.eti.lug.jparepository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
