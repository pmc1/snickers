package com.pmc1.environment;

import java.lang.IndexOutOfBoundsException;

/**
 * Simple generator of people that gets start/destined floors from the supplied environment.
 * Created by Paul on 12/8/2015.
 */
public class PersonGenerator {
    private ArrayList<Floor> floorList;
    private Environment environment;

    public PersonGenerator(ArrayList<Floor> floorList, Environment environment) {
        this.floorList = floorList;
        this.environment = environment == null ? new RandomEnvironment() : environment;
    }

    public Person generatePerson() {
        try {
            Floor startFloor = floorList.get(environment.getStartFloor());
            Floor desiredFloor = floorList.get(environment.getDestinedFloor());

            Person person = new Person(desiredFloor);
            startFloor.getPeopleOnFloor().add(person);
        } catch (IndexOutOfBoundsException e) {
            //TODO: log and count error
            System.out.println("Generated person on floor " + startFloorNumber + " with desired floor " + desiredFloor);
        }
    }
}
