import java.sql.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PathInMatrix {

    int rows, cols;
    char[][] matrix;

    /**
     * initialize the class
     * @param matrix
     */
    public PathInMatrix(char[][] matrix){
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
    }



    public int getItem(int pos){
        int[] co = getCoordinates(pos);
        if (co == null)
            throw new NoSuchElementException("illegal pos parameter!");
        return matrix[co[1]][co[0]];
    }

    public int getItem(int x, int y){
        if (x < 0 || x >= cols || y < 0 || y >= rows)
            throw new NoSuchElementException("illegal pos parameter!");
        return matrix[y][x];
    }

    public int[] getNeighborPos(int x){
        return new int[]{x + 1, x - 1, x - cols, x + cols};
    }


    /**
     * calculate 4 neighbors in 2-d coordinates form
     * @param pos
     * @return
     */
    public static int[][] getNeighborPos(int[] pos){
        int x = pos[0], y = pos[1];
        int[][] neighbors = new int[4][2];
        neighbors[0] = new int[]{x - 1, y};
        neighbors[1] = new int[]{x + 1, y};
        neighbors[2] = new int[]{x, y + 1};
        neighbors[3] = new int[]{x, y - 1};
        return neighbors;
    }

    public int[] getCoordinates(int pos){
        if (pos < 0 || pos >= rows * cols)
            return null;
        return new int[]{pos % rows, pos / rows};
    }

    public boolean isValidPos(int pos){
        return pos >= 0 && pos < rows * cols;
    }

    public boolean isValidPos(int[] pos){
        return pos[0] > -1 && pos[0] < cols && pos[1] > -1 && pos[1] < rows;
    }

    public int[] getPath(int initPos, String pattern){
        int[] posArray = new int[pattern.length()];
        boolean[] route = new boolean[rows * cols];
        if (getPath(initPos, 0, pattern, posArray, route))
            return posArray;
        return null;
    }

    private boolean getPath(int pos, int charPos, String pat, int[] path, boolean[] route){
        if (charPos >= pat.length())
            return true;
        if (getItem(pos) != pat.charAt(charPos))
            return false;

        //when taking this node into consideration, mark it as taken
        route[pos] = true;
        int[] neighbors = getNeighborPos(pos);
        for (int i = 0; i < 4; i ++){
            int n = neighbors[i];
            if (isValidPos(n) && !route[n] && getPath(n, charPos + 1, pat, path, route)){
                path[charPos] = pos;
                return true;
            }
        }
        //when this node is not compatible to this string yet, erase its mark
        route[pos] = false;
        return false;
    }


    public int robotMoveRange(int r){
        boolean[][] marked = new boolean[rows][cols];
        robotMoveRange(r, new int[]{0, 0}, marked);
        int total = 0;
        for (int i = 0; i < rows; i ++)
            for (int j = 0; j < cols; j ++)
                if (marked[i][j])
                    total++;
        return total;
    }

    private void robotMoveRange(int r, int[] pos, boolean[][] marked){
        int x = pos[0], y = pos[1];
        if (marked[y][x] || DigitSum.getArrayDigitSum(pos) > r)
            return;
        marked[y][x] = true;
        int[][] neighbors = getNeighborPos(pos);
        for (int i = 0; i < 4; i ++)
            if (isValidPos(neighbors[i]))
                robotMoveRange(r, neighbors[i], marked);
    }

    public int robotMoveRangeSimple(int r){
        int total = rows * cols, s = 0;
        for (int i = 0; i < total; i ++){
            int[] coordinates = getCoordinates(i);
            if (DigitSum.getArrayDigitSum(coordinates) <= r)
                s ++;
        }
        return s;
    }

}
