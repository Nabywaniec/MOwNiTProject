import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jacek on 13.12.17.
 */
public class ConsumersAndProducersManage implements IConsumersAndProducersManage {

    private int actual_id_consumers;
    private int actual_id_producers;
    private Proxy proxy;
    private final static int PROD_COUNT = 3;
    private final static int CONS_COUNT = 5;
    private HashMap<Integer, Consumer> consumers = new HashMap<>();
    private HashMap<Integer, Producer> producers = new HashMap<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(8);

    public ConsumersAndProducersManage(int actual_id_consumers,int actual_id_producers, Proxy proxy){
        this.actual_id_consumers = actual_id_consumers;
        this.actual_id_producers = actual_id_producers;
        this.proxy = proxy;
    }

    public void startConsumer(){
        Consumer new_consumer = new Consumer(actual_id_consumers, proxy);
        consumers.put(actual_id_consumers, new_consumer);
       // System.out.println("Actual consumers id : " + actual_id_consumers);
        actual_id_consumers += 1;
        executorService.submit(new_consumer);
    }

    public void deleteConsumer(int id){
        try {
            consumers.get(id).join();
            consumers.remove(id);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void startProducer(){
        Producer new_producer = new Producer(actual_id_producers, proxy);
        producers.put(actual_id_producers, new_producer);
       // System.out.println("Actual producers id : " + actual_id_producers);
        actual_id_producers += 1;
        executorService.submit(new_producer);
    }

    public void deleteProducer(int id){
        try{
            producers.get(id).join();
            producers.remove(id);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public void begin() {

        actual_id_producers = PROD_COUNT;
        actual_id_consumers = CONS_COUNT;

        try {
            for (int i = 0; i < PROD_COUNT; i++) {
                producers.put(i, new Producer(i, proxy));
            }

            for (int i = 0; i < CONS_COUNT; i++) {
                consumers.put(i, new Consumer(i, proxy));
            }

            for (int i = 0; i < PROD_COUNT; i++) {
               executorService.submit(producers.get(i));
            }

            for (int i = 0; i < CONS_COUNT; i++) {
                executorService.submit(consumers.get(i));
            }

            startProducer();
            startConsumer();

            for (int i = 0; i < PROD_COUNT; i++) {
                producers.get(i).join();
                producers.remove(i);
            }

            for (int i = 0; i < CONS_COUNT; i++) {
                consumers.get(i).join();
                consumers.remove(i);
            }
            deleteConsumer(5);
            deleteProducer(3);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
