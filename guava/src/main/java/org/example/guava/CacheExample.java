package org.example.guava;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import static org.assertj.core.api.Assertions.*;

public class CacheExample {
    private static ConcurrentHashMap<String, String> DB_MAP = new ConcurrentHashMap<>();

    static {
        DB_MAP.put("k1", "v1");
        DB_MAP.put("k2", "v2");
        DB_MAP.put("k3", "v3");
    }

    public static void main(String[] args) {
        /*
         * 构建一个缓存 1.值5s过期(expireAfterWrite) 2.缓存不存在的时候，从db自动加载(CacheLoader抽象类)
         */
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return DB_MAP.get(key);
                    }
                });

        try {
            assertThat(cache.get("k1")).isEqualTo("v1");
            DB_MAP.put("k1", "v1_1");// 改变对应的值
            assertThat(cache.get("k1")).isEqualTo("v1");// 由于缓存未过期，所以值依然是v1
            Thread.sleep(5100L);
            assertThat(cache.get("k1")).isEqualTo("v1_1");// 休眠5秒100毫秒后，缓存已过期，会自动加载最新的值，所以是"v1_1"
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
