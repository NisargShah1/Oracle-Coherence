package com.oraclecoherence.demo.service;

import com.oraclecoherence.demo.listener.EmployeeMapListener;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class CoherenceCacheService implements ICoherenceCacheService{

		private NamedCache cache = null;    
	     
	    public CoherenceCacheService() {
	        cache = CacheFactory.getCache("employee-map");
	        cache.addMapListener(new EmployeeMapListener());        
	    }   
	     
	    public NamedCache getCache() {
	        return cache;
	    }
	 
	    public void setCache(NamedCache cache) {
	        this.cache = cache;
	    }
	 
	    public void addToCache(Object key, Object value) {
	        // key is locked
	        cache.lock(key, -1);
	        try {
	            // application logic
	            cache.put(key, value);
	        } finally {
	            // key is unlocked
	            cache.unlock(key);
	        }
	    }
	 
	    public void deleteFromCache(Object key) {
	        // key is locked
	        cache.lock(key, -1);
	        try {
	            // application logic
	            cache.remove(key);
	        } finally {
	            // key is unlocked
	            cache.unlock(key);
	        }
	    }       
}
