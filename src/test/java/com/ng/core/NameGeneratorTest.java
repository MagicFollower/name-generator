package com.ng.core;

import org.junit.Assert;
import org.junit.Test;

public class NameGeneratorTest {

    @Test
    public void test01() {
        String[] s = NameGenerator.get().split(" ");
        Assert.assertTrue(Character.isUpperCase(s[0].charAt(0)) && Character.isUpperCase(s[1].charAt(0)));
    }

    @Test
    public void test02() {
        String[] s = NameGenerator.get(true).split(" ");
        Assert.assertTrue(Character.isUpperCase(s[0].charAt(0)) && Character.isUpperCase(s[1].charAt(0)));

        String[] _s = NameGenerator.get(false).split(" ");
        Assert.assertTrue(Character.isUpperCase(_s[0].charAt(0)) && Character.isUpperCase(_s[1].charAt(0)));
    }

    @Test
    public void test03() {
        String[] s = NameGenerator.get(true, NameGenerator.NameFormat.COMMON).split(" ");
        String[] s1 = NameGenerator.get(true, NameGenerator.NameFormat.LOWERCASE).split(" ");
        String[] s2 = NameGenerator.get(true, NameGenerator.NameFormat.UPPERCASE).split(" ");
        Assert.assertTrue(Character.isUpperCase(s[0].charAt(0)) && Character.isUpperCase(s[1].charAt(0)));
        Assert.assertTrue(s1[0].equals(s1[0].toLowerCase()) && s1[1].equals(s1[1].toLowerCase()));
        Assert.assertTrue(s2[0].equals(s2[0].toUpperCase()) && s2[1].equals(s2[1].toUpperCase()));

        String[] _s = NameGenerator.get(false, NameGenerator.NameFormat.COMMON).split(" ");
        String[] _s1 = NameGenerator.get(false, NameGenerator.NameFormat.LOWERCASE).split(" ");
        String[] _s2 = NameGenerator.get(false, NameGenerator.NameFormat.UPPERCASE).split(" ");
        Assert.assertTrue(Character.isUpperCase(_s[0].charAt(0)) && Character.isUpperCase(_s[1].charAt(0)));
        Assert.assertTrue(_s1[0].equals(_s1[0].toLowerCase()) && _s1[1].equals(_s1[1].toLowerCase()));
        Assert.assertTrue(_s2[0].equals(_s2[0].toUpperCase()) && _s2[1].equals(_s2[1].toUpperCase()));
    }
}
