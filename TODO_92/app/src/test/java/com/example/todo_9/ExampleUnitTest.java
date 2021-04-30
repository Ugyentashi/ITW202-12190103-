package com.example.todo_9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import androidx.test.filters.SmallTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 */
@RunWith(JUnit4.class)

@SmallTest
public class ExampleUnitTest {
    private Calculator mCalculator;
    @Before
    public void SetUp(){
        mCalculator = new Calculator();
    }
//    @Test
//    public void addTwoNumber(){
//        double result = mCalculator.add(1d,2d);
//        assertThat(result,is(equalTo(3d)));
//    }
//    @Test
//    public  void addTwoNumberFOrNegative(){
//        double result = mCalculator.add(-1d,2d);
//        assertThat(result,is(equalTo(1d)));
//    }
//    @Test
//    public  void addTwoNumberFOrFloat(){
//        double result = mCalculator.add(1.111f,2.222d);
//        assertThat(result,is(closeTo(3.333d, 0.01)));
//    }
    @Test
    public void subTwoNumbers(){
        double result = mCalculator.sub(1d,1d);
        assertThat(result,is(equalTo(0d)));
    }

    @Test
    public void subWorksWithNegativeResults(){
        double result = mCalculator.sub(2d,3d);
        assertThat(result,is(equalTo(-1d)));
    }
    @Test
    public void mulTwoNumber(){
        double result = mCalculator.Mul(2d,3d);
        assertThat(result,is(equalTo(6d)));

    }
    @Test
    public void mulTwoNumberZero(){
        double result = mCalculator.Mul(0d,3d);
        assertThat(result,is(equalTo(0d)));

    }
    @Test
    public void divTwoNumber(){
        double result = mCalculator.div(15d,5d);
        assertThat(result,is(equalTo(3d)));

    }
    @Test
    public void divTwoNumberZero(){
        double result = mCalculator.div(15d,0d);
        assertThat(result,is(equalTo(Double.POSITIVE_INFINITY)));

    }

}