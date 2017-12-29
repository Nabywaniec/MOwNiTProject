package fileActiveObject;

import java.util.HashMap;

/**
 * Created by jacek on 28.12.17.
 */
public class FileBuffer {

    private HashMap<String, File> files = new HashMap<String, File>();
    private int buffersize;

    public FileBuffer(int buffersize){
        this.buffersize = buffersize;
    }

    public boolean add(String fileName){

        if(!files.containsKey(fileName)) {
            this.files.put(fileName, new File(fileName, ""));
            return true;
        }
        return false;

    }

    public File findFile(String fileName){
        if(files.containsKey(fileName))
            return files.get(fileName);
        return null;
    }


    public boolean removeFile(String fileName){
        if(files.containsKey(fileName)){
            files.remove(fileName);
            return true;
        }
        System.out.println("Nie ma takiego pliku");
        return false;
    }

    public String readFile(String fileName){
        if(findFile(fileName) != null){
            File found = findFile(fileName) ;
            return found.getContent();
        }
        return "";
    }

    public boolean writeFile(String fileName, String addContent){
        if(findFile(fileName) != null){
            File found = findFile(fileName) ;
            found.addContent(addContent);
            return true;
        }
        return false;
    }


    public boolean isFull(){
        return this.files.size() == buffersize;
    }

    public boolean isEmpty(){return this.files.size() == 0;}

}
