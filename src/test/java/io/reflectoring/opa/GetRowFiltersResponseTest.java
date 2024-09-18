package io.reflectoring.opa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reflectoring.opa.model.request.GetRowFiltersResponse;
import io.reflectoring.opa.model.Result;
import org.junit.jupiter.api.Test;

class GetRowFiltersResponseTest {

    @Test
    void getResult() throws JsonProcessingException {

        String jsonString = """
                {
                  "result": [
                    {
                      "expression": " mktsegment = 'MACHINERY'"
                    }
                  ]
                }
                """;


        ObjectMapper objectMapper = new ObjectMapper();
        GetRowFiltersResponse response = objectMapper.readValue(jsonString, GetRowFiltersResponse.class);

        // Print out the expression to verify
        for (Result result : response.getResult()) {
            System.out.println("Expression: " + result.getExpression());
        }
    }
}