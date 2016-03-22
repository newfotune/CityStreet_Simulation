/*
 * Nwoke Fortune Chiemeziem Assagnment3 - easyStreet
 */

package model;

import java.util.Map;

/**
 * This is the bicycle class. It represents the bicycle in the GUI.
 * 
 * @author Nwoke Fortune Chiemeziem (n4tunec@uw.edu)
 * @version winter 2015.
 *
 */
public final class Bicycle extends AbstractVehicle {
    
    /** This is the additional death time of the bicycle. */
    private static final int BICYCLE_ADDIDTINAL_DEAD_TIME = 10;

    /**
     * This is the constructor. It initialized my fields.
     * 
     * @param theX This is the X location of the bicycle.
     * @param theY This is the Y location of the bicycle.
     * @param theDir This is the direction of the bicycle.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        // call the parent constructor.
        super(theX, theY, theDir);

    }
    /** This method chooses the direction for the bicycle.
     * @param theNeighbors This is the map containing the directions and their terrain.
     * @return the chosen direction.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {

        Direction direction = getDirection();

        if (theNeighbors.get(direction) == Terrain.TRAIL) {
            direction = getDirection();
        } else {
            
            if (theNeighbors.get(direction.left()) == Terrain.TRAIL) {
                direction = direction.left();
            } else if (theNeighbors.get(direction.right()) == Terrain.TRAIL) {
                
                direction = direction.right();
            } else if (theNeighbors.get(direction) == Terrain.STREET
                     || theNeighbors.get(direction) == Terrain.LIGHT) {
                
                direction = getDirection();
            } else if (theNeighbors.get(direction.left()) == Terrain.STREET
                     || theNeighbors.get(direction.left()) == Terrain.LIGHT) {
                
                direction = direction.left();
            } else if (theNeighbors.get(direction.right()) == Terrain.STREET
                     || theNeighbors.get(direction.right()) == Terrain.LIGHT) {
                
                direction = direction.right();
            } else {
                direction = direction.reverse();
            }

        }
        return direction;
    }

    /**
     * This method checks if the bicycle can pass the
     *  specified terrain and light.
     * @param theTerrain The terrain to be checked.
     * @param theLight The light to be checked.
     * @return true of the bicycle can pass, else false.
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean bicycleCanPass = true;

        if (theTerrain == Terrain.LIGHT) {

            if (theLight == Light.YELLOW || theLight == Light.RED
                || theTerrain == Terrain.WALL || theTerrain == Terrain.GRASS) {
                bicycleCanPass = false;
            }
        } else {
            if (theTerrain == Terrain.WALL || theTerrain == Terrain.GRASS) {

                bicycleCanPass = false;
            }
        }
        return bicycleCanPass;
    }

    /**
     * This method returns the death time of the bicycle.
     * @return the death time of the bicycle.
     */
    @Override
    public int getDeathTime() {
        return super.getDeathTime() + BICYCLE_ADDIDTINAL_DEAD_TIME;
    }

    /**
     * This methods returns a string representation the bicycle.
     * @return the name of the vehicle.
     */
    public String toString() {
        return "bicycle";
    }

}
