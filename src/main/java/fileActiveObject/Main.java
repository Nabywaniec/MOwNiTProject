package fileActiveObject;

import java.util.LinkedList;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class Main {
    private final static int ACTIVE_OBJECTS = 10;
    private static final int N = 10;
    private static final RandomStringGenerator randomStringGenerator =
            new RandomStringGenerator.Builder()
                    .withinRange('0', 'z')
                    .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                    .build();



    public static void main(String[] argv) throws InterruptedException {
        ActiveObject activeObject = new ActiveObject(ACTIVE_OBJECTS);
        Proxy proxy = activeObject.getProxy();
        Adder a = new Adder(1, proxy, "1");
        Reader[] r = new Reader[N];
        Writer[] w = new Writer[N];
        Deleter d = new Deleter(1,proxy,"1");
        for(int i = 0; i < N; i++){
            r[i] = new Reader(i, proxy,"1");
            w[i] = new Writer(i, proxy,"1", randomStringGenerator.generate(10));

        }

        a.run();
        for(int i = 0; i < N; i++){
            r[i].run();
            w[i].run();

        }
        d.run();

    }
}
