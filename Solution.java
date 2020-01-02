import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    //you can jump to any cloud that is 1 or 2 away, and is not a thundercloud
    /*Strategy: have an if in case we are at 2nd to last cloud. Otherwise, check x+2. If that works, then adjust current position by 2 and add 1 to jumps. Else, add 1 to jumps */
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps =0;
        int curpos = 0;
        //System.out.println(c.length-2);
        while(curpos<c.length-1){
            if(curpos==c.length-2){
                if(c[curpos+1]==0){
                    jumps++;
                    break;
                }
            }
            if(c[curpos+2]==0){
                curpos+=2;
                jumps++;
            }
            else if(c[curpos+1]==0){
                curpos+=1;
                jumps++;
            }
            else{
                System.out.println("Invalid cloud-path. Two consecutive clouds are not cumulus");
            }
        }
        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
