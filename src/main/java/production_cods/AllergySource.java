package production_cods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;


public class AllergySource {
    private static final Logger logger =  Logger.getLogger(AllergySource.class.getName());
    private boolean checkIfFindAllergy = false;
    public List<String> searchForAllergy() {
        String filePath = "Products.txt";

        ArrayList<String> trueLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains("true")) {
                    trueLines.add(line);
                    checkIfFindAllergy = true;
                }
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
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
