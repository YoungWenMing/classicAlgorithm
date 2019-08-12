public class PrintMatrixClockwise {

    static int[][] direct = new int[4][2];
    static {
        direct[0] = new int[]{1, 0};
        direct[1] = new int[]{0, 1};
        direct[2] = new int[]{-1, 0};
        direct[3] = new int[]{0, -1};
    }

    private static int[] coords(int[] origin, int[] inc){
        return new int[]{origin[0] + inc[0], origin[1] + inc[1]};
    }

    public static void print(int[][] matrix){
        int length = matrix[0].length, width = matrix.length, directVectorNum = 0;
        int[] direction = direct[0], point = new int[]{0, 0};
        boolean[][] marked = new boolean[width][length];
        while (true){
            marked[point[1]][point[0]] =true;
            System.out.print(matrix[point[1]][point[0]]+ " ");

            int[] tempP = coords(point, direction);
            if (tempP[0] < 0 || tempP[0] >= length ||
                tempP[1] < 0 || tempP[1] >= width ||
                marked[tempP[1]][tempP[0]]){
                directVectorNum = (directVectorNum + 1) % 4;
                direction = direct[directVectorNum];
                point = coords(point, direction);

            }else
                point = tempP;
            if (marked[point[1]][point[0]])
                break;
        }

    }

    public static void main(String[] args){
        int[][] matrix = new int[4][3];
        matrix[0] = new int[]{0, 1, 2 };
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{8, 9, 10};
        matrix[3] = new int[]{12, 13, 14};

        print(matrix);

        printClockWise(matrix);

        int[][] m = new int[1][1];
        m[0] = new int[]{0};
        printClockWise(m);
    }

    public static void printClockWise(int[][] matrix){
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return;

        int start = 0, rows = matrix.length, columns = matrix[0].length;
        while (start * 2 < rows && start * 2 < columns){
            printClockWise(matrix, rows - 2 * start, columns - 2 * start, start);
            start ++;
        }
    }

    private static void printClockWise(int[][] matrix, int rows, int columns, int start){
        int xEnd = start + columns - 1, yEnd = start + rows - 1;

        // from left side to right side
        for (int i = start; i <= xEnd; i ++)
            System.out.print(matrix[start][i] + " ");
        //System.out.print("\n");

        // from top to bottom
        if (rows > 1){
            for (int i = start + 1; i <= yEnd; i ++)
                System.out.print(matrix[i][xEnd] + " ");
        }

        // from right-bottom to left-bottom
        if (rows > 1 && columns > 1){
            for (int i = xEnd - 1; i >= start; i --)
                System.out.print(matrix[yEnd][i] + " ");
        }

        // from left-bottom to left-top
        if (rows > 2 && columns > 1){
            for (int i = yEnd - 1; i > start; i --)
                System.out.print(matrix[i][start] + " ");
        }


    }

}
