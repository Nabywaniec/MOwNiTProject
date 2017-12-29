package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public interface Proxy {

    void remove(File file);
    void add(File file);
    Future write(String fileName, String data);
    Future read(String fileName);

}
