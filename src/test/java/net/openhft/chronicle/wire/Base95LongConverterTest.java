package net.openhft.chronicle.wire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Base95LongConverterTest {

    @Test
    public void parse() {
        LongConverter c = Base95LongConverter.INSTANCE;
        System.out.println(c.asString(-1L));
        for (String s : ",a,ab,abc,abcd,ab.de,123+56,1234567,12345678,123456789,z23456789,0z23456789,<8S@[|bcnB".split(",")) {
            long v = c.parse(s);
            StringBuilder sb = new StringBuilder();
            c.append(sb, v);
            assertEquals(s, sb.toString());
        }
    }
}