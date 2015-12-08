package com.pmc1;

import com.pmc1.gui.BuildingPanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        final BuildingPanel buildingFrame = new BuildingPanel(5, 3, 10);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(buildingFrame);
            }
        });
    }

    private static void createAndShowGUI(BuildingPanel panel) {
        JFrame f = new JFrame("Elevator System");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.pack();
        f.setVisible(true);
    }
}
