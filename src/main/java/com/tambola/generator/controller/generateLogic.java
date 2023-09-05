package com.tambola.generator.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class generateLogic {
    public static int[][] getCard(){
        int[][] card = new int[3][9];
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 9; i++) {
            numbers.clear();
            for (int j = 1; j <= 10; j++)
                numbers.add(i * 10 + j);
            Collections.shuffle(numbers);
    
            // Select random numbers for each column
            if (i == 0 || i == 8) {
                for (int j = 0; j < 3; j++)
                    card[j][i] = numbers.get(j);
            } else {
                int count = rand.nextInt(2) + 2;
                for (int j = 0; j < count; j++)
                    card[j][i] = numbers.get(j);
            }
        }
    
        // Rearrange the rows
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> column = new ArrayList<Integer>();
            for (int j = 0; j < 3; j++)
                if (card[j][i] != 0)
                    column.add(card[j][i]);
            Collections.shuffle(column);
            for (int j = 0; j < column.size(); j++)
                card[j][i] = column.get(j);
            for (int j = column.size(); j < 3; j++)
                card[j][i] = 0;
        }
    
        // Ensure that each row has at most 5 elements
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 9; j++)
                if (card[i][j] != 0)
                    count++;
            while (count > 5) {
                int index = rand.nextInt(9);
                if (card[i][index] != 0) {
                    card[i][index] = 0;
                    count--;
                }
            }
        }
    
        return card;
    }
}
