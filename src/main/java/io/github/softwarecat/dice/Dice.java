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


import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * {@link Dice} contains the 36 individual throws of two dice, plus a random number generator. It can select a {@link Throw}
 * at random, simulating a throw of the Craps dice.
 */
public class Dice {

    /**
     * Generates the next random number, used to select a {@link Throw} from the {@link Dice#THROWS} collection.
     */
    protected final Random RNG;
    /**
     * This is a {@link Map} that associates a {@link Pair} with a {@link Throw}.
     */
    protected final Map<Pair<Integer, Integer>, Throw> THROWS;

    /**
     * Creates a new random number generator instance, and calls the other constructor.
     */
    public Dice() {
        this(new Random());
    }

    /**
     * Build the mapping of Throw instances.
     *
     * @param rng the random number generator to use
     */
    public Dice(Random rng) {
        RNG = rng;
        THROWS = new HashMap<>();
    }

    /**
     * While not needed by the application, unit tests may need a method to return a specific {@link Throw}
     * rather than a randomly selected {@link Throw}.
     * <p>
     * This method takes a particular combination of dice, locates (or creates) a {@link Pair}, and
     * returns the appropriate {@link Throw}.
     *
     * @param diceOne the value of one die
     * @param diceTwo the value of the other die
     * @return the {@link Throw}
     */
    public Throw getThrow(int diceOne, int diceTwo) {
        return THROWS.get(Pair.of(diceOne, diceTwo));
    }

    /**
     * While not needed by the application, unit tests may need a method to return a specific {@link Throw}
     * rather than a randomly selected {@link Throw}.
     * <p>
     * This method takes a particular combination of dice, represented by a {@link Pair}, and
     * returns the appropriate {@link Throw}.
     *
     * @param key the key
     * @return the throw
     */
    public Throw getThrow(Pair<Integer, Integer> key) {
        return THROWS.get(key);
    }

    /**
     * Adds the given {@link Throw} to the mapping maintained by this instance of {@link Dice}. The key for this
     * {@link Throw} is available from the {@link Throw#getKey()} method.
     *
     * @param diceThrow the {@link Throw} to add
     */
    public void addThrow(Throw diceThrow) {
        THROWS.put(diceThrow.getKey(), diceThrow);
    }

    /**
     * Returns a randomly selected {@link Throw}.
     *
     * @return the randomly selected {@link Throw}
     */
    public Throw next() {
        List<Pair<Integer, Integer>> keys = new ArrayList<>(THROWS.keySet());
        int index = RNG.nextInt(keys.size());
        return THROWS.get(keys.get(index));
    }
}
