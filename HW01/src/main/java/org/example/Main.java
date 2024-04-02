// Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
// Пример решения:
// 1. Создайте новый Maven или Gradle проект, через Intellj IDEA.
// 2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1.
// 3. Создайте класс Person с полями firstName, lastName и age.
// 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
// 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.

package org.example;

import org.example.domain.Person;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        // add new persons into static List<Person>
        new Person("Petya", "Petin", ThreadLocalRandom.current().nextInt(20, 30));
        new Person("Misha", "Mishin", ThreadLocalRandom.current().nextInt(20, 30));
        new Person("Tanya", "Tanina", ThreadLocalRandom.current().nextInt(20, 30));

        // print original list of persons with hash codes
        System.out.println("Original list of persons (with hash codes):");
        Person.getPersons().stream()
                .map(x -> x.toString() + ", hash code:\t" + x.hashCode())
                .forEach(System.out::println);

        // serialization & printing
        String jsonPersons = Person.personsToJSON(Person.getPersons());
        System.out.println("\nPersons in the list (JSON):\n" + jsonPersons);

        // deserialization & printing
        List<Person> personsFromJson = Person.personsFromJSON(jsonPersons);
        System.out.println("\nConverted back into objects:");
        personsFromJson.forEach(System.out::println);

        // comparing original and JSON-originated persons
        System.out.println("\nComparing original Person.persons and personsFromJSON:");
        for (int i = 0; i < personsFromJson.size(); i++) {
            System.out.println("Person #" + (i+1) + " is the same: " +
                    Person.getPersons().get(i).equals(personsFromJson.get(i)));
        }

    }
}