package Utelities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TestDataProvider {

    @DataProvider(name = "userData")
    public Object[][] usersData() throws IOException {
        // هنا بمرر اسم الملف فقط داخل resources
        return CVSReader.getSignUpData("cvsData");
    }
}
