package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class ResponseFitmentTag {

    /**
     * error : 0
     * message : ok
     * data : ["暖气"]
     */

    private int error;
    private String message;
    private List<String> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
