package com.jumong;

import java.util.Scanner;

public class Review {
    public static void main(String[] args) {
        Scanner asd = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row = asd.nextInt();
        System.out.print("Enter number of columns: ");
        int col = asd.nextInt();

        int[][] numbers = new int [row][col];

        System.out.println("Enter the elements of your 2D array row by row: ");
        for (int i = 0 ; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.println("Enter value for ("+ i + "," + j +"): ");
                numbers[i][j] = asd.nextInt();
            }
        }

        int[] sumRow = new int [row];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                sumRow[i] += numbers[i][j];
            }
        }

        int[] sumCol = new int [row];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                sumCol[i] += numbers[i][j];
            }
        }

        System.out.println("Sum of rows:");
        for (int sum : sumRow){
            System.out.println(sum);
        }

        System.out.println("Sum of columns:");
        for (int sum : sumCol)
            System.out.println(sum);
    }
}
