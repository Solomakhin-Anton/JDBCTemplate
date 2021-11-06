package springMVC.dao;

import org.springframework.stereotype.Component;
import springMVC.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT,  "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        // Лямбда - выражение: среди people ищем человека с id == id на входе, если нет - возвращаем null
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        // Динамически генерирует id при добавлении в БД
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
