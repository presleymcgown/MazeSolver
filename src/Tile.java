import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GRect;

import java.awt.*;

public class Tile extends GCompound {

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public static final double TILEW = 50;
    public static final double TILEH = 50;

    private boolean[] wall; // keeps track of whether there is a wall at a given index
    private Maze maze; // the Maze object that this tile belongs to
    private int row; // the row in the maze that this Tile is in
    private int col; // the column in the maze that this Tile is in

    private GRect body;
    private GLine NWall;
    private GLine EWall;
    private GLine SWall;
    private GLine WWall;


    /**
     * Makes the correct walls visible.
     */
    public void drawTile(){

    }

    /**
     * Returns the opposite value for a direction integer
     * @param direction non-negative integer, 0-3
     * @return the opposite diction value
     */
    public int getOppDir(int direction){

    }

    /**
     * Determine if a tile has a wall in a given direction
     * @param direction non-negative integer, 0-3
     * @return true if wall exists
     */
    public boolean hasWall(int direction){

    }

    /**
     * Color in the "rect" object
     * @param color the color to use for painting.
     */
    public void fillColor(Color color){

    }

    /**
     * Activate or Deactivate a wall.
     * @param direction the wall to target
     * @param status true to turn on wall, false to turn wall off
     */
    public void setWall(int direction, boolean status){

    }

    /**
     * Finds neighboring tile (if it exists) in a given direction.
     * @param direction the direction to check in
     * @return a Tile if not null
     */
    public Tile getNeighbor(int direction){

    }

    /**
     * Does the wall have a neighbor in a given direction?
     * @param direction where to look
     * @return true if neighbor exists
     */
    public boolean hasNeighbor(int direction){

    }

    public static void main(String[] args) {

    }



}
