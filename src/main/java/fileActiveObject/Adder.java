package fileActiveObject;

public class Adder extends Thread {

    private int id;
    private Proxy proxy;
    private String fileName;

    public Adder(int id, Proxy proxy, String fileName){
        this.id = id;
        this.proxy = proxy;
        this.fileName = fileName;
    }

    public void run(){
        int counter = 0;
       // while(counter < 5){
            Future consumed = proxy.add(this.fileName);
            long start = System.currentTimeMillis();
            while(!consumed.isReady()){
                System.out.println("Dodawacz " + id + " czeka.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long stop = System.currentTimeMillis();
            System.out.println("Czas oczekiwania dodawacza to : " + (stop- start));
            System.out.println("Dodawacz " + id
                    + " dodal: " + consumed.getObject().toString());
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
