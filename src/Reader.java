 /**
     * Created by jacek on 29.11.17.
     * */
    public class Reader extends Thread {

        private int id;
        private Proxy proxy;
        private String fileName;

        public Reader(int id, Proxy proxy, String fileName){
            this.id = id;
            this.proxy = proxy;
            this.fileName = fileName;
        }

        public void run(){
            int counter = 0;
            while(counter < 5){
                Future consumed = proxy.read(this.fileName);
                long start = System.currentTimeMillis();
                while(!consumed.isReady()){
                    System.out.println("Czytelnik " + id + " czeka.");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long stop = System.currentTimeMillis();
                System.out.println("Czas oczekiwania czytelnika to : " + (stop- start));
                System.out.println("Czytelnik " + id
                        + " przeczytał: " + consumed.getObject().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter += 1;
            }
        }

        public int getId_(){
            return this.id;
        }

        public Proxy getProxy(){
            return this.proxy;
        }

    }



