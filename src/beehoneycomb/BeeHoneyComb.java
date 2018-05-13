/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beehoneycomb;

import java.util.Scanner;

/**
 *
 * @author Benjamin Chinwe
 */
public class BeeHoneyComb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //declare the Scanner
        Scanner numbers = new Scanner(System.in);

        //information for users
        System.out.println("Enter test case integer n : 1<=n>=14. Enter '-1' to quit.");

        // While loop
        while (numbers.hasNextInt()) {
            // accept scanner inputs
            int caseNum = numbers.nextInt();

            //If statement to terminate the program
            if (caseNum == -1) {
                System.exit(0); // Ends program
                //System.out.println("Program ends! Thanks from Benjamin Chinwe 2018");

                //If else to check if the case integer is within the range
            } else if ((caseNum >= 1) && (caseNum <= 14)) {

                int[] hexNum = new int[caseNum]; // declare array of hexagon

                // for statement to assisgn hexagon in the honeycumb
                for (int i = 0; i < caseNum; i++) {
                    hexNum[i] = numbers.nextInt();

                }

                int totalHex = totalHex(hexNum); // method to iterate over the honeycumb

                // muiltiple array declaration
                int[][][] countsHex = new int[2 * totalHex + 1][2 * totalHex + 1][totalHex + 1];

                countsHex[totalHex][totalHex][0] = 1;

                // step through the honeycumb maze
                for (int i = 1; i < totalHex + 1; i++) {
                    for (int j = 0; j < 2 * totalHex; j++) {
                        for (int k = 0; k < 2 * totalHex; k++) {

                            if (k > 0) {
                                countsHex[j][k][i] += countsHex[j][k - 1][i - 1];
                            }

                            if (j > 0) {
                                countsHex[j][k][i] += countsHex[j - 1][k][i - 1];
                            }

                            if (j > 0 && k > 0) {
                                countsHex[j][k][i] += countsHex[j - 1][k - 1][i - 1];
                            }

                            if (j < 2 * totalHex + 1) {
                                countsHex[j][k][i] += countsHex[j + 1][k][i - 1];
                            }
                            if (k < 2 * totalHex + 1) {
                                countsHex[j][k][i] += countsHex[j][k + 1][i - 1];
                            }
                            if (j < 2 * totalHex + 1 && k < 2 * totalHex + 1) {
                                countsHex[j][k][i] += countsHex[j + 1][k + 1][i - 1];
                            }

                        }

                    }
                }
                for (int j : hexNum) {
                    System.out.println("Result : " + countsHex[totalHex][totalHex][j]);
                }
                //numbers.close();
            } else { // Else statement if the input value is out of range 0<=h=>365 and 0<=v=>687 
                System.out.println("Test case integer n must be : 1<=n>=14. Enter '-1' to quit.");
            }

        }
    }

    private static int totalHex(int[] hexNum) {

        int totalHex = 0;

        for (int i = 0; i < hexNum.length; i++) {
            if (hexNum[i] > totalHex) {
                totalHex = hexNum[i];
            }
        }

        return totalHex;

    }

}
