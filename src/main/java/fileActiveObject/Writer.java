package fileActiveObject;

import java.sql.Time;

public class Writer extends Thread {

    private int id;
    private Proxy proxy;
    private String fileName;
    private String data;
    private TimeManager timeManager;

    public Writer(int id, Proxy proxy, String fileName, String data, TimeManager timeManager){
        this.id = id;
        this.proxy = proxy;
        this.fileName = fileName;
        this.data = data;
        this.timeManager = timeManager;
    }

    public void run(){

        Future consumed = proxy.write(this.fileName, this.data);
        long start = System.currentTimeMillis();

        Boolean isWritten = (Boolean) consumed.getObject();
        long stop = System.currentTimeMillis();
        //System.out.println("Czas oczekiwania czytelnika to : " + (stop- start));
        this.timeManager.addMeasurement(new Measurement("Writer", (stop - start)));
        System.out.println("Pisarz " + id
                + " napisal: " + isWritten);

    }

    public int getId_(){
        return this.id;
    }

    public Proxy getProxy(){
        return this.proxy;
    }

}
