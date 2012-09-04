package jp.skypencil.findbugs.simple;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import static org.apache.bcel.Constants.DUP;
import static org.apache.bcel.Constants.NOP;

public class OriginalDetectorTest {
    @Test
    public void testNopIsNotBug() {
        assertThat(new OriginalDetector(null).isBug(NOP), is(false));
    }

    @Test
    public void testDupIsBug() {
        assertThat(new OriginalDetector(null).isBug(DUP), is(true));
    }
}