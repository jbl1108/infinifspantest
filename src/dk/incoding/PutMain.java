package dk.incoding;

import java.io.IOException;

public class PutMain {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            final CacheHandler cache = CacheHandler.getInstance();
            cache.put(i, Integer.toString(i));
            System.out.println("put: " + i);
        }
    }

}
