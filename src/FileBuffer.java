import java.util.LinkedList;

/**
 * Created by jacek on 28.12.17.
 */
public class FileBuffer {

    private LinkedList<File> files = new LinkedList<>();
    private int buffersize;

    public FileBuffer(int buffersize){
        this.buffersize = buffersize;
    }

    public void add(File file){
        this.files.add(file);
    }

    public File findFile(String name){
        for(File f : files){
            if(f.getName().equals(name)){
                return f;
            }
        }
        return null;
    }


    public File removeFile(){
            if(! this.isEmpty()){
                File f = this.files.get(0);
                this.files.remove(0);
                return f;
        }
        System.out.println("Nie ma takiego pliku");
        return null;
    }

    public String readFile(String fileName){
        if(findFile(fileName) != null){
            File found = findFile(fileName) ;
            return found.getContent();
        }
        return "";
    }

    public boolean isFull(){
        return this.files.size() == buffersize;
    }

    public boolean isEmpty(){return this.files.size() == 0;}

}
