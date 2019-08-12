import java.util.Scanner;

public class P48 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        int l = 1, start = 1,
                max[] = new int[s.length()], pos[] = new int[26];
        int p;
        max[0] = 1;
        pos[s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < s.length(); i ++){
            p = s.charAt(i) - 'a';
            // no duplicate
            if (pos[p] == 0 || pos[p] < start){
                pos[p] = i + 1;
                l ++;
            }
            else{
                pos[p] = i + 1;
                start = i + 1;
                l = 1;
            }
            if (l > max[i - 1])
                max[i] = l;
            else
                max[i] = max[i-1];
        }
        System.out.println(max[s.length() - 1]);
    }


}
