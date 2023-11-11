package Automation_Project;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;

	public class API_Get {

	    public static void main(String[] args) {
	        try {
	            // Specify the URL of the API you want to call
	            String apiUrl = "https://petstore.swagger.io/v2/store/inventory";
	            


	            // Create a URL object
	            URL url = new URL(apiUrl);

	            // Open a connection to the URL
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	            // Set the request method to GET
	            connection.setRequestMethod("GET");

	            // Get the response code
	            int responseCode = connection.getResponseCode();

	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                // If the response code is OK, read the response data
	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String line;
	                StringBuffer response = new StringBuffer();

	                while ((line = reader.readLine()) != null) {
	                    response.append(line);
	                }
	                reader.close();

	                // Print the response
	                System.out.println("Response: " + response.toString());
	            } else {
	                // If the response code is not OK, print an error message
	                System.out.println("Error: " + responseCode);
	            }

	            // Close the connection
	            connection.disconnect();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



