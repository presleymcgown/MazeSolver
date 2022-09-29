import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.ArrayList;
import svu.csc213.Dialog;

public class MazeSolver extends GraphicsProgram {

    private Maze maze;
    private int pause;
    private Tile startTile;
    private Tile goalTile;
    private ArrayList<Tile> visited = new ArrayList<>();

    @Override
    public void init(){

      pause = Dialog.getInteger(this, "Enter the delay between steps in milliseconds.");
      maze = new Maze(22, 35, this);
      add(maze, 10 , 10);

      //get a starting tile from the user
      int r0 = Dialog.getInteger(tjos, "Enter the Row for the starting tile." + rowRange);

      //get an ending tile from the user

     //set the startTile based on the info you just got

     //set the fill color or the starting tile to something

     //set the goalTile based on the info you just got

     //set the fill color or the starting tile to something

     //call solve




    }

    @Override
    public void run(){

        String rowRange = String.format("(%d-%d):", 0, maze.getRows() - 1);
        String colRange = String.format("(%d-%d):", 0, maze.getCols() - 1);

    }

    // visited.add(), visited.contains()
    private void solve(Tile startTile, Tile goalTile, ArrayList<Tile> visited){

        //handle base case

         //general cases:
            //add the tile you are on to the list
            //look north. If there is a possible path:
                // set the fill color of your current tile to something
                //move to that north tile
                // se fill color to white

    }

    public static void main(String[] args) {

     new MazeSolver().start();

    }

}
