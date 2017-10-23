package cz.jug.sohlich;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Radomir Sohlich on 22/10/2017.
 */
public class ArrayTest {
    @Test
    public void runArray() {

        List<Integer> original  = Arrays.asList(1,2,3);
        List<Integer> output = original
                .stream()
                .map(num -> num *2)
                .collect(Collectors.toList());
        System.out.println(output);
    }
}
