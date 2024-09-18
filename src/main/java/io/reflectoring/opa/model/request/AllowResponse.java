package io.reflectoring.opa.model.request;

public class AllowResponse {
    private boolean result;

    public static AllowResponse allow() {
        AllowResponse allowResponse = new AllowResponse();
        allowResponse.setResult(true);
        return allowResponse;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
