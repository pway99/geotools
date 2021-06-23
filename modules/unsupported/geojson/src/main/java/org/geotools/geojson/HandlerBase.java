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
package org.geotools.geojson;

import org.json.simple.parser.ContentHandler;

public class HandlerBase implements ContentHandler {

    @Override
    public void startJSON() {}

    @Override
    public void endJSON() {}

    @Override
    public boolean startObject() {
        return true;
    }

    @Override
    public boolean endObject() {
        return true;
    }

    @Override
    public boolean startObjectEntry(String key) {
        return true;
    }

    @Override
    public boolean endObjectEntry() {
        return true;
    }

    @Override
    public boolean startArray() {
        return true;
    }

    @Override
    public boolean endArray() {
        return true;
    }

    @Override
    public boolean primitive(Object value) {
        return true;
    }
}
