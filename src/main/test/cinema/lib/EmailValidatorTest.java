package cinema.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cinema.lib.EmailValidator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EmailValidatorTest {
    private static final EmailValidator VALIDATOR = new EmailValidator();


    @ParameterizedTest(name = "{index} - {0} is valid email")
    @ValueSource(strings = {"user@domain.com", "user@domain.co.in", "user_name@domain.com"})
    @Tag("valid")
    void isValid_correctEmails_True(String email) {
        assertTrue(VALIDATOR.isValid(email, null));
    }

    @ParameterizedTest(name = "{index} - {0} is invalid email")
    @MethodSource("invalidStrings")
    @Tag("invalid")
    void isValid_invalidEmails_False(String email) {
        assertFalse(VALIDATOR.isValid(email, null));
    }

    private static Stream<String> invalidStrings(){
        return Stream.of(".username@yahoo.com", "username@yahoo.com.",
                "username@yahoo..com", "username@yahoo.c", "username@yahoo.corporate");
    }


    @ParameterizedTest(name = "{index} - \"{0}\" is invalid email")
    @NullAndEmptySource
    @Tag("invalid")
    void isValid_nullAndEmptyString_False(String email) {
        assertFalse(VALIDATOR.isValid(email, null));
    }

    @ParameterizedTest(name = "{index} - isValid({0}) == {1}")
    @ArgumentsSource(invalidStringsArgumentsProvider.class)
    @Tag("valid")
    @Tag("invalid")
    void isValid_validAndInvalidEmailsWithExpectedIsValidValue_Equals(String email,
                                                                      Boolean expected) {
        assertEquals(expected, VALIDATOR.isValid(email, null));
    }

    static class invalidStringsArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of(".username@yahoo.com", false),
                    Arguments.of("username@yahoo.com.", false),
                    Arguments.of("username@yahoo..com", false),
                    Arguments.of("username@yahoo.c", false),
                    Arguments.of("username@yahoo.corporate", false),
                    Arguments.of("user@domain.com", true),
                    Arguments.of("user@domain.co.in", true),
                    Arguments.of("user_name@domain.com", true)
            );
        }
    }



}