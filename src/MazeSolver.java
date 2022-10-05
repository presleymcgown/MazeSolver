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

    }

    @Override
    public void run(){

        String rowRange = String.format("(%d-%d):", 0, maze.getRows() - 1);
        String colRange = String.format("(%d-%d):", 0, maze.getCols() - 1);

        //get a starting tile from the user
        int r0 = Dialog.getInteger(this, "Enter the Row for the starting tile." + rowRange);
        int c0 = Dialog.getInteger(this, "Enter the column for the starting tile." + colRange);

        //get an ending tile from the user
        int r1 = Dialog.getInteger(this, "Enter the Row for the goal tile." + rowRange);
        int c1 = Dialog.getInteger(this, "Enter the column for the goal tile." + colRange);

        //set the startTile based on the info you just got
        startTile = maze.getTile(r0, c0);


        //set the fill color or the starting tile to something
        startTile.fillColor(new Color(121, 164, 117));


        //set the goalTile based on the info you just got
        goalTile = maze.getTile(r1, c1);

        //set the fill color or the starting tile to something
        goalTile.fillColor(new Color(169, 83, 83));


        //call solve
        solve(startTile, goalTile, visited);

    }

    // visited.add(), visited.contains()
    private void solve(Tile startTile, Tile goalTile, ArrayList<Tile> visited){

        //handle base case
        if(visited.contains(goalTile)){
            Dialog.showMessage("The maze was solved!");
            System.exit(0);
        }

         //general cases:

            //add the tile you are on to the list
            //look north. If there is a possible path:
                // set the fill color of your current tile to something
                //move to that north tile (call solve and pass in tile)
                // se fill color to white
                //pause

        if(!visited.contains(startTile)) {

            visited.add(startTile);

                if (!startTile.hasWall(Tile.NORTH)) {

                    startTile.fillColor(new Color(140, 157, 197, 171));
                    solve(startTile.getNeighbor(Tile.NORTH), goalTile, visited);
                    startTile.fillColor(Color.WHITE);
                    pause(pause);


                }

                if (!startTile.hasWall(Tile.EAST)) {

                    startTile.fillColor(new Color(140, 157, 197, 171));
                    solve(startTile.getNeighbor(Tile.EAST), goalTile, visited);
                    startTile.fillColor(Color.WHITE);
                    pause(pause);


                }

                if (!startTile.hasWall(Tile.SOUTH)) {

                    startTile.fillColor(new Color(140, 157, 197, 171));
                    solve(startTile.getNeighbor(Tile.SOUTH), goalTile, visited);
                    startTile.fillColor(Color.WHITE);
                    pause(pause);


                }

                if (!startTile.hasWall(Tile.WEST)) {

                    startTile.fillColor(new Color(140, 157, 197, 171));
                    solve(startTile.getNeighbor(Tile.WEST), goalTile, visited);
                    startTile.fillColor(Color.WHITE);
                    pause(pause);


                }


        }



    }

    public static void main(String[] args) {

     new MazeSolver().start();

    }

}
