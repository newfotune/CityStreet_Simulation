/*
 * Nwoke Fortune Chiemeziem
 *  Assagnment3 - easyStreet
 */
package tests;


import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the truck vehicle.
 * @author Nwoke Chiemeziem Fortune (n4tunec@uw.edu)
 * @version winter 2015
 *
 */
public class TruckTest {
    /**This is my test vehicle. */
    private Truck myTruck;
    /**
     * This method sets up my vehicle before each test.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        myTruck = new Truck(10, 10, Direction.CENTER);
    }

    /**
     * This test the canPass method.
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPass() {
        
        final Terrain[] falseTerrains = {Terrain.WALL, Terrain.GRASS, Terrain.TRAIL};
        final Light[] allLights = {Light.GREEN, Light.YELLOW, Light.RED}; 
        
        for (int lights = 0; lights < allLights.length; lights++) {
            
            for (int terrains = 0; terrains < falseTerrains.length; terrains++) {
                assertEquals("truck canPass failed " + falseTerrains[terrains]
                           + allLights[lights], false, myTruck.canPass(falseTerrains[terrains],
                                                                       allLights[lights]));
                             
            }    
        }
        
        final Terrain[] trueTerrains = {Terrain.STREET, Terrain.LIGHT};
        for (int lights = 0; lights < allLights.length; lights++) {
            
            for (int terrains = 0; terrains < trueTerrains.length; terrains++) {
                assertEquals("truck canPass failed " + trueTerrains[terrains] 
                            + allLights[lights], true,  myTruck.canPass(trueTerrains[terrains],
                                                                       allLights[lights]));
                            
            }    
        }
        
        
        
    }

    /**
     * This tests the chooseDirection Method.
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirection() {
        
        final Direction initialDirection = myTruck.getDirection();
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(initialDirection.right(), Terrain.GRASS);
       // neighbors.put(initialDirection.left(), Terrain.WALL);
        neighbors.put(initialDirection, Terrain.TRAIL);
        neighbors.put(initialDirection.left(), Terrain.STREET);
        
        assertEquals(Direction.CENTER, myTruck.chooseDirection(neighbors));
        neighbors.clear();
        neighbors.put(Direction.WEST, Terrain.GRASS);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.SOUTH, Terrain.TRAIL);
        neighbors.put(Direction.EAST, Terrain.WALL);
        neighbors.put(Direction.CENTER, Terrain.GRASS);
       
        assertEquals(initialDirection.reverse(), myTruck.chooseDirection(neighbors));
        
        neighbors.clear();
        neighbors.put(initialDirection.right(), Terrain.GRASS);
        neighbors.put(initialDirection, Terrain.TRAIL);
        neighbors.put(initialDirection.left(), Terrain.LIGHT);
        assertEquals(Direction.CENTER, myTruck.chooseDirection(neighbors));
      
    }

    /**
     * This tests the getDeathTime method.
     * Test method for {@link model.Truck#getDeathTime()}.
     */
    @Test
    public void testGetDeathTime() {
        assertEquals("getDeathTime() failed", 0 , myTruck.getDeathTime()); // TODO
    }

    /**
     * This tests the constructor.
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testTruck() {
        assertEquals("Truck Constructor failed", 10, myTruck.getX());
        assertEquals("Truck Constructor failed", 10, myTruck.getY());
        assertEquals("Truck Constructor failed", Direction.CENTER, myTruck.getDirection());
    }

    /**
     * This tests the toString method.
     * Test method for {@link model.Truck#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Truck toString() failed", "truck", myTruck.toString()); // TODO
    }

}
