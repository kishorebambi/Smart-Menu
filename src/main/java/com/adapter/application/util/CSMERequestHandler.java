package com.adapter.application.util;

import com.ibm.mfp.adapter.api.ConfigurationAPI;
import java.io.IOException;
import javax.ws.rs.core.Context;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;

public class CSMERequestHandler {
    
    @Context
    static ConfigurationAPI configurationAPI;

    public static ConfigurationAPI getConfigurationAPI() {
        return configurationAPI;
    }

    private static CloseableHttpClient client;
    private static CloseableHttpClient searchClient;
    private static HttpHost wcsHost;
    private static HttpHost searchHost;

    public static void initialize() throws IOException {
        
    }


    public HttpResponse execute(HttpUriRequest request)
            throws HttpHostConnectException, IOException, Exception {
        return client.execute(wcsHost, request);
    }

    public HttpResponse executeSearch(HttpUriRequest request)
            throws HttpHostConnectException, IOException, Exception {
        return searchClient.execute(searchHost, request);
    }
}
