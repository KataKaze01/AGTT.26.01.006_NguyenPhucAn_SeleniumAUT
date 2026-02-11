package Enum;

public enum Station {
    NHATRANG("Nha Trang"),
    SAIGON("Sài Gòn"),
    PHANTHIET("Phan Thiết"),
    DANANG("Đà Nẵng"),
    HUE("Huế"),
    QUANGNGAI("Quảng Ngãi");
    private final String value;
    Station(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}