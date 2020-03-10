package enums;


import org.apache.commons.lang3.RandomStringUtils;

public enum Delivery {

    FIRST_NAME(RandomStringUtils.randomAlphabetic(6)),
    LAST_NAME(RandomStringUtils.randomAlphabetic(6)),
    PHONE_NUMBER("552" + RandomStringUtils.randomNumeric(7));

    private String delivery;

    Delivery(String deliveriValue) {
        this.delivery = deliveriValue;
    }

    public String getDeliveryInfo() {
        return delivery;
    }

}