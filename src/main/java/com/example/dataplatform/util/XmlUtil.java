package com.example.dataplatform.util;

import com.example.dataplatform.model.Task;
import com.thoughtworks.xstream.XStream;

public class XmlUtil {
    public static Object toBean(Class<?> clazz, String xml) throws Exception {
        Object xmlObject = null;
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        XStream.setupDefaultSecurity(xstream);
        Class<?>[] classes = new Class[] { clazz };
        xstream.allowTypes(classes);
        xstream.autodetectAnnotations(true);
        xmlObject= xstream.fromXML(xml);
        return xmlObject;
    }
}