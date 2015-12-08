package com.pmc1.gui;

import javax.swing.*;
import java.awt.*;

/**
 * The building panel class which draws all the entities used by the Elevator System.
 *
 * Created by Paul on 12/8/2015.
 */
public class BuildingPanel extends JPanel {
    private final String FRAME_TITLE = "Elevator System";
    private final int numFloors;
    private final int numElevators;
    private final int elevatorMaxCapacity;

    //Frame constants
    private final int frameXSize = 2000;
    private final int frameYSize = 2000;
//    private final int buildingBufferSize = 200;

    private final int elevatorDimensionDefaultXSize = 200;

    private int floorDimentionY;
    private int elevatorDimensionX;

    public BuildingPanel(final int numFloors, final int numElevators, final int elevatorMaxCapacity) {
        this.numFloors = numFloors;
        this.numElevators = numElevators;
        this.elevatorMaxCapacity = elevatorMaxCapacity;

        calculateDimensions();

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public Dimension getPreferredSize() {
        return new Dimension(frameXSize, frameYSize);
    }

    /**
     * Overridden method to draw the building and elevator system.
     * TODO: determine why this is being called twice
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
        drawBuilding(g);
    }

    /*
     * Helper method to draw out floors and elevators
     */
    private void drawBuilding(Graphics g) {
        Color evenFloorColor = Color.GRAY;
        Color oddFloorColor = Color.GRAY.brighter();
        Color elevatorColor = oddFloorColor.brighter();

        for (int i = 0; i < numFloors; i++) {
            g.setColor(i % 2 == 0 ? evenFloorColor : oddFloorColor);
            g.fillRect(0, i * floorDimentionY, frameXSize, floorDimentionY);
        }

        g.setColor(elevatorColor);
        for (int j = 1; j <= numElevators; j++) {
            int startingX = j * (frameXSize / (numElevators + 1)) - elevatorDimensionX / 2;
            g.fillRect(startingX, 0, elevatorDimensionX, frameYSize);
        }
    }

    /*
     * Helper method to calculate other dimensions used by this class
     */
    private void calculateDimensions() {
        // Y dimension of each floor for frame
        floorDimentionY = frameYSize / numFloors;
        // X dimension of each elevator
        elevatorDimensionX = frameXSize > elevatorDimensionDefaultXSize * numElevators ?
                elevatorDimensionDefaultXSize : frameXSize / (2 * numElevators);
    }
}
