import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fillles {
    private static  int n;
    private static boolean read = false;
    private  File file;
    private int number;

    Fillles(File file, int number)
    {
        this.file = file;
        this.number = number;
    }

    public synchronized int ret() {
        return Fillles.n;
    }

    public synchronized boolean isRead()
    {
        return Fillles.read;
    }

    public synchronized void readfile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("out.txt"));
        Fillles.n = Integer.parseInt(scanner.next());
        scanner.close();
    }


    public synchronized void put1() throws InterruptedException, IOException {

        while (isRead()) {
            wait();
        }
        if(ret() >= number)
        {
            return;
        }

        System.out.println(Thread.currentThread().getName() + "  " + Fillles.n);
        readfile();
        Fillles.n++;
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(Integer.toString(ret()));
        fileWriter.close();

        System.out.println(Thread.currentThread().getName() + "  " + ret());
        Fillles.read = true;
        notify();



    }

    public  synchronized void put2() throws InterruptedException, IOException {


        while (!isRead()) {
            wait();
        }
        if(ret() >= number)
        {
            return;
        }

        System.out.println(Thread.currentThread().getName() + "  " + Fillles.n);
        readfile();
        Fillles.n++;
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(Integer.toString(ret()));
        fileWriter.close();

        System.out.println(Thread.currentThread().getName() + "  " + ret());
        Fillles.read = false;
        notify();

    }

}

