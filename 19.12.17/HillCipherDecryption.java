public class HillCipherDecryption {
    static int random[][]     = new int [3] [3];
    static int plain_text[][] = new int [3] [3];
    static int cofactor[][]   = new int [3] [3];
    static int minor[][]      = new int [3] [3];
    static int key[][]        = new int [3] [3];
    static int key_text[][]   = new int [3] [3];
    static int result[][]     = new int [3] [3];
    static int transpose[][]  = new int [3] [3];

    public static void main(String [] args) {
        int p[] = new int [300];
        int kt[] = new int [300];
        int c[] = new int [300];
        int d[] = new int [300];
        int random[][] = { { 3, 10, 20 }, { 20, 9, 17 }, { 9, 4, 17 } };
        int i = 0;

        String plain = "QFADICFXL";
        plain = plain.toUpperCase();
        System.out.println("Encrypted text:" + plain);
        // Scanner read = new Scanner(System.in);
        // plain_text = read.next();

        for ( i = 0; i < plain.length(); i++ ) {
            int c1 = plain.charAt(i);
            p[i] = (c1) - 65;
            // System.out.print(p[i] + " ");
        }

        int k = 0;
        for ( int j = 0; j < 3; j++ ) {
            for ( i = 0; i < 3; i++ ) {
                transpose[i][j] = random[i][j];
                // System.out.print(transpose[i][j] + " ");
                plain_text[j][i] = p[k];
                k++;
            }
            // System.out.println();
        }

        int determinant = 0;
        for ( i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                cofactor[i][j] = transpose[(i + 1) % 3][(j + 1) % 3] * transpose[(i + 2) % 3][(j + 2) % 3] - transpose[(i + 1) % 3][(j + 2) % 3]
                        * transpose[(i + 2) % 3][(j + 1) % 3];
                minor[i][j] = (i + j) % 2 == 0 ? cofactor[i][j] : (-cofactor[i][j]);
                if (i == 0)
                    determinant += random[0][j] * (cofactor[i][j]);
            }
        }

        /*
         * for ( int j = 0; j < 3; j++ ) {
         * for ( i = 0; i < 3; i++ ) {
         * System.out.print(minor[i][j] + " ");
         * }
         * System.out.println();
         * }
         *
         * for ( i = 0; i < 3; i++ ) {
         * for ( int j = 0; j < 3; j++ ) {
         * System.out.print(cofactor[i][j] + " ");
         * }
         * System.out.println();
         * }
         *
         * System.out.println("\ndeterminant:" + (Math.floorMod(determinant, 26) * 3));
         * System.out.println("\nkey value");
         */
        for ( int j = 0; j < 3; j++ ) {
            for ( i = 0; i < 3; i++ ) {
                key[i][j] = 9 * cofactor[i][j];
                key[i][j] = Math.floorMod(key[i][j], 26);
                key_text[j][i] = key[i][j];
            }
            System.out.println();
        }
        /*
         * System.out.println("\nplain text value");
         * for ( i = 0; i < 3; i++ ) {
         * for ( int j = 0; j < 3; j++ ) {
         * System.out.print(plain_text[i][j] + " ");
         * }
         * System.out.println();
         * }
         */
        System.out.println("\nDecrypted Text : ");
        for ( i = 0; i < 3; i++ )
            for ( int j = 0; j < 3; j++ ) {
                for ( k = 0; k < 3; k++ ) {
                    result[i][j] += plain_text[i][k] * key_text[k][j];
                }
                System.out.print((char) (Math.floorMod(result[i][j], 26) + 65));
            }

    }
}
