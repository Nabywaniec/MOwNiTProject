package fileActiveObject;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TimeManager {


    private List<Measurement> measurements;
    private int id;

    public TimeManager(int id) {
        this.id = id;
        this.measurements = new ArrayList<Measurement>();
    }

    public void addMeasurement(Measurement m) {
        this.measurements.add(m);
        this.id += 1;
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
            fileMeasurement.println("");
            fileMeasurement.close();
            System.out.println("ok");
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        }


    }


}




