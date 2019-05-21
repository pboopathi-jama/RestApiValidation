import Util.JsonSchemaValidationUtil;
import Util.RestClientUtil;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import java.io.File;
import java.io.IOException;

import static api.OpenWeatherMap.OPEN_WEATHER_MAP_GET_WEATHER;

public class Main {

    private static final String OPEN_WEATHER_MAP_GET_WEATHER_SPEC = "/Users/pboopathi/Desktop/RestApiValidation/" + OPEN_WEATHER_MAP_GET_WEATHER + "OpenApiSpec.yaml";
    private static final String OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA = "/Users/pboopathi/Desktop/RestApiValidation/" + OPEN_WEATHER_MAP_GET_WEATHER + "_outputSchema.json";
    public static final String PROCESS_YAML_SCRIPT = "/Users/pboopathi/Desktop/RestApiValidation/processYaml.sh";
    public static final String OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API = OPEN_WEATHER_MAP_GET_WEATHER + "_responseFromApi.json";

    public static void main(String[] a) {
        System.out.println("Happy world");
        System.out.println(new File("").getAbsolutePath());
        String[] cmd = {PROCESS_YAML_SCRIPT, OPEN_WEATHER_MAP_GET_WEATHER_SPEC, OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA};
        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestClientUtil.writeOpenWeatherMapByCity(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API, "portland");

        File schemaFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_PROCESSED_JSON_SCHEMA);
        File jsonFile = new File(OPEN_WEATHER_MAP_GET_WEATHER_RESPONSE_FROM_API);

        try {
            if (JsonSchemaValidationUtil.isJsonValid(schemaFile, jsonFile)){
                System.out.println("Valid!");
            }else{
                System.out.println("NOT valid!");
            }

            JsonSchemaValidationUtil.validateJson(schemaFile, jsonFile);
        } catch (ProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
