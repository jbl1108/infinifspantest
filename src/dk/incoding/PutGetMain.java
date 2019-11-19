package dk.incoding;

import org.infinispan.Cache;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class PutGetMain {

    static AtomicBoolean ready = new AtomicBoolean(false);

    public static void main(String[] args) {
	// write your code here
         new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<10; i++) {

                    try {
                        final CacheHandler cache = CacheHandler.getInstance();
                        cache.put(i,Integer.toString(i));
                        System.out.println("put: "+i);
                        ready.set(true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Sleep for a while
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Sleep for a while
                while (ready.get() == false);
                for(int i=0; i<10; i++) {

                    try {
                        final CacheHandler cache = CacheHandler.getInstance();
                        String val = cache.getValue(i);
                        System.out.println(val + " looping ...");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Sleep for a while
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }).start();
    while (true);
    }
}
