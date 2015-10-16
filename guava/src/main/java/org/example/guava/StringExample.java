package org.example.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

import static org.assertj.core.api.Assertions.*;

/**
 * 字符串相关操作的例子
 * 
 * @author lazyp
 * @version 20151015
 */
public class StringExample {
    public static void main(String[] args) {
        String str = " a bc\r\n  ";
        assertThat(CharMatcher.BREAKING_WHITESPACE.trimTrailingFrom(str))
                .isEqualTo(" a bc");// 去掉尾部的换行符、制表符、空格
        assertThat(CharMatcher.BREAKING_WHITESPACE.trimLeadingFrom(str))
                .isEqualTo("a bc\r\n  ");// 去掉头部的换行符、制表符、空格
        assertThat(CharMatcher.BREAKING_WHITESPACE.trimFrom(str)).isEqualTo(
                "a bc"); // 去掉首尾的换行符、制表符、空格
        // CharMatcher.BREAKING_WHITESPACE.trimFrom(null);//请注意会抛出null指针异常

        /* 判断字符串是否为null or "" */
        assertThat(Strings.isNullOrEmpty(null)).isTrue();
        assertThat(Strings.isNullOrEmpty("")).isTrue();
        assertThat(Strings.isNullOrEmpty(" ")).isFalse();
        assertThat(Strings.isNullOrEmpty("abc")).isFalse();
    }
}
