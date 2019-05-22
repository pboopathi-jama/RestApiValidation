# RestApiValidation
Project to validate rest api response in json with open api specification in yaml

Note: Current proof of concept is done for Open Weather Map api by specifying open api specification for current weather data using city query param and validating the response with the spec. This project could be extended to validate any open api spec with any json for validation.

This project is implemented in 3 step process:
1. Given Open Api Specification in yaml is coverted to json schema using [OpenAPI2Schema CLI](https://www.npmjs.com/package/openapi2schema)
2. Create Rest Client (JAX-RS clieng using Jersey) to get fresh copy of json response for specific call
3. Validate json schema created in step 1 and rest api response in step 2 using [json-schema-validator](https://github.com/java-json-tools/json-schema-validator)
