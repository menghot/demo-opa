package io.reflectoring.opa.model.request;

import io.reflectoring.opa.model.Result;

import java.util.List;

public class GetRowFiltersResponse {
    private List<Result> result;

    // Getters and Setters
    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}

