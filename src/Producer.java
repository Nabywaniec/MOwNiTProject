import java.util.Random;

/**
 * Created by jacek on 29.11.17.
 */


public class Producer extends Thread{
    private int id;
    private Proxy proxy;
    private Random rand;

    public Producer(int id, Proxy proxy){
        this.id = id;
        this.proxy = proxy;
        rand = new Random();
    }

    public void run(){

        int counter = 0;

        while(counter < 5){
            Integer tmp = rand.nextInt(100);
            File tmpFile = new File(tmp.toString(),"cos");
            proxy.add(tmpFile);
            System.out.println("Pracownik " + id + " dodal: " + tmpFile.getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter +=1 ;
        }
    }
}
