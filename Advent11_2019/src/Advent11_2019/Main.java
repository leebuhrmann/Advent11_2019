package Advent11_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Long, Long> intCode = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        //This takes the data within a .txt file and places it within a String named initialData
        Scanner s = new Scanner(new File("src\\data.txt"));
        String initialData = s.next();
        s.close();

        //This splits the single string into multiple strings and places them within an array
        String[] initialDataSplit = initialData.split(",");

        //Turns the strings into Longs and places them within the Map intCode.
        long z = 0;
        for (String data : initialDataSplit) {
            Long i = Long.parseLong(data);
            intCode.put(z, i);
            z++;
        }

        //instantiate the IntComputer and PaintBot
        IntComputer computer = new IntComputer(intCode);
        PaintBot bot = new PaintBot();

        //has paintBot paint the hull
        boolean cont = true;
        while (cont) {
            Long inputA = bot.getWhatColor();
                System.out.println("Enter IntComputer with input: " + inputA);
            Long inputB = computer.compute(inputA);
            bot.paint(inputB);
                System.out.println("Entering IntComputer with input:" + inputB);
            inputA = computer.compute(inputB);
            bot.setDirection(inputA);
            bot.moveBot();
        }

        //I *THINK* this was to display the final design of the hull after it was painted.
        for (int y = 0; y < 200; y++) {
            System.out.println();
            for (int x = 0; x < 200; x++) {
                System.out.print(bot.getMapChar(x,y) + " ");
            }
        }

        int x = 1;
        int y = 2;
        int test = x + y;
        System.out.println(test);
    }
}
