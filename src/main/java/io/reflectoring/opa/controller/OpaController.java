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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/opa")
public class OpaController {

    @PostMapping("/allow")
    public ResponseEntity<AllowResponse> allow(AllowRequest allowRequest) {
        return ResponseEntity.ok(AllowResponse.allow());
    }


    @PostMapping("/getRowFilters")
    public ResponseEntity<GetRowFiltersResponse> getRowFilters(GetRowFiltersRequest getRowFiltersRequest) throws JsonProcessingException {

        // Get User group
        // Get Resource/Permission Mapping

        // 1. is admin , return all data , all = true
        // 2. get granted regions?   all ? all = true,  / all = false filter by granted region
        // 3. get granted sites?     all ?
        // 4. 1=2

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("GetRowFiltersRequest: " + objectMapper.writeValueAsString(getRowFiltersRequest));

        String jsonString = """
                {
                  "result": [
                    {
                      "expression": " site_id = 'LOH'"
                    }
                  ]
                }
                """;

        GetRowFiltersResponse response = objectMapper.readValue(jsonString, GetRowFiltersResponse.class);

        // Print out the expression to verify
        for (Result result : response.getResult()) {
            System.out.println("Expression: " + result.getExpression());
        }

        return ResponseEntity.ok(response);
    }
}
