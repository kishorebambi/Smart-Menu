package com.adapter.application.util;

import com.adapter.application.CSMESmartMenuBaseApplication;
import com.ibm.mfp.adapter.api.AdaptersAPI;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ws.rs.core.Context;

public class CSMRDatabaseConnectionDAO{
    
    @Context
    AdaptersAPI adaptersAPI;
    
    public Connection getSQLConnection() throws SQLException{
            // Create a connection object to the database
         CSMESmartMenuBaseApplication app = adaptersAPI.getJaxRsApplication(CSMESmartMenuBaseApplication.class);
         return app.dataSource.getConnection();
    }
        
    public void closeSQLConnection(Connection inCon) throws SQLException{
            // Create a connection object to the database
        if(inCon!=null)
            inCon.close();
    }
    
}
