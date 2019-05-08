package constantSpecificMethod;

import java.util.*;
import java.text.*;

public enum ConstantSpecificMethod {
  DATE_TIME {
   public String getInfo() {
      return
          DateFormat.getDateInstance().format(new Date());
    }
  },
  CLASSPATH {
    public String getInfo() {
      return System.getenv("CLASSPATH");
    }
  },
  VERSION {
    public String getInfo() {
      return System.getProperty("java.version");
    }
  };
  abstract public String getInfo();

}
