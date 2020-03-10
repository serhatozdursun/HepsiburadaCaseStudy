package enums;

public enum ShippmentType {

    SEND_TO_ADDRESS(0),
    SEND_TO_EASY_POINT(1);
    private int ShippmentType;

    ShippmentType(int loginInfoValue) {
        this.ShippmentType = loginInfoValue;
    }

    public int getShippmentType() {
        return ShippmentType;
    }
}
