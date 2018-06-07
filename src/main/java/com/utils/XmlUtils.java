package com.utils;

import org.dom4j.Element;

import java.util.*;

public class XmlUtils {
    public static HashMap<String, Object> dom2Map(Element e) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<?> list = e.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Element iter = (Element) list.get(i);
                List<Object> mapList = new ArrayList<Object>();

                if (iter.elements().size() > 0) {

                    Map<String, Object> m = dom2Map(iter);

                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName()
                                .equals("java.util.ArrayList")) {
                            mapList = new ArrayList<Object>();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj instanceof ArrayList<?>) {
                            mapList = (List<Object>) obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), m);
                    }

                } else {
                    map.put(iter.getName(), iter.getText());
                }
            }
        } else {
            map.put(e.getName(), e.getText());
        }
        return map;
    }


    public static String getXMLString(Element element) {

        StringBuilder str = new StringBuilder();
        List records = element.elements();
        Iterator iterator = records.iterator();
        while (iterator.hasNext()) {
            Element next = (Element) iterator.next();
            String key = next.getName();
            String value = next.getTextTrim();
            str.append("<" + key + ">" + value + "</" + key + ">");
        }
        String res = str.toString();

        return res;
    }
}
