package fileActiveObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TimeManager {


    private final ReentrantLock lock;
    private List<Measurement> measurements;
    private int id;
    private HashMap<String, Long> statistics = new HashMap<String, Long>();

    public TimeManager(int id) {
        this.id = id;
        this.measurements = new ArrayList<Measurement>();
        this.lock = new ReentrantLock();
        this.statistics.put("Adder",new Long(0));
        this.statistics.put("Deleter",new Long(0));
        this.statistics.put("Reader",new Long(0));
        this.statistics.put("Writer",new Long(0));
        this.statistics.put("Adder1",new Long(0));
        this.statistics.put("Deleter1",new Long(0));
        this.statistics.put("Reader1",new Long(0));
        this.statistics.put("Writer1",new Long(0));
        
    }

    public void addMeasurement(Measurement m) {
        this.lock.lock();
        this.measurements.add(m);

        long l = statistics.get(m.getType());
        long l1 = statistics.get(m.getType()+"1");

        System.out.println(l1 + " " + l );

        this.statistics.put(m.getType(), (long)l1 + m.miliSec);
        this.statistics.put(m.getType() + "1", (long)l1 + 1);
        this.id += 1;
        this.lock.unlock();
        
    }

    public void saveToFile(){

        String toFile  = "";
        System.out.println("Reader " + statistics.get("Reader") + " LICZBA WYWOLAN " + statistics.get("Reader1"));
        System.out.println("Writer " + statistics.get("Writer") + " LICZBA WYWOLAN " + statistics.get("Writer1"));
        System.out.println("Deleter " + statistics.get("Deleter")  + " LICZBA WYWOLAN " + statistics.get("Deleter1"));
        System.out.println("Adder " + statistics.get("Adder") + " LICZBA WYWOLAN " + statistics.get("Adder1"));

        HashMap<String, Long> s = getMedian();

        System.out.println(" MEDIAN Reader " + s.get("Reader"));
        System.out.println(" MEDIAN Writer " + s.get("Writer"));
        System.out.println(" MEDIAN Deleter " + s.get("Deleter"));
        System.out.println(" MEDIAN Adder " + s.get("Adder"));

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


    private HashMap<String, Long> getMedian(){
        HashMap<String, Long> s = new HashMap<String, Long>();
        s.put("Reader", statistics.get("Reader")/ statistics.get("Reader1"));
        s.put("Writer", statistics.get("Writer")/ statistics.get("Writer1"));
        s.put("Adder", statistics.get("Adder")/ statistics.get("Adder1"));
        s.put("Deleter", statistics.get("Deleter")/ statistics.get("Deleter1"));
        return s;
    }


}




