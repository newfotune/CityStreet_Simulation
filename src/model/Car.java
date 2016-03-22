/*
 * Nwoke Fortune Chiemeziem Assagnment3 - easyStreet
 */

package model;

import java.util.Map;

/**
 * This is the car class. It represents the car in the GUI.
 * 
 * @author Nwoke Fortune Chiemeziem (n4tunec@uw.edu)
 * @version winter 2015.
 *
 */
public final class Car extends AbstractVehicle {

    /**
     * This is the constructor. It initialized my fields.
     * 
     * @param theX This is the X location of the car.
     * @param theY This is the Y location of the car.
     * @param theDir This is the direction of the car.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir);
    }

    /**
     * This method chooses the direction for the car.
     * 
     * @param theNeighbors This is the map containing the directions and their terrain.
     * @return the chosen direction.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {

        Direction direction = getDirection();

        if (theNeighbors.get(direction) == Terrain.STREET
            || theNeighbors.get(direction) == Terrain.LIGHT) {

            direction = getDirection();
        } else if (theNeighbors.get(direction.left()) == Terrain.STREET
                 && passable(theNeighbors.get(direction.left()))) {
            direction = getDirection().left();
        } else if (theNeighbors.get(direction.right()) == Terrain.STREET
                 && passable(theNeighbors.get(direction.right()))) {
            direction = getDirection().right();
        } else {
            direction = direction.reverse();
        }

        return direction;
    }

    /**
     * This is a helper method for determining if the car can pass a certain terrain.
     * 
     * @param theTerrain the terrain to be checked.
     * @return true if car can pass, else false.
     */
    // if it can pass this terrain, return true.
    private boolean passable(final Terrain theTerrain) {

        boolean isPassable = false;

        if (theTerrain == Terrain.STREET) {
            isPassable = true;
        }
        return isPassable;
    }

    /**
     * This method checks if the car can pass the specified terrain and light.
     * 
     * @param theTerrain The terrain to be checked.
     * @param theLight The light to be checked.
     * @return true of the car can pass, else false.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean isPassable = true;

        if (theTerrain == Terrain.LIGHT) {
            if (theLight == Light.RED) {
                isPassable = false;
            } else {
                if (theTerrain == Terrain.WALL || theTerrain == Terrain.GRASS
                    || theTerrain == Terrain.TRAIL) {
                    isPassable = false;
                }
            }
        }
        return isPassable;
    }
    
    /**
     * This methods returns a string representation the car.
     * @return the name of the vehicle.
     */
    public String toString() {
        return "car";
    }
}
