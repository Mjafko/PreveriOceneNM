package mjafko;

public class School_programs {

    private String  elektronika_Redni;
    private String  elektronika_Izredni;
    private String  informatika_Redni;
    private String  informatika_Izredni;
    private String  kozmetika_Redni;
    private String  kozmetika_Izredni;
    private String  kozmetika_Izola;
    private String  lesarstvo_Redni;
    private String  lesarstvo_Izredni;
    private String  logisticno_inzenirstvo_Izredni;
    private String  logisticno_inzenirstvo_Ljubljana;
    private String  strojnistvo_Redni;
    private String  strojnistvo_Izredni;
    private String  strojnistvo_Zagorje;
    private String  strojnistvo_Murska_Sobota;
    private String  varstvo_okolja_in_komunala_Redni;
    private String  varstvo_okolja_in_komunala_Izredni;
    private String  baseURL = "http://evidenca.ecnm.si/";

    //Constructor
    public School_programs() {
        this.elektronika_Redni = baseURL + "IzpitniRoki502-1-1.htm";
        this.elektronika_Izredni = baseURL + "IzpitniRoki502-2-1.htm";
        this.informatika_Redni = baseURL + "IzpitniRoki505-1-1.htm";
        this.informatika_Izredni = baseURL + "IzpitniRoki505-2-1.htm";
        this.kozmetika_Redni = baseURL + "IzpitniRoki506-1-1.htm";
        this.kozmetika_Izredni = baseURL + "IzpitniRoki506-2-1.htm";
        this.kozmetika_Izola = baseURL + "IzpitniRoki506-3-12.htm";
        this.lesarstvo_Redni = baseURL + "IzpitniRoki504-1-1.htm";
        this.lesarstvo_Izredni = baseURL + "IzpitniRoki504-2-1.htm";
        this.logisticno_inzenirstvo_Izredni = baseURL + "IzpitniRoki503-2-1.htm";
        this.logisticno_inzenirstvo_Ljubljana = baseURL + "IzpitniRoki503-3-9.htm";
        this.strojnistvo_Redni = baseURL + "IzpitniRoki500-1-1.htm";
        this.strojnistvo_Izredni = baseURL + "IzpitniRoki500-2-1.htm";
        this.strojnistvo_Zagorje = baseURL + "IzpitniRoki500-3-8.htm";
        this.strojnistvo_Murska_Sobota = baseURL + "IzpitniRoki500-3-10.htm";
        this.varstvo_okolja_in_komunala_Redni = baseURL + "IzpitniRoki501-1-1.htm";
        this.varstvo_okolja_in_komunala_Izredni = baseURL + "IzpitniRoki501-2-1.htm";
    }

    // Getters
    public String getElektronika_Redni() {
        return elektronika_Redni;
    }

    public String getElektronika_Izredni() {
        return elektronika_Izredni;
    }

    public String getInformatika_Redni() {
        return informatika_Redni;
    }

    public String getInformatika_Izredni() {
        return informatika_Izredni;
    }

    public String getKozmetika_Redni() {
        return kozmetika_Redni;
    }

    public String getKozmetika_Izredni() {
        return kozmetika_Izredni;
    }

    public String getLesarstvo_Redni() {
        return lesarstvo_Redni;
    }

    public String getLesarstvo_Izredni() {
        return lesarstvo_Izredni;
    }

    public String getLogisticno_inzenirstvo_Izredni() {
        return logisticno_inzenirstvo_Izredni;
    }

    public String getStrojnistvo_Redni() {
        return strojnistvo_Redni;
    }

    public String getStrojnistvo_Izredni() {
        return strojnistvo_Izredni;
    }

    public String getStrojnistvo_Zagorje() {
        return strojnistvo_Zagorje;
    }

    public String getStrojnistvo_Murska_Sobota() {
        return strojnistvo_Murska_Sobota;
    }

    public String getVarstvo_okolja_in_komunala_Redni() {
        return varstvo_okolja_in_komunala_Redni;
    }

    public String getVarstvo_okolja_in_komunala_Izredni() {
        return varstvo_okolja_in_komunala_Izredni;
    }

    public String getKozmetika_Izola() {
        return kozmetika_Izola;
    }

    public String getLogisticno_inzenirstvo_Ljubljana() {
        return logisticno_inzenirstvo_Ljubljana;
    }

}
