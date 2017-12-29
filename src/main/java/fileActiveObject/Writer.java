package fileActiveObject;

public class Writer extends Thread {

    private int id;
    private Proxy proxy;
    private String fileName;
    private String data;

    public Writer(int id, Proxy proxy, String fileName, String data){
        this.id = id;
        this.proxy = proxy;
        this.fileName = fileName;
        this.data = data;
    }

    public void run(){
        int counter = 0;
        //while(counter < 5){
            Future consumed = proxy.write(this.fileName, this.data);
            long start = System.currentTimeMillis();
            while(!consumed.isReady()){
                System.out.println("Pisarz " + id + " czeka.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long stop = System.currentTimeMillis();
            System.out.println("Czas oczekiwania czytelnika to : " + (stop- start));
            System.out.println("Pisarz " + id
                    + " napisal: " + consumed.getObject().toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter += 1;
       // }
    }

    public int getId_(){
        return this.id;
    }

    public Proxy getProxy(){
        return this.proxy;
    }

}
