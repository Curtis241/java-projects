package ca.pragmaticdev.ws.service;

import ca.pragmaticdev.ws.data.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.pragmaticdev.ws.service.Password;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by cpeterson on 24/03/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-service-configuration.xml"})
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void decodeValidAuthorizationHeaderTest() {

        String[] decodeArray = userService.decodeBase64String("Basic Y3VydGlzcGU6cGFzc3dvcmQ=");

        assertTrue(decodeArray.length == 2);
        assertTrue(decodeArray[0].matches("curtispe"));
        assertTrue(decodeArray[1].matches("password"));

    }

    @Test
    public void decodeInvalidAuthorizationHeaderTest() {

        String[] decodeArray = userService.decodeBase64String("invalidheader");

        assertTrue(decodeArray.length == 0);

    }

    @Test
    public void validatePlainTextMatchingPasswordsTest() {

        Password decodedPassword = new Password("password",false);
        assertTrue(userService.validatePassword(decodedPassword,decodedPassword));
    }

    @Test
    public void validatePlainTextUnmatchedPasswordsTest() {

        Password decodedPassword = new Password("password",false);
        Password decodedIncorrectPassword = new Password("passwords",false);
        assertFalse(userService.validatePassword(decodedIncorrectPassword,decodedPassword));
    }

    @Test
    public void validateNullProvidedPasswordTest() {

        Password decodedPassword = new Password("password",false);
        assertFalse(userService.validatePassword(null,decodedPassword));
    }

    @Test
    public void validateNullExpectedPasswordTest() {

        Password decodedPassword = new Password("password",false);
        assertFalse(userService.validatePassword(decodedPassword,null));
    }

    @Test
    public void validateEncodedProvidedPasswordTest() {

        Password decodedPassword = new Password("password",false);
        Password encodedPassword = new Password("cGFzc3dvcmQ=",true);
        assertTrue(userService.validatePassword(encodedPassword,decodedPassword));
    }
}
