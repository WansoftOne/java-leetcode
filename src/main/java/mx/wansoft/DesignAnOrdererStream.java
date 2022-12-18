package mx.wansoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesignAnOrdererStream {
    
    public static void run() {
    }

    class OrderedStream {
        String[] data;
        int ptr = 0;
         
    
        public OrderedStream(int n) {
            data = new String[n];
        }
        
        public List<String> insert(int idKey, String value) {
            data[idKey - 1] = value;
            Collections.max(Arrays.asList(4,5,5));
            List<String> result = new ArrayList<String>();
            if (value == null) {
                result = null;
            } else if (idKey - 1 == ptr) {
                for (int i = ptr; i < data.length; i++) {
                    String item = data[i];
                    if (item != null) {
                        ptr += 1;
                        result.add(item);
                    } else {
                        break;
                    }
                }
                
            }
    
            return result;
        }
    }
}
