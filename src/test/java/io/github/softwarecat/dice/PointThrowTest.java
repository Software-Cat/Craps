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

package io.github.softwarecat.dice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PointThrowTest extends ThrowTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        diceThrow = new PointThrow(2, 2);
    }

    @Override
    @Test
    public void isHard() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                Throw diceThrow;
                try {
                    diceThrow = new PointThrow(i, j);

                    if (i == j) {
                        Assert.assertTrue(diceThrow.isHard());
                    } else {
                        Assert.assertFalse(diceThrow.isHard());
                    }
                } catch (Exception ignored) {
                    // Expected behaviour, should not allow creation of illegal throws
                }
            }
        }
    }

    @Test
    public void updateGame() {
        diceThrow.updateGame(game);
        Assert.assertEquals("point", methodCalled);
    }
}