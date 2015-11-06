package org.ulco;

import java.io.IOException;
import java.lang.reflect.Constructor;

public class JSON {
    static public GraphicsObject parse(String json) {
        GraphicsObject o = null;
        String str = json.replaceAll("\\s+", "");
        String type = str.substring(str.indexOf("type") + 5, str.indexOf(","));

        // 1ere lettre en Majuscule
        String type2 = type.replaceFirst(".", (type.charAt(0) + "").toUpperCase());

        try {
           Class c = Class.forName("org.ulco."+type2);
           Constructor ct=  c.getConstructor(String.class);
          Object ob=  ct.newInstance(str);
            o = (GraphicsObject) ob;

        }catch(Exception e){
            e.printStackTrace();
        }

        return o;
    }

    static public Group parseGroup(String json) {
        return new Group(json);
    }

    static public Layer parseLayer(String json) {
        return new Layer(json);
    }

    static public Document parseDocument(String json) {
        return new Document(json);
    }
}
// Object = Class.forname(org.ulco.circle).newIntance();
//