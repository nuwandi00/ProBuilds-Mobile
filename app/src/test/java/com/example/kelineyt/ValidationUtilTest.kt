import com.example.kelineyt.util.validateEmail
import com.example.kelineyt.util.validatePassword
import com.example.kelineyt.util.RegisterValidation
import org.junit.Assert
import org.junit.Test

class ValidationTest {

    @Test
    fun testValidEmail() {
        val validEmail = "test@example.com"
        val result = validateEmail(validEmail)
        Assert.assertEquals(RegisterValidation.Success, result)
    }

    @Test
    fun testEmptyEmail() {
        val emptyEmail = ""
        val result = validateEmail(emptyEmail)
        Assert.assertEquals(RegisterValidation.Failed("Email cannot be empty"), result)
    }

    @Test
    fun testInvalidEmail() {
        val invalidEmail = "invalid-email"
        val result = validateEmail(invalidEmail)
        Assert.assertEquals(RegisterValidation.Failed("Wrong email format"), result)
    }

    @Test
    fun testValidPassword() {
        val validPassword = "123456"
        val result = validatePassword(validPassword)
        Assert.assertEquals(RegisterValidation.Success, result)
    }

    @Test
    fun testEmptyPassword() {
        val emptyPassword = ""
        val result = validatePassword(emptyPassword)
        Assert.assertEquals(RegisterValidation.Failed("Password cannot be empty"), result)
    }

    @Test
    fun testShortPassword() {
        val shortPassword = "12345"
        val result = validatePassword(shortPassword)
        Assert.assertEquals(RegisterValidation.Failed("Password should contains 6 char"), result)
    }
}
