package com.pmc1.environment;

import com.pmc1.entity.Floor;
import com.pmc1.entity.Person;

import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;

/**
 * Simple generator of people that gets start/destined floors from the supplied environment.
 * Created by Paul on 12/8/2015.
 */
public class PersonGenerator {
    private ArrayList<Floor> floorList;
    private Environment environment;

    public PersonGenerator(ArrayList<Floor> floorList, Environment environment) {
        this.floorList = floorList;
        this.environment = environment == null ? new RandomEnvironment(floorList.size()) : environment;
    }

    public Person generatePerson() {
        Person person = null;

        int startFloorInt = environment.getStartFloor();
        int destinationFloorInt = environment.getDestinationFloor();
        while (destinationFloorInt == startFloorInt) {
            destinationFloorInt = environment.getDestinationFloor();
        }
        try {
            Floor startFloor = floorList.get(startFloorInt);
            Floor desiredFloor = floorList.get(destinationFloorInt);

            person = new Person(desiredFloor);
            startFloor.getPeopleOnFloor().add(person);
        } catch (IndexOutOfBoundsException e) {
            //TODO: log and count error
            System.out.println("Generated person on floor " + startFloorInt + " with desired floor " + destinationFloorInt);
        }
        return person;
    }
}
