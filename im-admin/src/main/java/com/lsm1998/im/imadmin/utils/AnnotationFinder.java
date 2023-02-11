package com.lsm1998.im.imadmin.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.Set;

public class AnnotationFinder
{
    @SafeVarargs
    public static Set<BeanDefinition> findRestControllers(String basePackage, Class<? extends Annotation>... annotations)
    {
        ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        for (Class<? extends Annotation> annotation : annotations)
        {
            provider.addIncludeFilter(new AnnotationTypeFilter(annotation));
        }
        return provider.findCandidateComponents(basePackage);
    }
}
