package dk.incoding;

import java.io.IOException;

public class GetMain {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            final CacheHandler cache = CacheHandler.getInstance();
            System.out.println("get: " + cache.getValue(i));
        }
    }

}
