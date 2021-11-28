import org.junit.Test;

import static io.restassured.RestAssured.given;

public class testGetCommand {

    @Test
    public void ValidateStatusCode(){
        given().
                when().
                get("https://api.bart.gov/api/etd.aspx?cmd=etd&orig=RICH&key=MW9S-E7SL-26DU-VV8V&json=y").
                then().
                assertThat().statusCode(200);

    }

}

