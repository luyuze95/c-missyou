package com.luyuze.missyou.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional() {
        Optional<String> empty = Optional.empty();
        Optional<String> t1 = Optional.of("abc");
        Optional<String> t2 = Optional.ofNullable(null);
        t2.ifPresent(System.out::println);
    }
}
