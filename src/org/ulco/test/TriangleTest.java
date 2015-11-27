package org.ulco.test;

import junit.framework.Test;
import junit.framework.TestCase;
import org.ulco.GraphicsObject;
import org.ulco.Point;
import org.ulco.Triangle;

/**
 * Created by lcarpent on 27/11/15.
 */
public class TriangleTest extends TestCase{
        public void testType() throws Exception {
           Triangle r = new Triangle(new Point(0, 0), new Point(0,0 ),new Point(3,3 ) ,new Point(3,0 ));

            assertTrue(r instanceof Triangle);
            assertTrue(r instanceof GraphicsObject);
        }

        public void testJson() throws Exception {
            Triangle r = new Triangle(new Point(0, 0), new Point(0,0 ),new Point(3,3 ) ,new Point(3,0 ));

            assertEquals(r.toJson(), "{ type: triangle, origin: { type: point, x: 0.0, y: 0.0 }, a: { type: point, x: 0.0, y: 0.0 }, b: { type: point, x: 3.0, y: 3.0 }, c: { type: point, x: 3.0, y: 0.0 } }");
        }

        public void testCopy() throws Exception {
            Triangle r = new Triangle(new Point(0, 0), new Point(0,0 ),new Point(3,3 ) ,new Point(3,0 ));

            assertEquals(r.toJson(), r.copy().toJson());
        }

        public void testIsClosed() throws Exception {
            Triangle r = new Triangle(new Point(0, 0), new Point(0,0 ),new Point(3,3 ) ,new Point(3,0 ));

            assertTrue(r.isClosed(new Point(1, 1), 4));
        }

}
