/*
 Project					: Smart Menu
 File name					: CSMESmartMenuBaseApplication.java
 Author  					: Kishore Kumar S
 Details					: Base class for Smart Menu application
 */
package com.adapter.application;

import com.adapter.application.util.CSMERequestHandler;
import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.MFPJAXRSApplication;
import javax.ws.rs.core.Context;
import org.apache.commons.dbcp.BasicDataSource;

public class CSMESmartMenuBaseApplication extends MFPJAXRSApplication {

    @Context
    ConfigurationAPI configurationAPI;

    public BasicDataSource dataSource = null;

    @Override
    protected void init() throws Exception {
        //Initialize base method for application
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(configurationAPI.getPropertyValue("DB_url"));
        dataSource.setUsername(configurationAPI.getPropertyValue("DB_username"));
        dataSource.setPassword(configurationAPI.getPropertyValue("DB_password"));
        CSMERequestHandler.initialize();
    }

    @Override
    protected void destroy() throws Exception {
        //Code to be executed when adapter is destroyed
    }

    @Override
    protected String getPackageToScan() {
        //The package of this class will be scanned (recursively) to find JAX-RS resources.
        return getClass().getPackage().getName();
    }

}
