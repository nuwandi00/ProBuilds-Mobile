import com.example.kelineyt.util.RegisterFieldsState
import com.example.kelineyt.util.RegisterValidation
import org.junit.Assert
import org.junit.Test

class RegisterFieldsStateTest {

    @Test
    fun testRegisterFieldsStateSuccess() {
        // Create a RegisterFieldsState with success for email and password
        val registerFieldsState = RegisterFieldsState(
            email = RegisterValidation.Success,
            password = RegisterValidation.Success
        )

        // Assert that both email and password are in a success state
        Assert.assertEquals(RegisterValidation.Success, registerFieldsState.email)
        Assert.assertEquals(RegisterValidation.Success, registerFieldsState.password)
    }

    @Test
    fun testRegisterFieldsStateFailed() {
        // Create a RegisterFieldsState with a failed message for email and password
        val errorMessage = "Invalid input"
        val registerFieldsState = RegisterFieldsState(
            email = RegisterValidation.Failed(errorMessage),
            password = RegisterValidation.Failed(errorMessage)
        )

        // Assert that both email and password are in a failed state with the same error message
        Assert.assertTrue(registerFieldsState.email is RegisterValidation.Failed)
        Assert.assertTrue(registerFieldsState.password is RegisterValidation.Failed)

        // Cast to RegisterValidation.Failed and check the error message
        val emailError = registerFieldsState.email as RegisterValidation.Failed
        val passwordError = registerFieldsState.password as RegisterValidation.Failed

        Assert.assertEquals(errorMessage, emailError.message)
        Assert.assertEquals(errorMessage, passwordError.message)
    }
}
