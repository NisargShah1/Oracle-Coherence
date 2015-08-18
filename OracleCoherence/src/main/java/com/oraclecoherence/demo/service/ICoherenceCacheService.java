package com.oraclecoherence.demo.service;

import com.tangosol.net.NamedCache;

public interface ICoherenceCacheService {
	
	public NamedCache getCache();
    public void addToCache(Object key, Object value);
    public void deleteFromCache(Object key);

}
