package fileActiveObject;

public class Adder extends Thread {

    private int id;
    private Proxy proxy;
    private String fileName;
    private TimeManager timeManager;

    public Adder(int id, Proxy proxy, String fileName, TimeManager timeManager){
        this.id = id;
        this.proxy = proxy;
        this.fileName = fileName;
        this.timeManager = timeManager;
    }

    public void run(){

            Future consumed = proxy.add(this.fileName);
            long start = System.currentTimeMillis();
            Boolean isAdded =(Boolean) consumed.getObject();
            long stop = System.currentTimeMillis();
            this.timeManager.addMeasurement(new Measurement("Adder", (stop - start)));
            System.out.println("Dodawacz " + id + " dodal: " + isAdded);

    }

    public int getId_(){
        return this.id;
    }

    public Proxy getProxy(){
        return this.proxy;
    }

}
