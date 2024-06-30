package top.anyel.orm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.anyel.orm.models.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByEmailAndAddresses_City(String email, String city);
    List<Person> findByIdentification(String identification);
}
