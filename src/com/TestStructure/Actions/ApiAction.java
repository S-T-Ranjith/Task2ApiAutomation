package com.TestStructure.Actions;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ApiAction {
    static String addURI;
    static URL url;
    static HttpURLConnection connection;

    /**
     *
     * @param endpoint
     * @throws MalformedURLException
     * Code to set URL
     */
    public static void setServiceEndpoint(String endpoint) throws MalformedURLException {
        addURI = "https://reqres.in" + endpoint;
        url = new URL(addURI);
        System.out.println("Add URL :" + url);
    }

    /**
     *
     * @param requestType
     * @param apiName
     * @throws IOException
     * code to process request type parameters
     */
    public static void setRequestType(String requestType, String apiName)  {
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestType);
            connection.setRequestProperty("Accept", "application/json");
            if (requestType.equals("POST") && apiName.equals("CREATE")) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                String payload = "{\"name\":\"John Doe\",\"job\":\"leader\"}";
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input);
                outputStream.flush();
                outputStream.close();
            }  if (requestType.equals("POST") && apiName.equals("REGISTER_USER")) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                String payload = "{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}";
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input);
                outputStream.flush();
                outputStream.close();
            }
            else if (requestType.equals("UPDATE")) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                String payload = "{\"name\":\"morpheus\",\"job\":\"Tester\"}";
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input);
                outputStream.flush();
                outputStream.close();
            } else if (requestType.equals("PATCH")) {
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                String payload = "{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input);
                outputStream.flush();
                outputStream.close();
            }

        } catch (Exception IOException) {
            System.out.println("setRequestType failed " + IOException);
        }

    }

    /**
     *
     * @throws IOException
     * code to check response code
     */
    public static void checkStatusCode() throws IOException {
        System.out.println("Response code:   " + connection.getResponseCode());
        if (connection.getResponseCode() == 200) {
            System.out.println("API request successful");
        } else if (connection.getResponseCode() == 201) {
            System.out.println("Data created! ");
        } else if (connection.getResponseCode() == 404) {
            System.out.println("Page not found!");
        } else if (connection.getResponseCode() == 204) {
            System.out.println("No content found!");
        } else if (connection.getResponseCode() == 400) {
            System.out.println("Unauthorized! ");
        } else if (connection.getResponseCode() == 401) {
            System.out.println("Bad request");
        } else {
            throw new RuntimeException("HTTP error code : "
                    + connection.getResponseCode());
        }

    }

    /**
     *
     * @throws IOException
     * Code to check the response body
     */
    public static void verifyResponseBody() throws IOException {
        if (connection.getResponseCode() == 404) {
            System.out.println("API resource not found");
        } else if (connection.getResponseCode() == 204) {
            System.out.println("No content found");
        } else {
            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();
            System.out.println("Response : " + entireResponse);
            scan.close();
        }
    }
}
