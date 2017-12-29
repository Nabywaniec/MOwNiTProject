package fileActiveObject;

/**
 * Created by jacek on 28.12.17.
 */
public class File {

    private String name;
    private String content;

    public File(String name, String content){
        this.name = name;
        this.content = content;
    }

    private void setContent(String content){
        this.content = content;
    }

    private void addContent(String addContent){
        this.content += addContent;
    }

    public String getName(){
        return  this.name;
    }

    public String getContent(){
        return this.content;
    }


}
