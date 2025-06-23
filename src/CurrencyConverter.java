import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "9112b781fd1975351ed7c8c0d326968c"; // Replace with your Fixer.io API Key
    private static final String API_URL = "http://data.fixer.io/api/latest?access_key=" + API_KEY;

    private static final Map<String, String> CURRENCY_SYMBOLS = new HashMap<>();
    static {
        CURRENCY_SYMBOLS.put("USD", "$");
        CURRENCY_SYMBOLS.put("EUR", "€");
        CURRENCY_SYMBOLS.put("INR", "₹");
        CURRENCY_SYMBOLS.put("GBP", "£");
        CURRENCY_SYMBOLS.put("JPY", "¥");
        CURRENCY_SYMBOLS.put("AUD", "A$");
        CURRENCY_SYMBOLS.put("CAD", "C$");
        CURRENCY_SYMBOLS.put("CNY", "¥");
        CURRENCY_SYMBOLS.put("CHF", "Fr");
        CURRENCY_SYMBOLS.put("SGD", "S$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency (e.g. USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g. INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            JSONObject rates = getExchangeRates();
            if (!rates.has(baseCurrency) || !rates.has(targetCurrency)) {
                System.out.println("Unsupported currency codes.");
                return;
            }

            double baseRate = rates.getDouble(baseCurrency);
            double targetRate = rates.getDouble(targetCurrency);

            // Since Fixer gives rates relative to EUR, we adjust:
            double convertedAmount = (targetRate / baseRate) * amount;

            String symbol = CURRENCY_SYMBOLS.getOrDefault(targetCurrency, targetCurrency);
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, symbol);

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    private static JSONObject getExchangeRates() throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        JSONObject json = new JSONObject(response.toString());
        if (!json.getBoolean("success")) {
            throw new IOException("API Error: " + json.getString("error"));
        }

        return json.getJSONObject("rates");
    }
}
