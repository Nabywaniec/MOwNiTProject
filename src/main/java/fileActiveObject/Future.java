package fileActiveObject;

/**
 * Created by jacek on 29.11.17.
 */
public class Future {

    private Object object = null;
    private boolean flag = false;

    public void setFuture(Object object){
        this.object = object;
    }

    public Object getObject() {
        return this.object;
    }

    public void setFlag(){this.flag = true;}

    public boolean isReady(){
        //return object != null;
        return this.flag;
    }


}
