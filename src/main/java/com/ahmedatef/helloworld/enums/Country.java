package com.ahmedatef.helloworld.enums;

public enum Country {
    EG("Egypt"), SA("Saudi Arabia"), UAE("United Arab Emirates"), QA("Qatar");

    private final String name;

    Country(String name) { this.name = name; }
    public String getName() { return name; }

}
