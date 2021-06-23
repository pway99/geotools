/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2010, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.geojson.geom;

import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

public class LineHandler extends GeometryHandlerBase<LineString> {

    ArrayList<Coordinate> coordinates;

    public LineHandler(GeometryFactory factory) {
        super(factory);
    }

    @Override
    public boolean startObjectEntry(String key) {
        if ("coordinates".equals(key)) {
            coordinates = new ArrayList<>();
        }
        return true;
    }

    @Override
    public boolean endObject() {
        if (coordinates != null) {
            Coordinate[] cs = coordinates(coordinates);
            value = factory.createLineString(cs);
            coordinates = null;
        }
        return true;
    }

    @Override
    public boolean startArray() {
        if (ordinates == null) {
            ordinates = new ArrayList<>();
        }
        return true;
    }

    @Override
    public boolean endArray() throws ParseException {
        if (ordinates != null) {
            Coordinate c = coordinate(ordinates);
            coordinates.add(c);
            ordinates = null;
        }

        return true;
    }
}
