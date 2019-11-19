package dk.incoding;

import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;

import java.io.IOException;

public class CacheHandler {

    private static CacheHandler instance;
    private static Cache<Integer, String> cache;
    private static final Object LOCK = new Object();
    private CacheHandler() {
    }



    public static CacheHandler getInstance() throws IOException {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new CacheHandler();
                cache = new DefaultCacheManager("infinispan.xml").getCache();
            }
        }
        return instance;
    }

    public void put(int key, String value){
        cache.put(key,value);
    }

    public String getValue(int key){
        return cache.get(key);
    }

}
