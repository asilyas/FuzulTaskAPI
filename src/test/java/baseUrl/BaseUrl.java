package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class BaseUrl {

    public static RequestSpecification spec;

    public static void setup(){
        spec = new RequestSpecBuilder().
                setBaseUri(ConfigReader.getProperty("url")).
                setContentType(ContentType.JSON).
                build();


    }

}