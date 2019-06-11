package client;

import Util.JsonSchemaValidationUtil;
import Util.RestClientUtil;
import Util.ShellIUtil;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static api.OpenWeatherMap.OPEN_WEATHER_MAP_GET_WEATHER;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenWeatherMapTest {

    public static final String DIR = "/Users/pboopathi/Desktop/RestApiValidation/";
    private static final String OPEN_WEATHER_MAP_GET_WEATHER_SPEC = DIR + OPEN_WEATHER_MAP_GET_WEATHER + "OpenApiSpec.yaml";
    private static final String OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA = DIR + OPEN_WEATHER_MAP_GET_WEATHER + "_outputSchema.json";
    public static final String PROCESS_YAML_SCRIPT = DIR + "processYaml.sh";
    public static final String OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API = OPEN_WEATHER_MAP_GET_WEATHER + "_responseFromApi.json";

    @Test
    public void validateOpenWeatherApiGetWeatherTest()
    {
        //converting yaml file to jsonschema
        ShellIUtil.runCommandWithTwoParam(PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);

        //Hit openweatheMap public API using rest client and write that to a output file using objectmapper in jackson library
        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "portland");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        //Using json-schema-validator library validating jsonschema(Specification) and jsonresponse(Response from API)
        try {

            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
          assertThat(JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile), is(true));
        } catch (ProcessingException e) {
            e.printStackTrace();
            fail("ProcessingException");
        } catch (IOException e) {
            e.printStackTrace();
            fail("ProcessingException");
        }
    }


    @Test
    public void validateOpenWeatherApiGetWeatherTestForSanJose()
    {
        ShellIUtil.runCommandWithTwoParam(PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "san jose");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        //Comparison of two json files
        try {
            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
            assertThat(JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile), is(true));
        } catch (ProcessingException e) {
            e.printStackTrace();
            fail("ProcessingException");
        } catch (IOException e) {
            e.printStackTrace();
            fail("ProcessingException");
        }
    }


    @Test
    public void validateOpenWeatherApiGetWeatherTestForDallas()
    {
        ShellIUtil.runCommandWithTwoParam(PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "dallas");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        //Comparison of two json files
        try {
            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
            assertThat(JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile), is(true));
        } catch (ProcessingException e) {
            e.printStackTrace();
            fail("ProcessingException");
        } catch (IOException e) {
            e.printStackTrace();
            fail("ProcessingException");
        }
    }


    @Test
    public void validateOpenWeatherApiGetWeatherTestForAustin()
    {
        ShellIUtil.runCommandWithTwoParam(PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "austin");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        //Comparison of two json files
        try {
            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
            assertThat(JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile), is(true));
        } catch (ProcessingException e) {
            e.printStackTrace();
            fail("ProcessingException");
        } catch (IOException e) {
            e.printStackTrace();
            fail("ProcessingException");
        }
    }
    @Test
    public void validateOpenWeatherApiGetWeatherTestForHouston()
    {
        ShellIUtil.runCommandWithTwoParam(PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "Houston");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        //Comparison of two json files
        try {
            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
            assertThat(JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile), is(true));
        } catch (ProcessingException e) {
            e.printStackTrace();
            fail("ProcessingException");
        } catch (IOException e) {
            e.printStackTrace();
            fail("ProcessingException");
        }
    }


    @Test
    public void validateOpenWeatherApiGetWeatherTestForRedRiver()
    {
        ShellIUtil.runCommandWithTwoParam(PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "Red River");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        //Comparison of two json files
        try {
            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
            assertThat(JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile), is(true));
        } catch (ProcessingException e) {
            e.printStackTrace();
            fail("ProcessingException");
        } catch (IOException e) {
            e.printStackTrace();
            fail("ProcessingException");
        }
    }

}
//be89a2b8fe4c119e386b348dda4c250c