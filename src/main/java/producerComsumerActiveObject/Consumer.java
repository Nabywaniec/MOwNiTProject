package producerComsumerActiveObject;

import fileActiveObject.Future;
import fileActiveObject.Proxy;

/**
 * Created by jacek on 29.11.17.
 */
public class Consumer extends Thread {

    private int id;
    private Proxy proxy;

    public Consumer(int id, Proxy proxy){
        this.id = id;
        this.proxy = proxy;
    }

    public void run(){
        int counter = 0;
       // while(counter < 5){
            Future consumed = proxy.remove("1");
            long start = System.currentTimeMillis();
            while(!consumed.isReady()){
                System.out.println("Konsumer " + id + " czeka.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long stop = System.currentTimeMillis();
            System.out.println("Czas oczekiwania to : " + (stop- start));
            System.out.println("Konsument " + id
                    + " zjadl: " + consumed.getObject().toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
      //  }
    }

    public int getId_(){
        return this.id;
    }

    public Proxy getProxy(){
        return this.proxy;
    }

}
