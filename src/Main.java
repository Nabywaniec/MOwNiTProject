/**
 * Created by jacek on 29.11.17.
 */

public class Main {

    private final static int ACTIVE_OBJECTS = 10;

    public static void main(String[] argv) throws InterruptedException {
        ActiveObject activeObject = new ActiveObject(ACTIVE_OBJECTS);
        Proxy proxy = activeObject.getProxy();
        ConsumersAndProducersManage manage = new ConsumersAndProducersManage(0,0, proxy);
        manage.begin();
        manage.startProducer();
        manage.startConsumer();


    }
}
