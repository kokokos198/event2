import java.io.FileNotFoundException;
import java.io.IOException;

public class Fil2 implements  Runnable{
Fillles fillles;
    int number;

Fil2(Fillles fillles, int number)
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
                fillles.put2();
            } catch (InterruptedException| IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
