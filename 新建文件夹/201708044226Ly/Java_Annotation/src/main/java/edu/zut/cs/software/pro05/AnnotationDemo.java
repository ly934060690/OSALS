package edu.zut.cs.software.pro05;

@ClassInfo(author = "Ygg",
        date = "2019-4-11 15:46:52",
        comments = "annotation demo")
public class AnnotationDemo {

    @FieldInfo(type = "pulic", name = "firstField")
    public int firstField;
    @FieldInfo(type = "private", name = "secondField")
    private String secondField;

    @MethodInfo(description = "method in AnnotationDemo", name = "firstMethod")
    public void firstMethod(String value) {
        System.out.println("first method involved");
    }
    @MethodInfo(description = "method in AnnotationDemo", name = "secondMethod")
    private void secondMethod() {
        System.out.println("second method involved");
    }
}
