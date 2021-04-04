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

/**
 * {@link Game} is a preliminary design for the game of Craps. This initial design contains the interface used by
 * the {@link io.github.softwarecat.dice.Throw} class hierarchy to implement game state changes.
 */
public class Game {

    /**
     * The current point. This will be replaced by a proper State design pattern.
     */
    protected int point = 0;

    /**
     * Creates this {@link Game}. This will be replaced by a constructor that uses Dice and CrapsTable.
     */
    public Game() {
    }

    /**
     * Resolves all current 1-roll bets.
     * If the point is zero, this was a come out roll: Pass Line bets are an immediate loss, Don’t Pass
     * Line bets are an immediate win.
     * If the point is non-zero, Come Line bets are an immediate loss; Don’t Come Line bets are an
     * immediate win.
     * The state doesn’t change.
     * A future version will delegate responsibility to the craps() method of a current state object.
     */
    public void craps() {

    }

    /**
     * Resolves all current 1-roll bets.
     * If the point is zero, this was a come out roll: Pass Line bets are an immediate win; Don’t Pass
     * Line bets are an immediate loss.
     * If the point is non-zero, Come Line bets are an immediate win; Don’t Come bets are an immediate
     * loss; the point is also reset to zero because the game is over.
     * Also, hardways bets are all losses.
     * A future version will delegate responsibility to the natural() method of a current state object.
     */
    public void natural() {

    }

    /**
     * Resolves all current 1-roll bets.
     * If the point is zero, this is a come out roll: Pass Line bets are an immediate win; Don’t Pass Line
     * bets are an immediate loss.
     * If the point is non-zero, Come Line bets are an immediate win; Don’t Come bets are an immediate
     * loss.
     * The game state doesn’t change.
     * A future version will delegate responsibility to the eleven() method of a current state object.
     */
    public void eleven() {

    }

    /**
     * Resolves all current 1-roll bets.
     * If the point was zero, this is a come out roll, and the value of the dice establishes the point.
     * If the point was non-zero and this throw matches the point the game is over: Pass Line bets and
     * associated odds bets are winners; Don’t Pass bets and associated odds bets are losers; the point
     * is reset to zero.
     * Finally, if the point is non-zero and this throw does not match the point, the state doesn’t change;
     * however, Come point and Don’t come point bets may be resolved. Additionally, hardways bets
     * may be resolved.
     * A future version will delegate responsibility to the current state’s point() method to advance
     * the game state.
     *
     * @param point the point value to set
     */
    public void point(int point) {
        if (this.point == 0) {
            this.point = point;
        }
    }

    /**
     * An easy-to-read String output method is also very handy. This should return a String representation
     * of the current state. The stub version of this class has no internal state object. This
     * class can simply return a string representation of the point; and the string "Point Off" when
     * point is zero.
     *
     * @return a String representation of the current state
     */
    @Override
    public String toString() {
        if (this.point == 0) {
            return "Point Off";
        } else {
            return Integer.toString(point);
        }
    }
}
