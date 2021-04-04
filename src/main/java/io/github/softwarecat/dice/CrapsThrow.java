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

/**
 * {@link CrapsThrow} is a subclass of {@link Throw} for the craps numbers 2, 3 and 12.
 */
public class CrapsThrow extends Throw {

    /**
     * Creates this {@link Throw}. The constraint is that diceOne + diceTwo == 2, 3, or 12. If the constraint is not satisfied, simply raise an
     * {@link Exception}.
     * <p>
     * This uses the superclass constructor to add appropriate {@link Outcome}s for a throw of craps.
     *
     * @param diceOne the value of one die
     * @param diceTwo the value of the other die
     */
    public CrapsThrow(int diceOne, int diceTwo) {
        this(diceOne, diceTwo, new Outcome[]{});
    }

    /**
     * Creates this {@link Throw}. The constraint is that diceOne + diceTwo == 2, 3, or 12. If the constraint is not satisfied, simply raise an
     * {@link Exception}.
     * <p>
     * This uses the superclass constructor to add appropriate {@link Outcome}s for a throw of craps.
     *
     * @param diceOne  the value of one die
     * @param diceTwo  the value of the other die
     * @param outcomes the various {@link Outcome}s for this {@link Throw}
     */
    public CrapsThrow(int diceOne, int diceTwo, Outcome... outcomes) {
        this(diceOne, diceTwo, Arrays.asList(outcomes.clone()));
    }

    /**
     * Creates this {@link Throw}. The constraint is that diceOne + diceTwo == 2, 3, or 12. If the constraint is not satisfied, simply raise an
     * {@link Exception}.
     * <p>
     * This uses the superclass constructor to add appropriate {@link Outcome}s for a throw of craps.
     *
     * @param diceOne  the value of one die
     * @param diceTwo  the value of the other die
     * @param outcomes the various {@link Outcome}s for this {@link Throw}
     */
    public CrapsThrow(int diceOne, int diceTwo, Collection<Outcome> outcomes) {
        super(diceOne, diceTwo, outcomes);

        int sum = diceOne + diceTwo;
        if (sum != 2 && sum != 3 && sum != 12) {
            throw new IllegalArgumentException("In a craps throw, dice one and two must sum to 2, 3, or 12");
        }
    }

    /**
     * The craps numbers are never part of “hardways” bets. This method always returns false.
     *
     * @return {@link Boolean#FALSE}
     */
    @Override
    public boolean isHard() {
        return false;
    }

    /**
     * Calls the {@link Game#craps()} method of a {@link Game}. This may change the game state and resolve bets.
     *
     * @param game the {@link Game} to be updated based on this throw
     */
    @Override
    public void updateGame(Game game) {
        game.craps();
    }
}
