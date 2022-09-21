import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GRect;

import java.awt.*;

public class Tile extends GCompound {

    public static  int NORTH = 0;
    public static int EAST = 1;
    public static int SOUTH = 2;
    public static int WEST = 3;

    public static double TILEW = 50;
    public static double TILEH = 50;

    private boolean[] wall;
    private Maze maze;
    private int row;
    private int col;
    private GRect body;
    private GLine NWall;
    private GLine EWall;
    private GLine SWall;
    private GLine WWall;

    public void drawTile(){

    }

    public int getOppositeDirection(int direction){

    }

    public boolean hasWall(int direction){

    }

    public void fillColor(Color color){

    }

    public void setWall(int direction, boolean b){

    }

    public Tile getNeighbor(int direction){

    }

    public boolean hasNeighbor(int direction){
        
    }



}
