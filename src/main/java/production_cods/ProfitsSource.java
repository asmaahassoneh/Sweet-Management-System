package production_cods;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProfitsSource {
    private boolean profitCalculated = true;
    private boolean lessRepeat = true;
    private boolean repeated = true;
    private String filePath = "PuarchedProduct.txt";

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double profitCalculated() {
        double totalProfit = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (int i = 1; i < parts.length; i++) {totalProfit += parseProfit(parts[i]);
                }
            }
        } catch (IOException e) {
            profitCalculated = false;
        }
        return totalProfit;
    }

    private double parseProfit(String productDetail) {
        try {return Double.parseDouble(productDetail.split(" ")[2]);} catch (NumberFormatException e) {profitCalculated = false;return 0.0;
        }
    }

    public boolean isProfitCalculated() {
        return profitCalculated;
    }

    public int mostRepeated() {
        return findProductFrequency(Integer::max, 0);
    }

    public boolean isRepeated() {
        return repeated;
    }

    public int lessRepeated() {
        return findProductFrequency(Integer::min, Integer.MAX_VALUE);
    }

    public boolean isLessRepeat() {
        return lessRepeat;
    }

    private int findProductFrequency(FrequencyComparator comparator, int initialValue) {
        Map<String, Integer> productFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                for (int i = 1; i < parts.length; i++) {String productName = parts[i].split(" ")[0];productFrequency.put(productName, productFrequency.getOrDefault(productName, 0) + 1);
                }
            }
        } catch (IOException e) {
            if (initialValue == Integer.MAX_VALUE) {
                lessRepeat = false;
            } else {
                repeated = false;
            }
        }
        return productFrequency.values().stream().reduce(initialValue, comparator::compare);
    }

    @FunctionalInterface
    private interface FrequencyComparator {
        int compare(int a, int b);
    }
}
