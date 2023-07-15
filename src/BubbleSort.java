import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler handler = null;
        try {
            handler =  new FileHandler("log.txt");
        } catch (Exception e){
            e.printStackTrace();
        }

        logger.addHandler(handler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        handler.setFormatter(simpleFormatter);

        int temp = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length-1; j++) {
                if (mas[j] > mas[j + 1]) {
                    temp = mas[j + 1];
                    mas[j + 1] = mas[j];
                    mas[j] = temp;
                }
            }
                logger.log(Level.INFO, Arrays.toString(mas));

        }

    }

}
