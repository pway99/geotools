/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
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
package org.geotools.xsd.impl;

import org.picocontainer.MutablePicoContainer;

public abstract class HandlerImpl implements Handler {
    MutablePicoContainer context;

    @Override
    public MutablePicoContainer getContext() {
        return context;
    }

    @Override
    public void setContext(MutablePicoContainer context) {
        this.context = context;
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {}

    @Override
    public void endPrefixMapping(String prefix) {}
}
