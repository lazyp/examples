/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.guava;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * guava list分组例子
 *
 * @author lazyp<lazy_p@163.com>
 */
public class ListGroupExample {

    protected static class Entry {

        private int age;
        private String name;

        public Entry(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("Entry{age=%d,name=%s}", age, name);
        }

    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Entry(20, "xiaosan1"));
        list.add(new Entry(18, "xiaosan2"));
        list.add(new Entry(18, "xiaosan3"));
        list.add(new Entry(20, "xiaosan4"));
        list.add(new Entry(18, "xiaosan5"));
        list.add(new Entry(20, "xiaosan6"));

        /*
        需求:根据年龄跟小三分组
         */
        Map<Integer, Entry> map = Multimaps.index(list, new Function<Entry, Integer>() {
            @Override
            public Integer apply(Entry input) {
                return input.getAge();
            }

        }).asMap();

        /*
        output:
        {20=[Entry{age=20,name=xiaosan1}, Entry{age=20,name=xiaosan4}, Entry{age=20,name=xiaosan6}], 18=[Entry{age=18,name=xiaosan2}, Entry{age=18,name=xiaosan3}, Entry{age=18,name=xiaosan5}]}
         */
        System.out.println(map);
    }

}
