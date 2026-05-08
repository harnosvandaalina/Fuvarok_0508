
package app;

public class Fuvar {
    private Fizetes fizet;
    private String rsz;
    private int ido;
    private double osszeg;

    public Fuvar(Fizetes fizet, String rsz, int ido, double osszeg) {
        this.fizet = fizet;
        this.rsz = rsz;
        this.ido = ido;
        this.osszeg = osszeg;
    }

    public Fizetes getFizet() {
        return fizet;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdo() {
        return ido;
    }

    public double getOsszeg() {
        return osszeg;
    }
 
    
    
}
