package APIAssignmentSwagger;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TestUserSwagger {


    @Test
    public void createSingleUser(){

        CreateUserRequest request = new CreateUserRequest();
        CreateUserResponse response = new CreateUserResponse();
        request.setId(01);
        request.setUsername("User1");
        request.setFirstName("Johns");
        request.setLastName("Peter");
        request.setEmail("JP1@test.com");
        request.setPassword("1234$$");
        request.setPhone("1234567890");
        request.setUserStatus(0);


        CreateUserResponse user1 =
                given().
                        contentType(ContentType.JSON).body(request).
                        when().
                        post("https://petstore.swagger.io/v2/user").as(
                                CreateUserResponse.class);
        user1.printResponseBody();
        Assert.assertEquals(200,user1.getCode());
    }

    @Test
    public void createMultipleUsers(){
        ArrayList<CreateUserRequest> multipleUsers = new ArrayList<CreateUserRequest>();

        CreateUserRequest request1 = new CreateUserRequest();
        request1.setId(04);
        request1.setUsername("User4");
        request1.setFirstName("Firstname4");
        request1.setLastName("lastname4");
        request1.setEmail("test2@test.com");
        request1.setPassword("password1");
        request1.setPhone("1234567");
        request1.setUserStatus(2);
        multipleUsers.add(request1);


        CreateUserRequest request2 = new CreateUserRequest();
        request2.setId(05);
        request2.setUsername("User5");
        request2.setFirstName("Firstname5");
        request2.setLastName("Lastname5");
        request2.setEmail("test2@test.com");
        request2.setPassword("password2");
        request2.setPhone("123455789");
        request2.setUserStatus(3);
        multipleUsers.add(request2);

        CreateUserResponse users =
                given().
                        contentType(ContentType.JSON).body(multipleUsers).log().body().
                        when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").as(CreateUserResponse.class);
        users.printResponseBody();
        Assert.assertEquals(200,users.getCode());
    }
}




