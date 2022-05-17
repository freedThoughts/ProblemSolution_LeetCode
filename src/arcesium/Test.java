/*
package arcesium;

import java.math.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class Test {

    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        gson =  builder.create();
    }


    */
/*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     *//*



    class Holding {
        public String date;
        public String security;
        public int quantity;
        public String portfolio;
    }

    class Price {
        public String date;
        public String security;
        public double price;
    }



    public static String getJsonString(String urlProvided){

        StringBuffer sb = new StringBuffer();
        try {

            URL url = new URL(urlProvided);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


        return new String(sb);

    }


    public static Map<String, Integer> getHoldings(String date) {

        String holdingStr = getJsonString("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");


        Type listOfMyClassObject = new TypeToken<ArrayList<Holding>>() {}.getType();
        List<Holding> holdings = gson.fromJson(holdingStr, listOfMyClassObject);

        Map<String, Integer> holdingMap = new HashMap<>();

        for(Holding holding : holdings) {
            if (!holding.date.equals(date)) continue;
            Integer quant = holdingMap.get(holding.security);
            if (quant == null) quant = 0;
            quant = quant + holding.quantity;
            holdingMap.put(holding.security, quant);
        }
        return holdingMap;
    }

    public static Map<String, Double> getPrice(String date) {

        String holdingStr = getJsonString("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");


        Type listOfMyClassObject = new TypeToken<ArrayList<Price>>() {}.getType();
        List<Price> holdings = gson.fromJson(holdingStr, listOfMyClassObject);

        Map<String, Double> priceMap = new HashMap<>();

        for(Price price : holdings) {
            if (!price.date.equals(date)) continue;
            priceMap.put(price.security, price.price);
        }
        return priceMap;

    }

    public static double calculateNAV(String date) {
        Map<String, Integer> holdingMap = getHoldings(date);
        Map<String, Double> priceMap = getPrice(date);
        BigDecimal holdingValue = new BigDecimal(0.0);
        for(Map.Entry<String, Integer> entry : holdingMap.entrySet()) {
            int quantity = entry.getValue();
            Double price = priceMap.get(entry.getKey());
            if (price == null) continue;
            BigDecimal val = new BigDecimal(quantity * price).setScale(2, BigDecimal.ROUND_HALF_UP);

            holdingValue = holdingValue.add(val).setScale(2, BigDecimal.ROUND_HALF_UP);
        }

        return holdingValue.doubleValue();
    }

}
*/
