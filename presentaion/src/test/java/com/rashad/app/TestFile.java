package com.rashad.app;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestFile {

    @Test
    public void firstQuestion () {
        List<List<Long>> sides = new ArrayList<>();

        List<Long> one = new ArrayList<>();
        one.add(2l);
        one.add(1l);

        List<Long> two = new ArrayList<>();
        two.add(10l);
        two.add(5l);

        List<Long> three  = new ArrayList<>();
        three.add(9l);
        three.add(3l);

        List<Long> four  = new ArrayList<>();
        four.add(6l);
        four.add(2l);

        List<Long> five  = new ArrayList<>();
        five.add(3l);
        five.add(1l);

        sides.add(one );
        sides.add(two );
        sides.add(three );
        sides.add(four );
        sides.add(five );

        assertEquals (nearlySimilarRectangles(sides),3);

    }


    public static Boolean isSimilarRectangles(List<Long> first ,List<Long> two  ){


        return (first.get(0).doubleValue()/two.get(0).doubleValue() == first.get(1).doubleValue()/two.get(1).doubleValue()) ;


    }
    /*
     * Complete the 'nearlySimilarRectangles' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts 2D_LONG_INTEGER_ARRAY sides as parameter.
     */

    public static long nearlySimilarRectangles(List<List<Long>> sides) {
        // Write your code here

        long max= 0 ;
        for (int i =0 ; i< sides.size(); i++ )
        {
            long count =0;
            for (int j =0 ; j< sides.size(); j++ ){
                if (i != j )
                {
                    if (isSimilarRectangles(sides.get(i),sides.get(j)))
                    {
                        count ++;
                    }
                }

            }
            if (count==0 )
                continue;
            max = count+1 > max ? count+1 : max ;
        }

        return max;

    }
}