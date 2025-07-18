import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] custom_input_1 = br.readLine().split(" ");
            int N = Integer.parseInt(custom_input_1[0]);
            int K = Integer.parseInt(custom_input_1[1]);
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            int[] out_ = solve(N, K, A);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print(" " + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();
    }
    
    static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }

    static int[] solve(int N, int K, int[] A){
        // Write your code here
        
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int hdA = hammingDistance(a, K);
            int hdB = hammingDistance(b, K);
            if (hdA != hdB) {
                return Integer.compare(hdA, hdB);
            } 
            else {
                return Integer.compare(a, b);
            }
        });

        // Convert back to int[]
        for (int i = 0; i < N; i++) {
            A[i] = arr[i];
        }
        return A;    
    }
}