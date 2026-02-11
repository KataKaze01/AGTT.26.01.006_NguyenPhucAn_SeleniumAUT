package Enum;

public enum SeatType {
    HARDSEAT("Hard seat"),
    SOFTSEAT("Soft seat"),
    SOFTSEATWITHAIRCONDITIONER("Soft seat with air conditioner"),
    HARDBED("Hard bed"),
    SOFTBED("Soft bed"),
    SOFTBEDWITHAIRCONDITIONER("Soft bed with air conditioner");
    private final String value;
    SeatType(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
