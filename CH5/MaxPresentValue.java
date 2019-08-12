public class MaxPresentValue {

    private int i = 0;

    public int recursiveCal(int[][] matrix){
        return recursiveCal(matrix, 0, 0);
    }

    public int recursiveCalv2(int[][] matrix){
        return recursiveCal(matrix, 0, 0, new int[matrix.length][matrix[0].length]);
    }

    private int recursiveCal(int[][] matrix, int i, int j){
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;
        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            return matrix[i][j];
        int down = recursiveCal(matrix, i + 1, j);
        int right = recursiveCal(matrix, i, j + 1);
        this.i ++;
        return matrix[i][j] + Math.max(down, right);
    }


    private int recursiveCal(int[][] matrix, int i, int j, int[][] values){
        if (i >= matrix.length || j >= matrix[0].length)
            return 0;
        if (values[i][j] != 0)      return values[i][j];

        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            values[i][j] = matrix[i][j];
        else {
            int down = recursiveCal(matrix, i + 1, j);
            int right = recursiveCal(matrix, i, j + 1);
            values[i][j] = matrix[i][j] + Math.max(down, right);
        }
        this.i ++;
        return values[i][j];
    }

    public int iterativeCal(int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        int[][] values = new int[row][col];
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                int t = 0;
                if (i > 0)  t = values[i - 1][j];
                if (j > 0)  t = Math.max(t, values[i][j - 1]);
                values[i][j] = t + matrix[i][j];
            }
        }
        return values[row - 1][col - 1];
    }



    /*
    private static void recursiveCal(int[][] matrix, int i, int j, int value, int[][] values){
        if (i >= matrix.length || j >= matrix[0].length)
            return;
        if (value + matrix[i][j] > values[i][j])
            values[i][j] = value + matrix[i][j];
        if (i == matrix.length - 1 && j == matrix[0].length - 1)
            return;

    }*/

    public static void main(String[] args){
        MaxPresentValue m1 = new MaxPresentValue();
        int[][] A = new int[4][4];
        A[0] = new int[]{1, 10, 3, 8};
        A[1] = new int[]{12, 2, 9, 6};
        A[2] = new int[]{5, 7, 4, 11};
        A[3] = new int[]{3, 7, 16, 5};
        System.out.println(m1.recursiveCal(A));
        System.out.println("recursive call times: " + m1.i);


        m1 = new MaxPresentValue();
        System.out.println(m1.recursiveCalv2(A));
        System.out.println("recursive call times: " + m1.i);

        System.out.println(m1.iterativeCal(A));
    }

}
