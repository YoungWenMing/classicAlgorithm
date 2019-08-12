public class RobotMatrix {

    public static int countGrids(int k, int m, int n){
        if (k < 0)      return 0;
        boolean[][] visited = new boolean[m][n];
        int counts = countGrids(k, m, n, 0, 0, visited);
        return counts;
    }

    private static int countGrids(int k, int m, int n, int x, int y, boolean[][] visited){
        if (!isValid(k, m, n, x, y, visited))   return 0;
        visited[x][y] = true;
        return 1 + countGrids(k, m, n, x + 1, y, visited)
                + countGrids(k, m, n, x - 1, y, visited)
                + countGrids(k, m, n, x , y+ 1, visited)
                + countGrids(k, m, n, x , y- 1, visited);

    }

    private static boolean isValid(int k, int m, int n, int x, int y, boolean[][] visited){
        if (x <0 || x >= m || y < 0 || y>= n)   return false;
        if (visited[x][y])      return false;
        if (digitSum(x) + digitSum(y) > k)      return false;
        return true;
    }

    private static int digitSum(int x){
        int result = 0;
        while (x > 0){
            result += (x % 10);
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(countGrids(3, 3, 3));
    }
}
