package Task2;

import java.util.*;

public class PhoneDirectory {

    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        List<String> phones = directory.get(surname);
        if (phones == null) {
            phones = new ArrayList<>();
            directory.put(surname, phones);
        }
        phones.add(phoneNumber);
    }

    public List<String> get(String surname) {
        return directory.getOrDefault(surname, Collections.emptyList());
    }
}


