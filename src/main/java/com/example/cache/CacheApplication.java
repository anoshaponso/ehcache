package com.example.cache;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
//	@Bean("cacheManger")
//	public CacheManager cacheManger(){
//		CacheConfiguration<Long, String> cacheConfiguration = newCacheConfigurationBuilder(Long.class, String.class,
//				heap(100))
//				.withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(20)))
//				.build();
//		CacheManager cacheManager = newCacheManagerBuilder()
//				.with(CacheManagerBuilder.persistence(  "myData"))
//				.withCache("personCache",
//						newCacheConfigurationBuilder(Long.class, Person.class, heap(100).offheap(1, MB))
//								.withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(20))))
////                .withSizeOfMaxObjectSize("d",2)
//				.build(true);
//
//		return cacheManager;
//	}

}
