package com.company.personservice.util;

import com.company.personservice.entity.Person;

import java.util.UUID;

public class PersonMessageUtil {

    private PersonMessageUtil() {
    }

    public static String onSavePerson(Person person) {
        return String.format("Save new person - %s %s", person.getFirstname(), person.getLastname());
    }

    public static String onSavePersonSuccess(Person person) {
        return String.format("New person was save with id = %d", person.getId());
    }

    public static String onGetPersonByUuid(UUID uuid) {
        return String.format("Get full info about person with uuid = %s", uuid);
    }

    public static String onGetPersonByUuidSuccess() {
        return "Full info about the person was successfully received";
    }

    public static String onGetAllPersonsWithoutDetails() {
        return "Get brief info about all registered persons";
    }

    public static String onGetAllPersonsWithoutDetailsSuccess() {
        return "Brief info all persons was successfully received";
    }
}
