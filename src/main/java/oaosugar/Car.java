package oaosugar;

public class Car {
    private String mark;
    private int year;
    public String registrNumber;


    public Car(String mark, int year, String registrNumber){
        this.mark = mark;
        this.year = year;
        this.registrNumber = registrNumber;
    }

    /**
     * @return the mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @return the registrNumber
     */
    public String getRegistrNumber() {
        return registrNumber;
    }

    /**
     * @param registrNumber the registrNumber to set
     */
    public void setRegistrNumber(String registrNumber) {
        this.registrNumber = registrNumber;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }


}

