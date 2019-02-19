package annotation.test;

import annotation.Nation;
import annotation.person.HanPerson;

import java.lang.reflect.Field;

/**
 * Created by wch on 18-8-16.
 */
public class TestClass {

    public static void main(String[] args) {
        HanPerson hanPerson = new HanPerson();

        Class<HanPerson> hanPersonClass = HanPerson.class;
        Field[] fields = hanPersonClass.getDeclaredFields();
        for (Field field : fields) {
            boolean annotationPresent = field.isAnnotationPresent(Nation.class);
            if (annotationPresent) {
                Nation annotation = field.getAnnotation(Nation.class);
                System.out.println(annotation.value());
            }
        }
    }
}
