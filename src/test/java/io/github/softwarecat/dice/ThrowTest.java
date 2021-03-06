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

import io.github.softwarecat.Game;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThrowTest {

    Game game;
    Throw diceThrow;
    String methodCalled;

    @Before
    public void setUp() {
        game = new Game() {
            @Override
            public void craps() {
                methodCalled = "craps";
            }

            @Override
            public void natural() {
                methodCalled = "natural";
            }

            @Override
            public void eleven() {
                methodCalled = "eleven";
            }

            @Override
            public void point(int point) {
                methodCalled = "point";
            }
        };
    }

    @Test
    public void isHard() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                Throw diceThrow = new Throw(i, j) {
                    @Override
                    public void updateGame(Game game) {
                    }
                };

                if (i == j) {
                    Assert.assertTrue(diceThrow.isHard());
                } else {
                    Assert.assertFalse(diceThrow.isHard());
                }
            }
        }
    }

    @Test
    public void testToString() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                Throw diceThrow = new Throw(i, j) {
                    @Override
                    public void updateGame(Game game) {
                    }
                };

                Assert.assertEquals(i + ", " + j, diceThrow.toString());
            }
        }
    }

    @Test
    public void getKey() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                Throw diceThrow = new Throw(i, j) {
                    @Override
                    public void updateGame(Game game) {
                    }
                };

                Assert.assertEquals(Pair.of(i, j), diceThrow.getKey());
            }
        }
    }
}