package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.*;


public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));

        Method method = r.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(r));

    }
}
