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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void craps() {
    }

    @Test
    public void natural() {
    }

    @Test
    public void eleven() {
    }

    @Test
    public void point() {
        Assert.assertEquals(0, game.point);
        game.point(1);
        Assert.assertEquals(1, game.point);
        game.point(2);
        Assert.assertEquals(1, game.point);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Point Off", game.toString());
        game.point = 1;
        Assert.assertEquals("1", game.toString());
    }
}