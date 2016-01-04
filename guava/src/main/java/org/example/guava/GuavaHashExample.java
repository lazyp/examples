package org.example.guava;

import com.google.common.hash.Hashing;

/**
 * guava md5/sha1/sha256/sha512 计算
 */
public class GuavaHashExample {
    public static void main(String[] args) {
        System.out.println(Hashing.md5().hashString("aaa").toString());// md5计算,返回hex
                                                                       // string
        System.out.println(Hashing.sha1().hashString("aaaa").toString());// sha1
        System.out.println(Hashing.sha256().hashString("aaaa").toString());// sha256
        System.out.println(Hashing.sha512().hashString("aaaa").toString());// sha512
    }
}
