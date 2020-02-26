package entity;

public class VehicleBrand {

    private int id;
    private String name;


    public VehicleBrand() {
    }


    public VehicleBrand(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Fitness { " +
                "ID = " + this.id + ", " +
                "name = " + this.name + "}";
    }


    public String toStringPretty() {
        return "Fitness {\n" +
                "\tID   = " + this.id + ",\n" +
                "\tname = " + this.name + ",\n" +
                "}\n";
    }
}