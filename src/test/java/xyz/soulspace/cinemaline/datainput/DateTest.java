package xyz.soulspace.cinemaline.datainput;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class DateTest {
    @Test
    public void testStream() {
        int[] a = new int[]{1, 2, 3, 4, 56, 6, 7, 7};
        //Arrays.stream(a).forEach(System.out::println);
        Arrays.stream(a).map(operand -> operand + 1)
                .forEach(System.out::println);
    }
}
