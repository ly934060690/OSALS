package edu.zut.cs.software.pro03;

public @interface BlackAnno {
    String name() default "Black Annotation!";
    int num() default 250;
}
