import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test

    public void loginEmptyEmailPassword() {
        provideEmail("kavya.ilapavuluri@testpro.io");
        providePassword("student#67");
        clickSubmit();
    }
}
