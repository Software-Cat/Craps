/*
 * MIT License
 *
 * Copyright © 2021 Bowen Wu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.softwarecat;

import org.apache.commons.lang.math.Fraction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutcomeTest {

    Outcome outcome1;
    Outcome outcome2;
    Outcome outcome3;

    @Before
    public void setUp() {
        outcome1 = new Outcome("A", 1);
        outcome2 = new Outcome("B", 1, 2);
        outcome3 = new Outcome("C", Fraction.getFraction(2, 3));
    }

    @Test
    public void winAmount() {
        assertEquals(Fraction.getFraction(2), outcome1.winAmount(Fraction.getFraction(2)));
        assertEquals(Fraction.getFraction(1), outcome2.winAmount(Fraction.getFraction(2)));
        assertEquals(Fraction.getFraction(2), outcome3.winAmount(Fraction.getFraction(3)));
    }

    @Test
    public void testToString() {
        assertEquals("A (1:1)", outcome1.toString());
        assertEquals("B (1:2)", outcome2.toString());
        assertEquals("C (2:3)", outcome3.toString());
    }
}