package ucb.edu.bo.testingapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TestingApiApplicationTests {

    @Test
    @DisplayName("Test get users from api - GET https://jsonplaceholder.typicode.com/users")
    void testGetUsersFromApiGet() {
        when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .body("username", hasItems("Bret", "Antonette", "Samantha", "Karianne",
                        "Kamren", "Leopoldo_Corkery", "Elwyn.Skiles", "Maxime_Nienow",
                        "Delphine", "Moriah.Stanton"));
    }

    @Test
    @DisplayName("Test post a new post - POST https://jsonplaceholder.typicode.com/posts")
    void testPostANewPostPost() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "foo");
        map.put("body", "bar");
        map.put("userId", 1);

        with()
                .body(map)
        .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .assertThat()
                .log().all();
    }


}
