package org.ulco;

public class Square extends GraphicsObject {
    public Square(Point center, double length) {
        this.m_center = center;
        this.m_length = length;
    }

    public Square(String json) {
        String str = json.replaceAll("\\s+","");
        int centerIndex = str.indexOf("center");
        int lengthIndex = str.indexOf("length");
        int endIndex = str.lastIndexOf("}");

        m_center = new Point(str.substring(centerIndex + 7, lengthIndex - 1));
        m_length = Double.parseDouble(str.substring(lengthIndex + 7, endIndex));
    }

    public GraphicsObject copy() {
        return new Square(m_center.copy(), m_length);
    }

    public boolean isClosed(Point pt, double distance) {
        Point center = new Point(m_center.getX() + m_length / 2, m_center.getY() + m_length / 2);

        return Math.sqrt((center.getX() - pt.getX()) * (center.getX() - pt.getX()) +
                ((center.getY() - pt.getY()) * (center.getY() - pt.getY()))) <= distance;
    }

    public String toJson() {
        return "{ type: square, center: " + m_center.toJson() + ", length: " + this.m_length + " }";
    }

    public String toString() {
        return "square[" + m_center.toString() + "," + m_length + "]";
    }

    private final Point m_center;
    private final double m_length;
}
