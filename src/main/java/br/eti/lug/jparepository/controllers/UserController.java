package br.eti.lug.jparepository.controllers;

import br.eti.lug.jparepository.entities.User;
import br.eti.lug.jparepository.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        Page<User> result = repository.findAll(pageable);
        return ResponseEntity.ok(result);
    }
    // http://localhost:8080/users/page?page=0&size=12&sort=name,salary,asc

    @GetMapping(value = "/search-salary")
    public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
        Page<User> result = repository.searchSalary(minSalary, maxSalary, pageable);
        return ResponseEntity.ok(result);
    }
    // http://localhost:8080/users/search-salary?minSalary=9000
    // http://localhost:8080/users/search-salary?maxSalary=8000&size=5
    // http://localhost:8080/users/search-salary?minSalary=5000&maxSalary=10000

    @GetMapping(value = "/search-name")
    public ResponseEntity<Page<User>> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable) {
        Page<User> result = repository.findByNameContainingIgnoreCase(name, pageable);
        return ResponseEntity.ok(result);
    }
    // http://localhost:8080/users/search-name?name=maria

}
