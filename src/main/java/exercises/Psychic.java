package exercises;

import java.lang.reflect.Field;
import java.util.Random;

public class Psychic {
    private static final long SEED = System.nanoTime();

    public static double guess() {
        setSeed();
        return new Random(SEED).nextDouble();
    }

    private static void setSeed() {
        try {
            Class<?> clazz = Class.forName("java.lang.Math$RandomNumberGeneratorHolder");
            Field randomNumberGenerator = clazz.getDeclaredField("randomNumberGenerator");
            randomNumberGenerator.setAccessible(true);
            Random random = (Random) randomNumberGenerator.get(null);
            random.setSeed(SEED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}