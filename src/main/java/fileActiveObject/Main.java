package fileActiveObject;

import java.util.LinkedList;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class Main {
    private final static int ACTIVE_OBJECTS = 10;
    private static final int N = 5;
    private static final RandomStringGenerator randomStringGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange('0', 'z')
                    .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                    .build();



    public static void main(String[] argv) throws InterruptedException {
        ActiveObject activeObject = new ActiveObject(ACTIVE_OBJECTS);
        TimeManager timeManager = activeObject.getTimer();
        Proxy proxy = activeObject.getProxy();
        Adder a = new Adder(1, proxy, "1", timeManager);
        Adder a1 = new Adder(1, proxy, "1", timeManager);
        Reader[] r = new Reader[N];
        Writer[] w = new Writer[N];
        Deleter d = new Deleter(1,proxy,"1", timeManager);
        for(int i = 0; i < N; i++){
            r[i] = new Reader(i, proxy,"1", timeManager);
            w[i] = new Writer(i, proxy,"1", randomStringGenerator.generate(1), timeManager);

        }


        d.start();
        a.start();
        a1.start();
        for(int i = 0; i < N; i++){

            r[i].start();
            w[i].start();


        }


        System.out.println(java.lang.Thread.activeCount());

        for(int i = 0; i < N; i++){

            r[i].join();
            w[i].join();


        }
        d.join();
        a.join();
        a1.join();



        System.out.println("Completed");
        timeManager.saveToFile();
    }
}
