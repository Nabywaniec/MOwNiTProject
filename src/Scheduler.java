import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by jacek on 29.11.17.
 */
public class Scheduler extends Thread {

    private Queue<IMethod> queue;

    public Scheduler(){
        this.queue = new ConcurrentLinkedQueue<IMethod>();
    }

    public void add(IMethod method){
        this.queue.add(method);
    }

    @Override
    public void run() {

        while (true) {

            try {
                IMethod method = this.queue.poll();
                if (method != null && method.guard()) {
                    method.call();
                } else {
                    this.add(method);
                }
            } catch (Exception e) {

            }
        }

    }
}
