package com.loyalty.exception;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheExceptionHandler implements CacheErrorHandler {	

	@Override
	public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
		log.error("GET Error: {}", exception);
	}

	@Override
	public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
		log.error("PUT Error: {}", exception);
	}

	@Override
	public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
		log.error("EVICT Error: {}", exception);
	}

	@Override
	public void handleCacheClearError(RuntimeException exception, Cache cache) {
		log.error("CLEAR Error: {}", exception);
	}
}
