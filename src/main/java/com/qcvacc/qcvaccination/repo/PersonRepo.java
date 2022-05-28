package com.qcvacc.qcvaccination.repo;

import com.qcvacc.qcvaccination.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person,Long> {
    @Transactional
    void deletePersonById(Long id);

    Optional<Person> findPersonById(Long id);
}
