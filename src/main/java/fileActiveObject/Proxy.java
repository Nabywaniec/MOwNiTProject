package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public interface Proxy {

    Future remove(String fileName);
    Future add(String fileName);
    Future write(String fileName, String data);
    Future read(String fileName);

}
