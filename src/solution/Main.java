package solution;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	matrixMultiplication();
    }

    private static void matrixMultiplication() throws IOException {
        //define veriables
        BufferedReader reader = new BufferedReader(new FileReader("INPUT.TXT"));
        String s;
        s = reader.readLine();
        String [] sar = s.split(" ");
        int m = Integer.parseInt(sar[0]);
        int n = Integer.parseInt(sar[1]);
        s = reader.readLine();
        sar = s.split(" ");
        int line = Integer.parseInt(sar[0])-1;
        int column = Integer.parseInt(sar[1])-1;
        s = reader.readLine();
        int p = Integer.parseInt(s);
        int[][] c;
        int[][][] allMatrix = new int[m][n][n];

        //init start matrix
            for (int i = 0; i < m ; i++) {
                reader.readLine();
                for (int j = 0; j < n; j++) {
                    s = reader.readLine();
                    sar = s.split(" ");
                    for (int k = 0; k < n; k++) {
                         allMatrix[i][j][k] = Integer.parseInt(sar[k]);

                    }
                }

            }
            reader.close();

        c = allMatrix[0];
        for (int i = 1; i <m; i++) {
            c = mult(c,allMatrix[i],p);
        }

        FileWriter writer = new FileWriter("OUTPUT.TXT");
        writer.write(String.valueOf(c[line][column]));
        writer.close();
    }

    private static int[][] mult(int[][] a, int[][] b, int p){
        int n = a.length;
        int result;
        int[][] c = new int[n][n];
        int[][] bt = new int[n][n];

        //multiply matrix
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                result = 0;
                for (int k = 0; k <n; k++) {
                    result+= a[i][k] * b[k][j];
                }
                if(result>=p){
                    result %=p;
                }
                c[i][j] =result;
            }
        }
        return c;
    }
}
