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

import org.apache.commons.lang3.math.Fraction;

/**
 * Outcome contains a single outcome on which a bet can be placed.
 */
public class Outcome {

    /**
     * Holds the name of the Outcome. Examples include "1", "Red", "Pass Line".
     */
    protected String name;

    /**
     * Holds the fractional odds for this Outcome. This is the multiplier for the win amount.
     */
    protected Fraction odds;

    /**
     * Sets the name and odds from the parameters.
     * The denominator will be 1.
     *
     * @param name the name of this outcome
     * @param odds the payout odds numerator
     */
    public Outcome(String name, int odds) {
        this(name, odds, 1);
    }

    /**
     * Sets the name and odds from the parameters. This method will create an appropriate {@link Fraction} from the given
     * values.
     *
     * @param name        the name of this outcome
     * @param numerator   the payout odds numerator
     * @param denominator the payout odds denominator
     */
    public Outcome(String name, int numerator, int denominator) {
        this(name, Fraction.getFraction(numerator, denominator));
    }

    /**
     * Sets the name and odds from the parameters.
     *
     * @param name the name of this outcome
     * @param odds the payout odds as a fraction
     */
    public Outcome(String name, Fraction odds) {
        this.name = name;
        this.odds = odds;
    }

    /**
     * Returns the product of this {@link Outcome}‘s odds by the given amount.
     *
     * @param amount amount of the bet
     * @return the amount won
     */
    Fraction winAmount(Fraction amount) {
        return odds.multiplyBy(amount);
    }

    /**
     * Returns the product of this {@link Outcome}‘s odds by the given amount.
     *
     * @param amount amount of the bet
     * @return the amount won
     */
    Fraction winAmount(int amount) {
        return odds.multiplyBy(Fraction.getFraction(amount));
    }

    /**
     * An easy-to-read String output method is also very handy. This should return a String representation of the name
     * and the odds. A form that looks like 1-2 Split (17:1) is the goal.
     *
     * @return string representation of the {@link Outcome}
     */
    @Override
    public String toString() {
        return String.format("%s (%d:%d)", name, odds.getNumerator(), odds.getDenominator());
    }
}
