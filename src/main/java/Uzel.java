public class Uzel {
    private Uzel predchozi;
    private Uzel dalsi;
    private Integer hodnota;

    @Override
    public String toString() {
        return this.hodnota.toString();
    }

    public Uzel(Integer hodnota) {
        this.hodnota = hodnota;
    }

    public Uzel getPredchozi() {
        return predchozi;
    }

    public void setPredchozi(Uzel predchozi) {
        this.predchozi = predchozi;
    }

    public Uzel getDalsi() {
        return dalsi;
    }

    public void setDalsi(Uzel dalsi) {
        this.dalsi = dalsi;
    }

    public Integer getHodnota() {
        return hodnota;
    }

    public void setHodnota(Integer hodnota) {
        this.hodnota = hodnota;
    }
}
