package com.shedid.phone.Common.Response;

import org.springframework.data.domain.Page;

import java.util.List;

public abstract class BaseResponse<T> {
    private int code;
    private String status;
    private String message;
    private List<T> data;
    private Page<T> dataPage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Page<T> getDataPage() {
        return dataPage;
    }

    public void setDataPage(Page<T> dataPage) {
        this.dataPage = dataPage;
    }
}
