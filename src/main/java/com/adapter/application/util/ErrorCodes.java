package com.adapter.application.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorCodes {
    public Integer errorCode;
    public String description;
    

    public ErrorCodes() {
    }

    
    /**
     *
     * @param errorCode
     * @param description
     */
    public ErrorCodes(Integer errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }   
}
