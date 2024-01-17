package org.jesperancinha.smtd.carparts;

import org.jesperancinha.smtd.carparts.model.jpa.Part;

import java.lang.reflect.InvocationTargetException;

public class MarkedUtils {

    static Part getPartWithANullField() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return Part.class.getDeclaredConstructor().newInstance();
    }
}
