package fileActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.locks.ReentrantLock;

public class TimeManager {


    private final ReentrantLock lock;
    private List<Measurement> measurements;
    private int id;

    public TimeManager(int id) {
        this.id = id;
        this.measurements = new ArrayList<Measurement>();
        this.lock = new ReentrantLock();
    }

    public void addMeasurement(Measurement m) {
        this.lock.lock();
        this.measurements.add(m);
        this.id += 1;
        this.lock.unlock();
    }

    public void saveToFile(){

        String toFile  = "";
        for(Measurement measurement : measurements){
            toFile += measurement.getType() + "\n";
        }
        System.out.println(toFile);

        try {
            System.out.println("ok");
            PrintWriter fileMeasurement = new PrintWriter("pomiary.txt");
            System.out.println("ok");
            fileMeasurement.println(toFile);
            fileMeasurement.close();
            System.out.println("ok");
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        }


    }


}




