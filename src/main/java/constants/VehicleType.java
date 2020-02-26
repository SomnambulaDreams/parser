package constants;

public enum VehicleType {

    CAR                     ("Легковые"),
    MOTO                    ("Мото"),
    TRUCK                   ("Грузовики"),
    TRAILER                 ("Прицепы"),
    SPECIAL_MACHINERY       ("Спецтехника"),
    AGRICULTURAL_MACHINERY  ("Сельхозтехника"),
    BUS                     ("Автобусы"),
    WATER_TRANSPORT         ("Водный транспорт"),
    AIR_TRANSPORT           ("Воздушный транспорт"),
    MOTO_HONE               ("Автодома");

    public final String value;


    VehicleType(String value) {
        this.value = value;
    }
}