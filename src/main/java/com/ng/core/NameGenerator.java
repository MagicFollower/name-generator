package com.ng.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * NameGenerator#get
 *
 * @author trivis
 */
public class NameGenerator {
    static final String femaleNameFile = "female.data";
    static final String maleNameFile = "male.data";
    static List<String> mWords, fWords;

    /**
     * Get random name with random sex.
     *
     * @return name like "Tomas Kiki"
     */
    public static String get() {
        return get(ThreadLocalRandom.current().nextBoolean());
    }

    /**
     * Get random name with specific sex
     *
     * @param female if you want to get a female name, set it true
     * @return name like "Tomas Kiki"
     */
    public static String get(boolean female) {
        return get(female, NameFormat.COMMON);
    }

    /**
     *
     * @param female if you want to get a female name, set it true
     * @param nameFormat three name-format, you can read {@link NameFormat}
     * @return one specific name
     */
    public static String get(boolean female, NameFormat nameFormat) {
        if (female && fWords == null) {
            synchronized (NameGenerator.class) {
                if (fWords == null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(NameGenerator.class
                            .getClassLoader().getResourceAsStream(femaleNameFile))));
                    fWords = br.lines().map(String::trim).collect(Collectors.toList());
                }
            }
        } else if (!female && mWords == null) {
            synchronized (NameGenerator.class) {
                if (mWords == null) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(NameGenerator.class
                            .getClassLoader().getResourceAsStream(maleNameFile))));
                    mWords = br.lines().map(String::trim).collect(Collectors.toList());
                }
            }
        }
        List<String> currentWords = female ? fWords : mWords;
        int[] ints = ThreadLocalRandom.current().ints(2, 0, currentWords.size()).distinct().toArray();
        String fullName = currentWords.get(ints[0]) + " " + currentWords.get(ints[1]);
        if (nameFormat.equals(NameFormat.LOWERCASE)) {
            fullName = fullName.toLowerCase();
        } else if (nameFormat.equals(NameFormat.UPPERCASE)) {
            fullName = fullName.toUpperCase();
        }
        return fullName;
    }

    /**
     * COMMON    ➡️ "Tomas Kiki"
     * LOWERCASE ➡️ "tomas kiki"
     * UPPERCASE ➡️ "TOMAS KIKI"
     */
    public enum NameFormat {
        COMMON, LOWERCASE, UPPERCASE
    }

}
