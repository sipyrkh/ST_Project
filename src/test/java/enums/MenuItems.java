package enums;

public enum MenuItems {
    COMPANY("company"),
    PRODUCT("product"),
    SMARTCITY("smartcity"),
    FINTECH("fintech"),
    PARTNERS("partners"),
    SERVICE("service"),
    NEWS("news"),
    CAREER("career"),
    CONTACTS("contacts");

    private final String value;

    MenuItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
