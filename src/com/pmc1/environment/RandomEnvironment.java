package com.pmc1.system;

import java.util.ArrayList;
import com.pmc1.entity.Floor;

public class RandomEnvironment implements Environment {
    private ArrayList<Floor> floorList;

    public RandomEnvironment(ArrayList<Floor> floorList) {
        this.floorList = floorList;
    }

    public int getStartFloor() {

    }

    public int getDestinationFloor() {

    }
}
