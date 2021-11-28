import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testForColour {
    @Test
    public void testGetStationDataOn15thAprilAndValidateResponseBody(){
        given().
                when().
                get("https://api.bart.gov/api/route.aspx?cmd=routes&key=MW9S-E7SL-26DU-VV8V&date=04/15/2021&json=y").
                then().
                assertThat().
                body("root.routes.route[0].name", equalTo("Oakland Airport to Coliseum")).
                body("root.routes.route.routeID", hasItem("ROUTE 20")).
                body("root.routes.route.routeID", not(hasItem("ROUTE 0"))).
                body("root.routes.route.number", hasSize(12));
    }
    @Test
    public void TestColour(){
        given().
                when().get("https://api.bart.gov/api/route.aspx?cmd=routes&key=MW9S-E7SL-26DU-VV8V&json=y").
                then().assertThat().assertThat().body("root.routes.route[0].color",equalTo("BEIGE"));




    }
}
