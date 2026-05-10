
package app;

public class Fuvar {
    
    private String rsz;
    private int ido;
    private double osszeg;
    //private Fizetes fizet;
    private String fizetes;

    public Fuvar(String rsz, int ido, double osszeg, String fizetes) {
        this.rsz = rsz;
        this.ido = ido;
        this.osszeg = osszeg;
        this.fizetes = fizetes;
    }

    public String getFizet() {
        return fizetes;
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
