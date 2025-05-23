package ed.lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class E02Logger {
    Map<String, Integer> hash;
    int time;
    int count;

    public E02Logger() {
        this.hash = new HashMap<>();
        this.time = 0;
        this.count = 10;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(hash.get(message) == null) {
            hash.put(message, count + timestamp);
            return true;
        }

        if(hash.containsKey(message)) {
            if(timestamp >= hash.get(message)) {
                hash.put(message, count + timestamp);
                return true;
            }
        }
        return false;
    }

}
