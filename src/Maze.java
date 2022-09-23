import acm.graphics.GCompound;
import acm.util.RandomGenerator;

public class Maze extends GCompound {

    private Tile[][] floor;
    private int rows;
    private int cols;
    private MazeSolver parent;


    /**
     * Construct a rectangular maze with specified number of rows and columns.
     * The paths through the maze are randomly generated. It is not garanteed that
     * any two arbitrary tiles will have a valid path connecting them.
     * @param rows number of rows in the maze
     * @param cols number of columns in the maze
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
        // make a horizontal wall on the north side
        // make a vertical wall on the east side
        // make a vertical wall on the west side

        // recursively divide the maze until it is ready to solve

    }

    public Tile getTile(int row, int col){

        return null;

    }

}
