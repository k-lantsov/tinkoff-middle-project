package com.company.personservice.util;

import com.company.personservice.entity.Person;

public class PersonMessageUtil {

    private PersonMessageUtil() {
    }

    public static String onSavePerson(Person person) {
        return String.format("Create new person - %s %s", person.getFirstname(), person.getLastname());
    }

    public static String onSavePersonSuccess(Person person) {
        return String.format("New person was saved with id = %d", person.getId());
    }
}
