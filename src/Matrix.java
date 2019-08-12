public class Matrix {

    private int[][] data;
    private int rows, cols;

    public Matrix(int d1, int d2){
        data = new int[d1][d2];
        this.rows = d1;
        this.cols = d2;
    }


    public void fillMatrix(int pos, int item){

    }

    public void fillMatrix(int row, int col, int item){

    }

    public int getItem(int pos){
        return 0;
    }

    public int getItem(int row, int col){
        return 0;
    }

    public int[] transCoordinates(int pos){
        if (pos < 0 || pos >= rows * cols)
            return null;
        int y = pos / rows, x = pos % rows;
        return new int[]{y, x};
    }
}
