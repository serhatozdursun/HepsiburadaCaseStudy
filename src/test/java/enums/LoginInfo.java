package enums;

public enum LoginInfo {
    MEMBER_EMAIL("pinawab113@edusamail.net"),
    PASSWORD("hEpSiBuAda57?"),
    USER_NAME("Serhat Özdursun"),
    EMAIL("q1w2we34e@hepsi.com");

    private String loginInfoValue;

    LoginInfo(String loginInfoValue) {
        this.loginInfoValue = loginInfoValue;
    }

    public String getLoginInfo() {
        return loginInfoValue;
    }

}
