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
 * {@link ElevenThrow} is a subclass of {@link Throw} for the number, 11. This is special because 11 has one effect on a come-out
 * roll and a different effect on point rolls.
 */
public class ElevenThrow extends Throw {

    /**
     * Creates this {@link Throw}. The constraint is that diceOne + diceTwo = 11. If the constraint is not satisfied, simply
     * raise an {@link Exception}.
     * <p>
     * This uses the superclass constructor to add appropriate {@link Outcome} for a {@link Throw} of 11.
     *
     * @param diceOne the value of one die
     * @param diceTwo the value of the other die
     */
    public ElevenThrow(int diceOne, int diceTwo) {
        this(diceOne, diceTwo, new Outcome[]{});
    }

    /**
     * Creates this {@link Throw}. The constraint is that diceOne + diceTwo = 11. If the constraint is not satisfied, simply
     * raise an {@link Exception}.
     * <p>
     * This uses the superclass constructor to add appropriate {@link Outcome} for a {@link Throw} of 11.
     *
     * @param diceOne  the value of one die
     * @param diceTwo  the value of the other die
     * @param outcomes the various {@link Outcome}s for this {@link Throw}
     */
    public ElevenThrow(int diceOne, int diceTwo, Outcome... outcomes) {
        this(diceOne, diceTwo, Arrays.asList(outcomes.clone()));
    }

    /**
     * Creates this {@link Throw}. The constraint is that diceOne + diceTwo = 11. If the constraint is not satisfied, simply
     * raise an {@link Exception}.
     * <p>
     * This uses the superclass constructor to add appropriate {@link Outcome} for a {@link Throw} of 11.
     *
     * @param diceOne  the value of one die
     * @param diceTwo  the value of the other die
     * @param outcomes the various {@link Outcome}s for this {@link Throw}
     */
    public ElevenThrow(int diceOne, int diceTwo, Collection<Outcome> outcomes) {
        super(diceOne, diceTwo, outcomes);

        if (diceOne + diceTwo != 11) {
            throw new IllegalArgumentException("In a eleven throw, dice one and two must sum to 11");
        }
    }

    /**
     * Eleven is odd and never part of “hardways” bets. This method always returns false.
     *
     * @return {@link Boolean#FALSE}
     */
    @Override
    public boolean isHard() {
        return false;
    }

    /**
     * Calls the {@link Game#eleven()} method of a {@link Game}. This may change the game state and resolve bets.
     *
     * @param game the {@link Game} to be updated based on this throw
     */
    @Override
    public void updateGame(Game game) {
        game.eleven();
    }
}
