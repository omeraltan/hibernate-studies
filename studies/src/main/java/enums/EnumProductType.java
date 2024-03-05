package enums;

public enum EnumProductType {
    FOOD("FOOD"), DRINK("DRINK"), CLOTHES("CLOTHES"), FUEL("FUEL"), CONSUMPTIONMATERIAL("CONSUMPTIONMATERIAL");

    private final String type;

    EnumProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
