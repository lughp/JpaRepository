package br.eti.lug.jparepository.repositories;

import br.eti.lug.jparepository.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

}
