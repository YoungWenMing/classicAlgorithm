import java.util.Scanner;
import java.util.Stack;

public class P53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), nums[] = new int[N],
                start, end, mid, left = 0, right = -1;
        int target = scanner.nextInt();
        for (int i = 0; i < N; i ++)
            nums[i] = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(N - 1);

        while (!stack.empty()){
            end = stack.pop();
            start = stack.pop();
            if (end < start)    continue;
            mid = (end + start) / 2;
            if (nums[mid] > target){
                stack.push(start);
                stack.push(mid - 1);
            }
            else if (nums[mid] < target){
                stack.push(mid + 1);
                stack.push(end);
            }else {
                if (mid == N - 1 || nums[mid + 1] > target)
                    right = mid;
                else {
                    stack.push(mid + 1);
                    stack.push(end);
                }
                if (mid == 0 || nums[mid - 1] < target)
                    left = mid;
                else{
                    stack.push(start);
                    stack.push(mid - 1);
                }
            }
        }
        System.out.println(right - left + 1);
    }

}
