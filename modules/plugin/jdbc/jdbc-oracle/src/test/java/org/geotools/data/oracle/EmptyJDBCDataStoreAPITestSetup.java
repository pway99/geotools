package org.geotools.data.oracle;

import org.geotools.jdbc.JDBCDataStoreAPITestSetup;
import org.geotools.jdbc.JDBCTestSetup;

@SuppressWarnings("PMD.JUnit4TestShouldUseTestAnnotation") // not yet a JUnit4 test
public class EmptyJDBCDataStoreAPITestSetup extends JDBCDataStoreAPITestSetup {

    protected EmptyJDBCDataStoreAPITestSetup(JDBCTestSetup delegate) {
        super(delegate);
    }

    @Override
    protected void dropRoadTable() {}

    @Override
    protected void dropRiverTable() {}

    @Override
    protected void dropLakeTable() {}

    @Override
    protected void dropBuildingTable() {}

    @Override
    protected void createRoadTable() {}

    @Override
    protected void createRiverTable() {}

    @Override
    protected void createLakeTable() {}
}
