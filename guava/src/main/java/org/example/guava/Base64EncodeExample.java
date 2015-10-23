package org.example.guava;

import com.google.common.io.BaseEncoding;
import static org.assertj.core.api.Assertions.*;

/**
 * 
 * guava base64 encode and decode
 * 
 * @author lazyp
 *
 */
public class Base64EncodeExample {

    public static void main(String[] args) {
        String str = "hello word";
        String base64Str = "aGVsbG8gd29yZA==";

        /* Base64编码:BaseEncoding.base64().encode(str.getBytes()) */
        assertThat(BaseEncoding.base64().encode(str.getBytes())).isEqualTo(base64Str);

        /* Base64解码:BaseEncoding.base64().decode(base64Str) */
        assertThat(new String(BaseEncoding.base64().decode(base64Str))).isEqualTo(str);

    }
}
