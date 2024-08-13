package production_cods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class AllergySource {

    private boolean checkIfFindAllergy = false;

    public Vector<String> SearchForAllergy() {
        String filePath = "Products.txt";

        Vector<String> trueLines = new Vector<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains("true")) {
                    trueLines.add(line);
                    checkIfFindAllergy = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trueLines;
    }

    public void resetAllergyFilter() {
        checkIfFindAllergy = false;
    }

    public boolean isCheckIfFindAllergy() {
        return checkIfFindAllergy;
    }
}
