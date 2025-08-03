package Utelities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CVSReader {
    private static final ArrayList<SignUpData> users = new ArrayList<>();

    public CVSReader() {
        readFromCSV();
    }

    private static void readFromCSV() {
        String filePath = "src/main/resources/cvsData"; // Check this file exists

        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("❌ File not found: " + filePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String headerLine = br.readLine(); // Skip the header
            if (headerLine == null) {
                System.err.println("❌ File is empty.");
                return;
            }

            String[] headers = headerLine.split(",", -1);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip empty lines

                String[] values = line.split(",", -1);

                if (values.length != headers.length) {
                    System.err.println("⚠️ Skipping malformed line: " + line);
                    continue;
                }

                SignUpData user = getSignUpData(values);
                users.add(user);

                // Optional debug print
                System.out.println("✅ Loaded User: " + user.getName() + " | " + user.getEmail());
            }

        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static SignUpData getSignUpData(String[] values) {
        SignUpData user = new SignUpData();
        user.setName(values[0]);
        user.setEmail(values[1]);
        user.setPassword(values[2]);
        user.setDay(values[3]);
        user.setMonth(values[4]);
        user.setYear(values[5]);
        user.setFirstName(values[6]);
        user.setLastName(values[7]);
        user.setAddress(values[8]);
        user.setCountry(values[9]);
        user.setState(values[10]);
        user.setCity(values[11]);
        user.setZipcode(values[12]);
        user.setMobileNumber(values[13]);
        return user;
    }

    public SignUpData getUser() {
        return users.isEmpty() ? null : users.getFirst();
    }


}
