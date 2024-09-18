package io.reflectoring.opa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reflectoring.opa.model.request.AllowRequest;
import io.reflectoring.opa.model.request.AllowResponse;
import io.reflectoring.opa.model.request.GetRowFiltersRequest;
import io.reflectoring.opa.model.request.GetRowFiltersResponse;
import io.reflectoring.opa.model.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/opa")
public class OpaController {

    @PostMapping("/allow")
    public ResponseEntity<AllowResponse> allow(@RequestBody  AllowRequest allowRequest) {
        return ResponseEntity.ok(AllowResponse.allow());
    }

    @PostMapping("/getRowFilters")
    public ResponseEntity<GetRowFiltersResponse> getRowFilters(@RequestBody  GetRowFiltersRequest getRowFiltersRequest) throws JsonProcessingException {

        // Get User group
        // Get Resource/Permission Mapping

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("GetRowFiltersRequest: " + objectMapper.writeValueAsString(getRowFiltersRequest));

        String jsonString = """
                {
                  "result": [
                    {
                      "expression": " mktsegment = 'MACHINERY'"
                    }
                  ]
                }
                """;

        if (getRowFiltersRequest.getInput().getAction().getResource().getTable().getTableName().equals("customer")) {
            GetRowFiltersResponse response = objectMapper.readValue(jsonString, GetRowFiltersResponse.class);
            // Print out the expression to verify
            for (Result result : response.getResult()) {
                System.out.println("Expression: " + result.getExpression());
            }
            return ResponseEntity.ok(response);
        }


        return ResponseEntity.ok(new GetRowFiltersResponse());
    }
}
