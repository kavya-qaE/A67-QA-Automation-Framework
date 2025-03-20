import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @org.testng.annotations.DataProvider(name ="ValidCredentials")
    public static Object[][] validCredentials(){
        return new Object[][]{
                {"kavya.ilapavuluri@testpro.io","student#67"}
        };
    }
    @DataProvider(name = "InvalidCredentials")
    public static Object[][] InvalidCredentials(){
        return new Object[][]{
                {"abc@testpro.io","abc"}
        };
    }

    @DataProvider(name = "playlistNames")
    public Object[][] playlistNames(){
        return new Object[][]{
                {"melody"}
        };
    }

    @DataProvider(name = "validCredentialsAndPlaylistNames")
    public Object[][] validCredentialsAndPlaylistNames() {
        Object[][] validCredentials = validCredentials(); // Retrieve credentials from the original data provider
        Object[][] playlistNames = playlistNames();// Retrieve playlist names from the original data provider

        Object[][] validCredentialsAndPlaylistNames = new Object[validCredentials.length * playlistNames.length][3]; // For 2 parameters (email, password, playlistName)
        int index = 0;

        for (Object[] credentials : validCredentials) {
            for (Object[] playlist : playlistNames) {
                validCredentialsAndPlaylistNames[index][0] = credentials[0]; // email
                validCredentialsAndPlaylistNames[index][1] = credentials[1]; // password
                validCredentialsAndPlaylistNames[index][2] = playlist[0];   // playlist name
                index++;
            }
        }
        return validCredentialsAndPlaylistNames;
    }

}


