package fileActiveObject;

    public class Measurement{

        private String type;
        public long miliSec;

        public Measurement(String type, long miliSec){
            this.type = type;
            this.miliSec = miliSec;
        }

        public String getType() {
            return "User " + type + "  ,time :  " + miliSec;
        }
    }

