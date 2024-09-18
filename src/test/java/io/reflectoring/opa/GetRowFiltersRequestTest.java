package io.reflectoring.opa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reflectoring.opa.model.request.GetRowFiltersRequest;
import org.junit.jupiter.api.Test;

class GetRowFiltersRequestTest {

    @Test
    void getInput() throws JsonProcessingException {
        String jsonString = """
                {
                  "input": {
                    "context": {
                      "identity": {
                        "user": "admin",
                        "groups": []
                      },
                      "softwareStack": {
                        "trinoVersion": "453"
                      }
                    },
                    "action": {
                      "operation": "GetRowFilters",
                      "resource": {
                        "table": {
                          "catalogName": "ice",
                          "schemaName": "information_schema",
                          "tableName": "schemata"
                        }
                      }
                    }
                  }
                }
                                
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        GetRowFiltersRequest request = objectMapper.readValue(jsonString, GetRowFiltersRequest.class);

        // Print out some values to verify
        System.out.println("User: " + request.getInput().getContext().getIdentity().getUser());
        System.out.println("Operation: " + request.getInput().getAction().getOperation());
        System.out.println("Table Name: " + request.getInput().getAction().getResource().getTable().getTableName());

    }
}