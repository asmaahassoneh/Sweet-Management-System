package production_cods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProfitsSource {

    boolean profitCalculated = true;
    boolean lessREapet=true;
boolean repated=true;
    String MAXproductName;
    String LessproductName;

    public double ProfitCalculated() {

        String filePath = "PuarchedProduct.txt";
        double totalProfit = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line in the file
                String[] parts = line.split(",");

                for (int i = 1; i < parts.length; i++) {
                    // Split the part by spaces to get the profit value
                    String[] productDetails = parts[i].split(" ");
                    double profit = Double.parseDouble(productDetails[2]); // Assuming the profit is always in the 3rd position
                    totalProfit += profit;
                }
            }
        } catch (IOException e) {
            profitCalculated = false;
            e.printStackTrace();
        }
        return totalProfit;
    }

    public boolean isProfitCalculated() {
        return profitCalculated;
    }

    public String getLessproductName() {
        return LessproductName;
    }

    public int mostRepated() {

        String filePath = "PuarchedProduct.txt";

        // HashMap to track the frequency of each product
        Map<String, Integer> productFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(",");

                // Iterate through the parts to find product names
                for (int i = 1; i < parts.length; i++) {
                    // Split the part by spaces to get the product name
                    String[] productDetails = parts[i].split(" ");
                   MAXproductName = productDetails[0];

                    // Update the frequency of the product in the map
                    productFrequency.put(MAXproductName, productFrequency.getOrDefault(MAXproductName, 0) + 1);

                }
            }
        } catch (IOException e) {
            repated=false;
            e.printStackTrace();
        }

        // Determine the most repeated product
        String mostRepeatedProduct = null;
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : productFrequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostRepeatedProduct = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

return  maxFrequency;
    }

    public String getMAXproductName() {
        return MAXproductName;
    }

    public boolean isRepated() {
        return repated;
    }



    public  int lessRepated() {
        String filePath = "PuarchedProduct.txt";
        Map<String, Integer> productFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by commas
                String[] parts = line.split(",");

                // Iterate through the parts to find product names
                for (int i = 1; i < parts.length; i++) {
                    // Split the part by spaces to get the product name
                    String[] productDetails = parts[i].split(" ");
                     LessproductName = productDetails[0];

                    // Update the frequency of the product in the map
                    productFrequency.put(LessproductName, productFrequency.getOrDefault(LessproductName, 0) + 1);
                }
            }
        } catch (IOException e) {
            lessREapet=false;
            e.printStackTrace();
        }

        // Determine the least repeated product
        String leastRepeatedProduct = null;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : productFrequency.entrySet()) {
            if (entry.getValue() < minFrequency) {
                leastRepeatedProduct = entry.getKey();
                minFrequency = entry.getValue();
            }
        }
return  minFrequency;

    }

    public boolean isLessREapet() {
        return lessREapet;
    }
}








































