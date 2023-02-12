package com.lsm1998.im;

import com.lsm1998.im.imadmin.utils.AnnotatedClassFinder;
import com.lsm1998.im.imadmin.utils.AnnotationFinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

public class AnnotationFinderTests
{
    @Test
    void findRestControllers()
    {
        Set<BeanDefinition> set = AnnotationFinder.findRestControllers("com.lsm1998.im", RestController.class);
        set.forEach(e ->
        {
            System.out.println(e.getBeanClassName());
        });
    }

    @Test
    void annotatedClassFinder() throws Exception
    {
        List<Class<?>> list = AnnotatedClassFinder.findClasses("com.lsm1998.im", RestController.class, Controller.class);
        list.forEach(System.out::println);
    }
}
