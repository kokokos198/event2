import java.io.FileNotFoundException;
import java.io.IOException;

public class Fil1 implements  Runnable{
    Fillles fillles;
int number;
    Fil1(Fillles fillles, int number)
    {
        this.fillles = fillles;
        this.number = number;
    }


    @Override
    public void run()
    {
        while (fillles.ret() < number)
        {
            try {
                fillles.put1();
            } catch (InterruptedException| IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
