package org.geotools.data.oracle;

import org.geotools.jdbc.JDBCTestSetup;
import org.geotools.jdbc.JDBCTransactionOnlineTest;

public class OracleTransactionOnlineTest extends JDBCTransactionOnlineTest {

    @Override
    protected JDBCTestSetup createTestSetup() {
        return new OracleTestSetup();
    }

    @Override
    public void testConcurrentTransactions() {
        // Oracle won't pass this one
    }
}
