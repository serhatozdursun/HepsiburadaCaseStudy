package enums;

public enum EasyPoint {
    ISTANBUL_ZORLU_CENTER(0),
    ISTANBUL_AKASYA(2),
    ISTANBUL_AKMERKEZ(3),
    ISTANBUL_KANYON(4),
    ISTANBUL_ANATOLIUN(5),
    ISTANBUL_WORKINTON_LEVENT(6),
    ISTANBUL_WORKINTON_KOZYATAGI(7),
    ISTANBUL_MALTEPE_PIAZZA_AVM(8),
    ISTANBUL_WORKINTON_SAPPHIRE(9),
    ISTANBUL_WORKINTON_SGALATA8(10),
    ANTALYA_TERRACITY_AVM(11),
    ANKARA_ATAKULE(12),
    IZMIR_HILTON_KARSIYAKA(13),
    ADANA_01_BURADA_AVM(14);

    private int EasyPoint;

    EasyPoint(int loginInfoValue) {
        this.EasyPoint = loginInfoValue;
    }

    public int getEasyPointIndex() {
        return EasyPoint;
    }
}
