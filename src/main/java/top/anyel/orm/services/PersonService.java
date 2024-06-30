package top.anyel.orm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.orm.models.Address;
import top.anyel.orm.models.Person;
import top.anyel.orm.models.enums.AddressType;
import top.anyel.orm.repositories.PersonRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public Person save(Person person) {
        // Set person reference in addresses
        if (person.getAddresses() != null) {
            for (Address address : person.getAddresses()) {
                address.setPerson(person);
            }
        }
        return personRepository.save(person);
    }
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    public Person findById(Long id){
        return personRepository.findById(id).orElse(null);
    }
    public Person updateById(Long id, Person person){
        if (personRepository.existsById(id)) {
            person.setId(id);
            return personRepository.save(person);
        }
        return null;
    }

    public String deleteById(Long id){
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return "Person with id " + id + " was deleted";
        }
        return "Person with id " + id + " was not found";
    }

    public List<Address> findHouseAddressesById(Long id) {
        Person person = findById(id);
        if (person != null) {
            return person.getAddresses().stream()
                    .filter(address -> address.getAddressType() == AddressType.HOUSE)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public List<Person> findAllByEmailCity(String email, String city) {
        return personRepository.findAllByEmailAndAddresses_City(email, city);
    }

    public List<Person> findByIdentification(String identification) {
        return personRepository.findByIdentification(identification);
    }
}
