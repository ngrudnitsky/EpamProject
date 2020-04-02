package by.epam.nickgrudnitsky.mentoring.homework1.task4.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MetadataPrinter {
    private MetadataPrinter() {
    }

    public static String getMetadata(Class object) {
        String metadata = "";

        metadata += getClassMetadata(object);
        metadata += getFieldsMetadata(object);
        metadata += getMethodsMetadata(object);

        return metadata;
    }

    private static String getClassMetadata(Class object) {
        StringBuilder sb = new StringBuilder();

        int modifiers = object.getModifiers();
        sb.append(Modifier.toString(modifiers)).append(" ");
        sb.append("Class ").append(object.getName()).append("\n");
        return sb.toString();
    }

    private static String getFieldsMetadata(Class object) {
        StringBuilder sb = new StringBuilder();

        Field[] fields = object.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            sb.append(" ").append(Modifier.toString(modifiers)).append(" ");
            sb.append(field.getType().getName()).append(' ');
            sb.append(field.getName()).append('\n');
        }
        return sb.toString();
    }

    private static String getMethodsMetadata(Class object) {
        StringBuilder sb = new StringBuilder();

        Method[] declaredMethods = object.getDeclaredMethods();
        for (Method method : declaredMethods) {
            int modifiers = method.getModifiers();
            sb.append(" ").append(Modifier.toString(modifiers)).append(" ");
            sb.append(method.getReturnType().getName()).append(" ");
            sb.append(method.getName()).append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                sb.append(parameterTypes[i].getName());
                if (i < parameterTypes.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")\n");
        }
        return sb.toString();
    }
}
