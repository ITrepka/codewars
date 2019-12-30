package exercises;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.reflect.Modifier.fieldModifiers;


public class BagelSolver {
    public static Bagel getBagel()  {
        try {
            setFinalStatic(Boolean.class.getField("TRUE"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Bagel();
    }

    private static void setFinalStatic(Field field, Object newValue) {
        field.setAccessible(true);
        try {
            Field fieldModifiers = Field.class.getDeclaredField("modifiers");
            fieldModifiers.setAccessible(true);
            fieldModifiers.setInt(field, fieldModifiers() & ~Modifier.FINAL);

            field.set(null, newValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

