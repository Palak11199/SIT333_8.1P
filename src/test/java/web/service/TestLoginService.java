package web.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoginService {

    @Test
    public void testValidLogin() {

        Assertions.assertTrue(
                LoginService.login(
                        "palak",
                        "palak_pass",
                        "1990-01-01"
                )
        );
    }

    @Test
    public void testInvalidLogin() {

        Assertions.assertFalse(
                LoginService.login(
                        "wrong",
                        "wrong",
                        "2000-01-01"
                )
        );
    }

    @Test
    public void testNullLogin() {

        Assertions.assertFalse(
                LoginService.login(
                        null,
                        null,
                        null
                )
        );
    }
}