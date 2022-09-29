import acm.graphics.GCompound;
import acm.util.RandomGenerator;

public class Maze extends GCompound {

    private Tile[][] floor; // a grid of tiles
    private int rows; // the number of rows in the maze
    private int cols; // the number of columns in the maze
    private MazeSolver parent; // the maze solver that this belongs to (the canvas)

    /**
     * Construct a rectangular maze with the specified number of rows and columns.
     * The paths through the maze are randomly generated. It is not guaranteed that
     * any two arbitrary tiles will have a valid path connecting them.
     * @param rows the number of rows in the maze
     * @param cols the number of columns in the maze
     * @param parent the canvas that this belongs to
     */
    public Maze(int rows, int cols, MazeSolver parent){
        this.rows = rows;
        this.cols = cols;
        this.parent = parent;

        floor = new Tile[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                floor[i][j] = new Tile(this, i, j);
                add(floor[i][j],
                        j * floor[i][j].getWidth(),
                        i * floor[i][j].getHeight());
            }
        }

        // make a horizontal wall on the north side
        makeHorizontalWall(0, cols-1, Tile.NORTH, 0);
        // make a horizontal wall on the south side
        makeHorizontalWall(0, cols-1, Tile.SOUTH, rows-1);
        // make a vertical wall on the east side
        makeVerticalWall(0, rows-1, Tile.EAST, cols-1);
        // make a vertical wall on the west side
        makeVerticalWall(0, rows-1, Tile.WEST, 0);

        // recursively divide the maze until it is ready to solve
        divideMaze(0, 0, rows-1, cols-1);
    }



    public Tile getTile(int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return null;
        }

        return floor[row][col];
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    private void makeVerticalWall(int startRow, int endRow, int direction, int col){
        // loop across a given row range
        for (int i = startRow; i <= endRow; i++) {
            // setWall() on every tile in that range in a given direction
            getTile(i, col).setWall(direction, true);
        }

    }

    private void makeHorizontalWall(int startCol, int endCol, int direction, int row){
        // loop across a given column range
        for (int i = startCol; i <= endCol; i++) {
            getTile(row, i).setWall(direction, true);
        }
        // setWall() on every tile in that range in a given direction
    }

    private void makeRandomVOpening(int startRow, int endRow, int direction, int col){
        // make sure the range is valid
        if(endRow >= startRow) {
            // get a random tile, and turn its wall in the given direction off
            int randomRow = RandomGenerator.getInstance().nextInt(startRow, endRow-1);
            getTile(randomRow, col).setWall(direction, false);
        }
    }

    private void makeRandomHOpening(int startCol, int endCol, int direction, int row){
        // make sure the range is valid
        if(endCol >= startCol) {
            // get a random tile, and turn its wall in the given direction off
            int randomCol = RandomGenerator.getInstance().nextInt(startCol, endCol-1);
            getTile(row, randomCol).setWall(direction, false);
        }
    }

    /**
     * Constructs the maze by recursively dividing an area into four quadrants.
     *
     * On each division step, the vertical and horizontal wall that defines the quadrants
     * will be drawn, and a random opening is made in each of the four quadrants.
     *
     * Next, the method will call itself (recur) on each quadrant.
     *
     * The method will terminate when the width and
     * height of the area to divide are equal.
     *
     * The parameters describe a starting tile coordinate and an ending tile coordinate.
     * @param r0 starting row
     * @param c0 starting column
     * @param r1 ending row
     * @param c1 ending column
     */
    private void divideMaze(int r0, int c0, int r1, int c1){
        // base case
        if(r0 == r1 && c0 == c1){
            return;
        }

        // get a random row within the range
        int randRow = Math.max(r0, RandomGenerator.getInstance().nextInt(r0, r1));
        // get a random col within the range
        int randCol = Math.max(c0, RandomGenerator.getInstance().nextInt(c0, c1));


        // if the base column range is valid
        if(c0 <= c1){
            // make a horizontal wall along the random row, on the south side
            makeHorizontalWall(c0, c1, Tile.SOUTH, randRow);
            // if the random row is less than the total rows
            if(randRow < rows-1){
                // make random horizontal openings along the random row
                makeRandomHOpening(c0, randCol, Tile.SOUTH, randRow);
                makeRandomHOpening(randCol, c1, Tile.SOUTH, randRow);
            }

        }

        // ensure that the row range is valid
        if(r0 <= r1){
            // make the dividing wall
            makeVerticalWall(r0, r1, Tile.EAST, randCol);

            if(randCol < cols-1){
                makeRandomVOpening(r0, randRow, Tile.EAST, randCol);
                makeRandomVOpening(randRow, r1, Tile.EAST, randCol);
            }
        }

        // check top half validity
        if(randRow - r0 > 1){

            // check top left validity
            if(randCol - c0 > 1){
                divideMaze(r0, c0, randRow, randCol);
            }

            // check top right validity
            if (c1 - randCol > 1) {
                divideMaze(r0, randCol, randRow, c1);
            }
        }

        // check bottom half validity
        if (r1 - randRow > 1) {

            // check bottom right quarter validity
            if (c1 - randCol > 1) {
                divideMaze(randRow, randCol, r1, c1);
            }

            // check bottom left quarter validity
            if (randCol - c0 > 1) {
                divideMaze(randRow, c0, r1, randCol);
            }
        }

    }

}