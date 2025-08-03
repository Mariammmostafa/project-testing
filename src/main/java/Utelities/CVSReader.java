package Utelities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CVSReader {

    public static Object[][] getSignUpData(String resourcePath) throws IOException {
        InputStream inputStream = CVSReader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IOException(resourcePath + " not found in resources folder");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Object[]> data = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            data.add(parts);
        }
        reader.close();

        return data.toArray(new Object[0][]);
    }
}
