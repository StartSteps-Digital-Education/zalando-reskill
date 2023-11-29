package org.startsteps.week13.class_02;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    public static void main(String[] args) {
        try {
            String apiKey = "fca_live_au5nJkAEWQcOa5OZ0OdWyEit3PQjnECRXXY0e4Xc"; // application.yml , application.propeties
            String fromCurrency = getUserPrompt("Enter the currency to convert from (eg. USD): ");
            String toCurrency = getUserPrompt("Enter the currency to convert to (eg. EUR)");
            double amount = Double.parseDouble(getUserPrompt("Enter the amount to convert: "));

            double convertedAmount = convertCurrency(apiKey, amount, fromCurrency, toCurrency);

            if (convertedAmount != -1) {
                System.out.println(amount + " " + fromCurrency + " equals" + convertedAmount + " " + toCurrency);
            } else {
                System.out.println("Conversion failed");
            }

            // string to json
        } catch (IOException | ParseException exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static double convertCurrency(String apiKey, double amount, String fromCurrency, String toCurrency) throws IOException, ParseException {
        String urlString = "https://api.freecurrencyapi.com/v1/latest?base_currency="
                + fromCurrency + "&currencies=" + toCurrency + "&apikey=" + apiKey;

        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // parse the result
        double convertedAmount = -1;
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());

            JSONObject data = (JSONObject) jsonResponse.get("data");
            double exchangeRate = Double.parseDouble(data.get(toCurrency).toString());
            convertedAmount = amount * exchangeRate; // {"data": {"USD": 1.23444}}
        }

        return convertedAmount;
    }

    private static String getUserPrompt(String s) throws IOException {
        System.out.println(s);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }


}
