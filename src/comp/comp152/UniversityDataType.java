package comp.comp152;

import java.util.ArrayList;

public class UniversityDataType {
    String alpha_two_code;
    ArrayList<String> web_pages;
    String name;
    String country;
    ArrayList<String> domains;

    @Override
    public String toString(){
        return name + "is a Universtiy in " + country + "found on the webb: "+ web_pages;
    }
}
