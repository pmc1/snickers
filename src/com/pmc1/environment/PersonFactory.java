package com.pmc1.environment;

import com.pmc1.entity.Floor;
import com.pmc1.entity.Person;

import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;

/**
 * Simple generator of people that gets start/destined floors from the supplied environment.
 * Created by Paul on 12/8/2015.
 */
public class PersonFactory {
    private ArrayList<Floor> floorList;
    private Environment environment;

    public PersonFactory(ArrayList<Floor> floorList, Environment environment) {
        this.floorList = floorList;
        this.environment = environment == null ? new RandomEnvironment(floorList.size()) : environment;
    }

    public Person generatePerson() {
        Person person = null;

        int startFloorInt = environment.getStartFloor(floorList.size());
        int destinationFloorInt = environment.getDestinationFloor(floorList.size() - 1);
        destinationFloorInt = destinationFloorInt < startFloorInt ? destinationFloorInt : destinationFloorInt + 1;

        person = new Person(floorList.get(destinationFloorInt));
        floorList.get(startFloorInt).getPeopleOnFloor().add(person);

        return person;
    }
}
