package org.ulco;

public class Rectangle extends GraphicsObject {
    public Rectangle(Point center, double height, double width) {
        this.m_center = center;
        this.m_height = height;
        this.m_width = width;
    }

    public Rectangle(String json) {
        String str = json.replaceAll("\\s+","");
        int centerIndex = str.indexOf("center");
        int heightIndex = str.indexOf("height");
        int widthIndex = str.indexOf("width");
        int endIndex = str.lastIndexOf("}");

        m_center = new Point(str.substring(centerIndex + 7, heightIndex - 1));
        m_height = Double.parseDouble(str.substring(heightIndex + 7, widthIndex - 1));
        m_width = Double.parseDouble(str.substring(widthIndex + 6, endIndex));
    }

    public GraphicsObject copy() {
        return new Rectangle(m_center.copy(), m_height, m_width);
    }

    public boolean isClosed(Point pt, double distance) {
        Point center = new Point(m_center.getX() + m_width / 2, m_center.getY() + m_height / 2);

        return Math.sqrt((center.getX() - pt.getX()) * (center.getX() - pt.getX()) +
                ((center.getY() - pt.getY()) * (center.getY() - pt.getY()))) <= distance;
    }

    public String toJson() {
        return "{ type: rectangle, center: " + m_center.toJson() + ", height: " + this.m_height + ", width: " + this.m_width + " }";
    }

    public String toString() {
        return "rectangle[" + m_center.toString() + "," + m_height + "," + m_width + "]";
    }

    private final Point m_center;
    private final double m_height;
    private final double m_width;
}
