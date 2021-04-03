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
import io.github.softwarecat.Outcome;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link Throw} is the superclass for the various throws of the dice. Each subclass is a different grouping of the numbers, based
 * on the rules for Craps.
 */
public abstract class Throw {

    /**
     * A {@link Set} of one-roll Outcomes that win with this throw.
     */
    public final Set<Outcome> outcomes;

    /**
     * One of the two die values, from 1 to 6.
     */
    public int diceOne;

    /**
     * The other of the two die values, from 1 to 6.
     */
    public int diceTwo;

    /**
     * Creates this {@link Throw}, {@link Outcome}s can be added later.
     *
     * @param diceOne the value of one die
     * @param diceTwo the value of the other die
     */
    public Throw(int diceOne, int diceTwo) {
        this(diceOne, diceTwo, new Outcome[]{});
    }

    /**
     * Creates this {@link Throw}, and associates the given Stream of {@link Outcome}s that are winning propositions.
     *
     * @param diceOne  the value of one die
     * @param diceTwo  the value of the other die
     * @param outcomes the various {@link Outcome}s for this {@link Throw}
     */
    public Throw(int diceOne, int diceTwo, Outcome... outcomes) {
        this(diceOne, diceTwo, Arrays.asList(outcomes.clone()));
    }

    /**
     * Creates this {@link Throw}, and associates the given {@link Collection} of {@link Outcome}s that are winning propositions.
     *
     * @param diceOne  the value of one die
     * @param diceTwo  the value of the other die
     * @param outcomes the various {@link Outcome}s for this {@link Throw}
     */
    public Throw(int diceOne, int diceTwo, Collection<Outcome> outcomes) {
        this.diceOne = diceOne;
        this.diceTwo = diceTwo;
        this.outcomes = new HashSet<>(outcomes);
    }

    /**
     * Returns true if diceOne is equal to diceTwo. This helps determine if hardways bets have been won or lost.
     *
     * @return true if diceOne is equal to diceTwo
     */
    public boolean isHard() {
        return diceOne == diceTwo;
    }

    /**
     * Calls one of the {@link Game} state change methods: {@link Game#craps()}, {@link Game#natural()}, {@link Game#eleven()}, {@link Game#point(int)}. This may
     * change the game state and resolve bets.
     *
     * @param game the {@link Game} to be updated based on this throw
     */
    public abstract void updateGame(Game game);

    /**
     * An easy-to-read {@link String} output method is also very handy. This should return a {@link String} representation of the
     * dice. A form that looks like "1,2" works nicely.
     *
     * @return a {@link String} representation of the dice
     */
    @Override
    public String toString() {
        return String.format("%d, %d", diceOne, diceTwo);
    }
}
