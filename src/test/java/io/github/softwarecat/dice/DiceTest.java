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
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceTest {

    Dice dice;

    Random rng;

    Throw naturalThrow;
    Throw crapsThrow;
    Throw pointThrow;
    Throw elevenThrow;

    @Before
    public void setUp() {
        rng = Mockito.mock(Random.class);

        dice = new Dice(rng);

        naturalThrow = new NaturalThrow(1, 6);
        crapsThrow = new CrapsThrow(6, 6);
        elevenThrow = new ElevenThrow(5, 6);
        pointThrow = new PointThrow(2, 2);
    }

    @Test
    public void getThrow() {
        dice.addThrow(naturalThrow);

        Assert.assertEquals(naturalThrow, dice.getThrow(1, 6));
        Assert.assertEquals(naturalThrow, dice.getThrow(naturalThrow.getKey()));
    }

    @Test
    public void addThrow() {
        dice.addThrow(naturalThrow);
        dice.addThrow(crapsThrow);
        dice.addThrow(pointThrow);
        dice.addThrow(elevenThrow);

        Assert.assertEquals(naturalThrow, dice.getThrow(1, 6));
        Assert.assertEquals(crapsThrow, dice.getThrow(6, 6));
        Assert.assertEquals(elevenThrow, dice.getThrow(5, 6));
        Assert.assertEquals(pointThrow, dice.getThrow(2, 2));
    }

    @Test
    public void next() {
        dice.addThrow(naturalThrow);
        dice.addThrow(crapsThrow);
        dice.addThrow(pointThrow);
        dice.addThrow(elevenThrow);
        List<Throw> diceThrows = new ArrayList<>(dice.THROWS.values());

        Mockito.when(rng.nextInt(4)).thenReturn(0);
        Assert.assertEquals(diceThrows.get(0), dice.next());

        Mockito.when(rng.nextInt(4)).thenReturn(1);
        Assert.assertEquals(diceThrows.get(1), dice.next());

        Mockito.when(rng.nextInt(4)).thenReturn(2);
        Assert.assertEquals(diceThrows.get(2), dice.next());

        Mockito.when(rng.nextInt(4)).thenReturn(3);
        Assert.assertEquals(diceThrows.get(3), dice.next());
    }
}