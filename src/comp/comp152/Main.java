package comp.comp152;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
	var dataGrabber = HttpClient.newHttpClient();
    var requestMaker = HttpRequest.newBuilder();
    var webAdress = URI.create("http://universities.hipolabs.com/search?name=Young");
    var dataRequest = requestMaker.uri(webAdress).build();
    HttpResponse<String> response = null;
    try{
        response = dataGrabber.send(dataRequest,HttpResponse.BodyHandlers.ofString());

    }
    catch(IOException exception){
        System.out.println("error connecting to networked source");

    }
    catch (InterruptedException e){
        System.out.println("An error occured getting a response from the server");
    }
    if(response == null){
        System.out.println("Something went terribly wrong - we have to close now");
        System.exit(-1);
    }
    var usefulData = response.body();
    System.out.println(usefulData);
    var dataParser = new Gson();
    UniversityDataType[] parsedData = dataParser.fromJson(usefulData, UniversityDataType[].class);
    for(var currentUniversity : parsedData){
        System.out.println(currentUniversity);
    }


    }
}
