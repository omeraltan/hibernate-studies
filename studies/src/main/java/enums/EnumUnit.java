package enums;

public enum EnumUnit {
    PIECE("PIECE"), WEIGHT("WEIGHT"), LITER("LITER"), PORTION("PORTION"), PACK("PACK");

    private final String unit;

    EnumUnit(String unit) {
        this.unit = unit;
    }

    public String getType() {
        return unit;
    }
}
