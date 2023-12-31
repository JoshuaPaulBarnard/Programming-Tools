/*
 * The MIT License
 *
 * Copyright 2015 Harri Pellikka.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.manabreak.libclicker;

import org.junit.Test;

import eu.manabreak.libclicker.generators.Generator;

import static org.junit.Assert.assertEquals;

public class AutomatorTest {
    @Test
    public void testUpdate() {
        World world = new World();

        System.out.println("update()");
        Currency c = new Currency.Builder(world)
                .build();
        Generator g = new Generator.Builder(world)
                .generate(c)
                .build();
        g.upgrade();

        Automator a = new Automator.Builder(world)
                .automate(g)
                .every(1.0)
                .build();
        a.upgrade();

        world.update(1.0);
        assertEquals(1, g.getTimesProcessed());

        world.update(9.0);
        assertEquals(10, g.getTimesProcessed());
    }

}
