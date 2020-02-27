package enums;

public enum LoginInfo {
    EMAIL("pinawab113@edusamail.net"),
    PASSWORD("hEpSiBuAda57?"),
    USER_NAME("Serhat Özdursun");

    private String loginInfoValue;

    LoginInfo(String loginInfoValue) {
        this.loginInfoValue = loginInfoValue;
    }

    public String getLoginInfo() {
        return loginInfoValue;
    }

}
