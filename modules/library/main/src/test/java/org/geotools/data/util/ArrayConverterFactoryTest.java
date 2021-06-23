/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2020, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.geotools.util.Converter;
import org.geotools.util.factory.Hints;
import org.junit.Before;
import org.junit.Test;

public class ArrayConverterFactoryTest {
    ArrayConverterFactory factory;

    @Before
    public void setUp() {
        factory = new ArrayConverterFactory();
    }

    @Test
    public void testArrayToSingle() {
        String[] array = {"text"};
        Converter converter = factory.createConverter(array.getClass(), String.class, new Hints());
        assertEquals("text", converter.convert(array, String.class));
    }

    @Test
    public void testArrayToSingleWrongType() {
        String[] array = {"text"};
        Converter converter = factory.createConverter(array.getClass(), Integer.class, new Hints());
        assertNull(converter);
    }

    @Test
    public void testArrayToSingleTooManyElements() {
        String[] array = {"text1", "text2"};
        Converter converter = factory.createConverter(array.getClass(), String.class, new Hints());
        assertNull(converter.convert(array, String.class));
    }

    @Test
    public void testSingleToArray() {
        String single = "text";
        Converter converter =
                factory.createConverter(single.getClass(), String[].class, new Hints());
        assertEquals(1, converter.convert(single, String[].class).length);
        assertEquals("text", converter.convert(single, String[].class)[0]);
    }

    @Test
    public void testSingleToArrayWrongType() {
        String single = "1";
        Converter converter =
                factory.createConverter(single.getClass(), Integer[].class, new Hints());
        assertNull(converter);
    }

    @Test
    public void testArrayToArray() {
        String[] array = {"1", "2", "3"};
        Converter converter =
                factory.createConverter(array.getClass(), Integer[].class, new Hints());
        Integer[] converted = converter.convert(array, Integer[].class);
        assertEquals(3, converted.length);
        assertEquals((Integer) 1, converted[0]);
        assertEquals((Integer) 2, converted[1]);
        assertEquals((Integer) 3, converted[2]);
    }

    @Test
    public void testArrayToArrayWithNulls() {
        String[] array = {"1", "2", null, "3"};
        Converter converter =
                factory.createConverter(array.getClass(), Integer[].class, new Hints());
        Integer[] converted = converter.convert(array, Integer[].class);
        assertEquals(4, converted.length);
        assertEquals((Integer) 1, converted[0]);
        assertEquals((Integer) 2, converted[1]);
        assertNull(converted[2]);
        assertEquals((Integer) 3, converted[3]);
    }

    @Test
    public void testArrayToArrayWithConversionErrors() {
        String[] array = {"1", "2", "a", "3"};
        Converter converter =
                factory.createConverter(array.getClass(), Integer[].class, new Hints());
        Integer[] converted = converter.convert(array, Integer[].class);
        assertNull(converted);
    }

    @Test
    public void testArrayToArrayPrimitive() {
        String[] array = {"1", "2", "3"};
        Converter converter =
                factory.createConverter(array.getClass(), Integer[].class, new Hints());
        int[] converted = converter.convert(array, int[].class);
        assertEquals(3, converted.length);
        assertEquals(1, converted[0]);
        assertEquals(2, converted[1]);
        assertEquals(3, converted[2]);
    }
}
