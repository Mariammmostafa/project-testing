package Utelities;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {


    @DataProvider(name = "userData")
    public static Object[][] readCsv() throws IOException {
        String path = "src/test/resources/cvsData"; // عدّل المسار حسب مكان الملف عندك
        List<Object[]> records = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        br.readLine(); // عشان تتخطى رأس العمود (header)

        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            records.add(fields);
        }
        br.close();

        return records.toArray(new Object[records.size()][]);
    }
}


