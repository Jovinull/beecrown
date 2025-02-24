import java.util.Scanner;

public class E1116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        for (int i = 0; i < N; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            
            if (Y == 0) {
                System.out.println("divisao impossivel");
            } else {
                System.out.printf("%.1f%n", (double) X / Y);
            }
        }
        
        scanner.close();
    }
}
