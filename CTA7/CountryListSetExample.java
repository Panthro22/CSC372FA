package CTA7;

import java.util.*;

public class CountryListSetExample {
    public static void main(String[] args) {
        // Using a List (ArrayList)
        List<String> countryList = new ArrayList<>();
        countryList.add("USA");
        countryList.add("Canada");
        countryList.add("USA"); // Duplicate element
        countryList.add("France");

        System.out.println("List:");
        for (String country : countryList) {
            System.out.println(country);
        }

        // Using a Set (HashSet)
        Set<String> countrySet = new HashSet<>();
        countrySet.add("USA");
        countrySet.add("Canada");
        countrySet.add("USA"); // Duplicate element, but it's automatically removed
        countrySet.add("France");
        
        System.out.println("\nSet:");
        for (String country : countrySet) {
            System.out.println(country);
        }
    }
}
