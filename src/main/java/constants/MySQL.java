package constants;

public enum MySQL {

    HOST     ("sql222.main-hosting.eu"),
    PORT     ("3306"),
    DB       ("u401146528_QA02"),
    USER     ("u401146528_QA02"),
    PASSWORD ("QA14022020");

    public final String value;


    MySQL(String value) {
        this.value = value;
    }
}