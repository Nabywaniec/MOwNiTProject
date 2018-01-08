package fileActiveObject;

/**
     * Created by jacek on 29.11.17.
     * */
public class Reader extends Thread {

    private int id;
    private Proxy proxy;
    private String fileName;
    private TimeManager timeManager;

    public Reader(int id, Proxy proxy, String fileName, TimeManager timeManager){
        this.id = id;
        this.proxy = proxy;
        this.fileName = fileName;
        this.timeManager = timeManager;

    }

    public void run(){

        Future consumed = proxy.read(this.fileName);
        long start = System.currentTimeMillis();

        String text = (String) consumed.getObject();
        long stop = System.currentTimeMillis();
       // System.out.println("Czas oczekiwania czytelnika to : " + (stop- start));
        this.timeManager.addMeasurement(new Measurement("Reader",  (stop - start)));
        System.out.println("Czytelnik " + id + " przeczytał: " + text);

    }

    public int getId_(){
        return this.id;
    }

    public Proxy getProxy(){
        return this.proxy;
    }

}



