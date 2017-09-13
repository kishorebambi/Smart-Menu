package com.adapter.application.util;

import com.google.gson.Gson;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ResponseManager {
    public Response getJsonSuccessResponse(Object object) {
        return Response
                .status(200)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("utf-8"))
                .header("Server-version", 0.1)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .entity(object)
                .build();
    }
    
    public Response getJsonErrorResponse(String inError, Integer iniStatus) {
        return Response
                .status(iniStatus)
//                .status(errorResponse.getError().errorCode)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("utf-8"))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .entity(new Gson().toJson(inError)).build();
    }
}
