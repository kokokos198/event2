import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {

        public static void main (String[]args) throws IOException, InterruptedException {

            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();

            if(number < 0)
            {
                System.out.println("Invalid number");
                return;
            }else if(number %2 != 0)
            {
                System.out.println("число не кратно двум");
                return;
            }

            File file = new File("out.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("0");
        fileWriter.close();
        Fillles fillles = new Fillles(file, number);

        Thread thread1 = new Thread(new Fil1(fillles, number));
        Thread thread2 = new Thread(new Fil2(fillles, number));

        thread1.start();
        thread2.start();
    }

}

