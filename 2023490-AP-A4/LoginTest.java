import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest extends  Main {

    // Assume loginService is a service to handle login logic
//    var m = new Main();
    @Test
    public void testLoginWithCorrectUsername() {
        String username = "testUser";
        boolean isLoginSuccessful = checkLogin(username,1);
        assertTrue(isLoginSuccessful, "Login Succefull");
    }

    @Test
    public void testLoginWithIncorrectUsername() {
        String username = "incorrectUser";
        boolean isLoginSuccessful = checkLogin(username,1);

        assertFalse(isLoginSuccessful, "Login should fail with incorrect username");
    }
}
