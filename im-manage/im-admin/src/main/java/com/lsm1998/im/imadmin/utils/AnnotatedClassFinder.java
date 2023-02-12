package com.lsm1998.im.imadmin.utils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class AnnotatedClassFinder
{
    @SafeVarargs
    public static List<Class<?>> findClasses(String packageName, Class<? extends Annotation>... annotations)
            throws ClassNotFoundException, IOException
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements())
        {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs)
        {
            classes.addAll(findClasses(directory, packageName, annotations));
        }
        return classes;
    }

    @SafeVarargs
    private static List<Class<?>> findClasses(File directory, String packageName, Class<? extends Annotation>... annotations)
            throws ClassNotFoundException
    {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists())
        {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files == null)
        {
            return classes;
        }
        for (File file : files)
        {
            if (file.isDirectory())
            {
                classes.addAll(findClasses(file, packageName + "." + file.getName(), annotations));
            } else if (file.getName().endsWith(".class"))
            {
                Class<?> clazz = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                for (Class<? extends Annotation> annotationType : annotations)
                {
                    if (clazz.getAnnotation(annotationType) != null)
                    {
                        classes.add(clazz);
                        break;
                    }
                }
            }
        }
        return classes;
    }
}
