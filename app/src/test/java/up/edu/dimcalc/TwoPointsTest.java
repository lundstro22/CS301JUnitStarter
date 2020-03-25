package up.edu.dimcalc;

import org.junit.Test;

import android.graphics.Point;

import static org.junit.Assert.*;

public class TwoPointsTest {


    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertTrue(p1.x > -10 && p1.x < 10);
        assertTrue(p1.y > -10 && p1.y < 10);
        assertTrue(p2.x > -10 && p2.x < 10);
        assertTrue(p2.y > -10 && p2.y < 10);

    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);
        Point p1 = testPoints.getPoint(0);
        assertEquals(0,p1.x);
        assertEquals(0,p1.y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0,3,5);
        testPoints.copy(0,1);
        Point p1 = testPoints.getPoint(1);
        assertTrue(p1.x == 3);
        assertTrue(p1.y == 5);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0,1,1);
        testPoints.setPoint(1,3,3);
        double result = testPoints.distance();
        assertTrue(result > 2.7 && result < 2.9);

    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0,1,2);
        testPoints.setPoint(1,5,8);
        double result = testPoints.slope();
        double test = (8-2)/(5-1);
       assertTrue(result == test);

    }
}