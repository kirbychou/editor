package org.ulco.test;

import junit.framework.TestCase;
import org.ulco.*;

public class GroupTest extends TestCase {

    public void testSize() throws Exception {
        Group g = new Group();

        assertEquals(g.size(), 0);
    }

    public void testSize2() throws Exception {
        Group g = new Group();
        Square s = new Square(new Point(0,0), 5);
        Circle c = new Circle(new Point(5,5), 4);

        g.add(s);
        g.add(c);
        assertEquals(g.size(), 2);
    }

    public void testSize3() throws Exception {
        Group g = new Group();
        Square s = new Square(new Point(0,0), 5);
        Circle c = new Circle(new Point(5,5), 4);
        Group g2 = new Group();
        Rectangle r = new Rectangle(new Point(-6,10), 5.2, 9);

        g.add(s);
        g.add(c);
        g2.add(g);
        g2.add(r);
        assertEquals(g2.size(), 3);
    }

    public void testJson() throws Exception {
        Group g = new Group();
        Square s = new Square(new Point(0,0), 5);
        Circle c = new Circle(new Point(5,5), 4);

        g.add(s);
        g.add(c);
        assertEquals(g.toJson(), "{ type: group, objects : { { type: square, center: { type: point, x: 0.0, y: 0.0 }, length: 5.0 }, " +
                "{ type: circle, center: { type: point, x: 5.0, y: 5.0 }, radius: 4.0 } }, groups : {  } }");
    }

    public void testJson2() throws Exception {
        Group g = new Group();
        Square s = new Square(new Point(0,0), 5);
        Circle c = new Circle(new Point(5,5), 4);
        Group g2 = new Group();
        Rectangle r = new Rectangle(new Point(-6,10), 5.2, 9);

        g.add(s);
        g.add(c);
        g2.add(g);
        g2.add(r);
        assertEquals(g2.toJson(), "{ type: group, objects : { { type: rectangle, center: { type: point, x: -6.0, y: 10.0 }, " +
                "height: 5.2, width: 9.0 } }, groups : { { type: group, objects : { { type: square, center: { type: point, x: 0.0, " +
                "y: 0.0 }, length: 5.0 }, { type: circle, center: { type: point, x: 5.0, y: 5.0 }, radius: 4.0 } }, " +
                "groups : {  } } } }");
    }
}