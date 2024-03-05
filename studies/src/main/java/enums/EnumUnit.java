package enums;

public enum EnumUnit {
    PIECE("piece"), WEIGHT("weight"), LITER("liter"), PORTION("portion"), pack("pack");

    private final String unit;

    EnumUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return unit;
    }
}
