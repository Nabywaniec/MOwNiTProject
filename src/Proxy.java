/**
 * Created by jacek on 29.11.17.
 */
public interface Proxy {

    Future remove();
    void add(File file);
    Future read(String fileName);

}
