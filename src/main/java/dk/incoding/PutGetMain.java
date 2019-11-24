package dk.incoding;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PutGetMain {

    static AtomicBoolean ready = new AtomicBoolean(false);

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("args: put or get");
            return;
        } else {
            final CacheHandler cache = CacheHandler.getInstance();
            if (args[0].equalsIgnoreCase("put")) {
                for (int i = 0; i < 10; i++) {
                    cache.put(i, Integer.toString(i));
                    System.out.println("put: " + i);
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    System.out.println("get: " + cache.getValue(i));
                }
            }
        }
        System.out.println("Press Enter to continue");
        try{System.in.read();}
        catch(Exception e){}

    }
}
