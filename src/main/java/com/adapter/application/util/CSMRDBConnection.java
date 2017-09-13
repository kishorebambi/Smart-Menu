package com.adapter.application.util;

import com.ibm.mfp.adapter.api.ConfigurationAPI;
import com.ibm.mfp.adapter.api.MFPJAXRSApplication;
import javax.ws.rs.core.Context;
import org.apache.commons.dbcp.BasicDataSource;

public class CSMRDBConnection extends MFPJAXRSApplication{
	public BasicDataSource dataSource = null;

	@Context
	ConfigurationAPI configurationAPI;

	@Override
	protected void init() throws Exception {		
		dataSource= new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(configurationAPI.getPropertyValue("DB_url"));
		dataSource.setUsername(configurationAPI.getPropertyValue("DB_username"));
		dataSource.setPassword(configurationAPI.getPropertyValue("DB_password"));
	}
        
}
