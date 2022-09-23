import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GRect;

import java.awt.*;

public class Tile extends GCompound {

    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public static final double TILEW = 20;
    public static final double TILEH = 20;

    private boolean[] wall; // keeps track of whether there is a wall at a given index
    private Maze maze; // the Maze object that this tile belongs to
    private int row; // the row in the maze that this Tile is in
    private int col; // the column in the maze that this Tile is in

    private GRect rect;
    private GLine NWall;
    private GLine EWall;
    private GLine SWall;
    private GLine WWall;

    public Tile(Maze maze, int row, int col){

        this(maze, row, col, false, false, false, false);

    }

    public Tile(Maze maze, int row, int col, boolean nw, boolean ew, boolean sw, boolean ww){

        this.maze = maze;
        this.row = row;
        this.col = col;

        //initialize boolean array
        wall = new boolean[4];

        wall[NORTH]= nw;
        wall[EAST] = ew;
        wall[SOUTH] = sw;
        wall[WEST] = ww;

        // the GRect represents the tile itself
        rect = new GRect(1, 1, TILEW - 1 , TILEH - 1);
        rect.setColor(Color.WHITE);
        add(rect);

        // the GLines that represent the wall
        NWall = new GLine(0, 0, TILEW, 0);
        add(NWall);

        EWall = new GLine(TILEW, 0, TILEW, TILEH);
        add(EWall);

        SWall = new GLine(TILEW, TILEH, 0, TILEH);
        add(SWall);

        WWall = new GLine(0, TILEH, 0, 0);
        add(WWall);

        drawTile();
        

    }


    /**
     * Makes the correct walls visible.
     */
    public void drawTile(){

        NWall.setVisible(false);
        EWall.setVisible(false);
        SWall.setVisible(false);
        WWall.setVisible(false);

        // set the visibility of the walls based on whether there is a wall in that direction or not
        NWall.setVisible(hasWall(NORTH));
        EWall.setVisible(hasWall(EAST));
        SWall.setVisible(hasWall(SOUTH));
        WWall.setVisible(hasWall(WEST));

        this.repaint();

    }

    /**
     * Returns the opposite value for a direction integer
     * @param direction non-negative integer, 0-3
     * @return the opposite diction value
     */
    public int getOppDir(int direction){

        return (direction + 2) % 4;

    }

    /**
     * Determine if a tile has a wall in a given direction
     * @param direction non-negative integer, 0-3
     * @return true if wall exists
     */
    public boolean hasWall(int direction){

        return wall[direction];

    }

    /**
     * Color in the "rect" object
     * @param color the color to use for painting.
     */
    public void fillColor(Color color){

        rect.setColor(color);
        rect.setFillColor(color);
        rect.setFilled(true);


    }

    /**
     * Activate or Deactivate a wall.
     * @param direction the wall to target
     * @param status true to turn on wall, false to turn wall off
     */
    public void setWall(int direction, boolean status) {

        // if we get "true" for status,
        // if there is not already a wall...
        // set the wall array in that direction true
        // check if there is a neighbor in that direction
        // set the neighbor's wall true as well
        // draw the tile
        // otherwise do all that, but turn the wall off instead

        if (status) {

            if (!hasWall(direction)) {

                wall[direction] = status;

                if (hasNeighbor(direction)) {
                    getNeighbor(direction).setWall(getOppDir(direction), status);
                }

            }

            drawTile();

        }else{
            if (hasWall(direction)) {

                wall[direction] = status;

                if (hasNeighbor(direction)) {
                    getNeighbor(direction).setWall(getOppDir(direction), status);
                }

            }

            drawTile();

        }

    }

    /**
     * Finds neighboring tile (if it exists) in a given direction.
     * @param direction the direction to check in
     * @return a Tile if not null
     */
    public Tile getNeighbor(int direction){

        switch (direction){

            case NORTH:
                return maze.getTile(row - 1, col);

            case EAST:
                return maze.getTile(row, col + 1);

            case SOUTH:
                return maze.getTile(row + 1, col);

            case WEST:
                return maze.getTile(row, col - 1);

            default:
                return null;

        }

    }

    /**
     * Does the wall have a neighbor in a given direction?
     * @param direction where to look
     * @return true if neighbor exists
     */
    public boolean hasNeighbor(int direction){

        return getNeighbor(direction) != null;

    }


}
