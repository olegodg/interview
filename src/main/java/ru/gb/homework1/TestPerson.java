package ru.gb.homework1;


import lombok.extern.java.Log;

@Log
public class TestPerson {
    public static void main(String[] args) {
        Person person = Person.createBuilder()
                .withFirstName("Alex")
                .withLastName("Juice")
                .withMiddleName("Banana")
                .withAddress("Problem Street")
                .withGender("F")
                .withAge(19)
                .withCountry("Latvia")
                .withPhone("3424242424")
                .build();



     log.info(person.toString());//



    }
}
