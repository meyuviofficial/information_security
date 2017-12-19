
import java.util.Scanner;

public class hillcipher {
    static int random[][] = new int [3] [3];
    static int result[][] = new int [3] [3];

    public static void main(String [] args) {
        int k1[][] = { { 3, 10, 20 }, { 20, 9, 17 }, { 9, 4, 17 } };
        int p[] = new int [300];
        int c[] = new int [300];
        int i, j, k;
        Scanner read = new Scanner(System.in);
        String plain_text = "dhrtiinfo";
        plain_text = plain_text.toUpperCase();
        System.out.println("Plain text:" + plain_text);
        for ( i = 0; i < plain_text.length(); i++ ) {
            int c1 = plain_text.charAt(i);
            // System.out.println(c1);
            p[i] = (c1) - 65;
            // System.out.println(p[i]);
        }
        i = 0;
        for ( j = 0; j < 3; j++ ) {
            System.out.println();
            for ( k = 0; k < 3; k++ ) {
                random[j][k] = p[i];
                // System.out.print(random[j][k] + " ");
                i++;
            }
        }
        System.out.println("Encrypted Text : ");
        for ( i = 0; i < 3; i++ )
            for ( j = 0; j < 3; j++ ) {
                for ( k = 0; k < 3; k++ ) {
                    result[i][j] += random[i][k] * k1[k][j];
                }
                System.out.print((char) ((result[i][j] % 26) + 65));
            }
    }
}
