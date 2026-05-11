
package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Kocsik {

    private static List<Fuvar> fuvarok = new ArrayList<>();
    

    public static void main(String[] args) throws IOException {
       Path path = Path.of("fuvarok.csv");
       
       List<String> sorok = Files.readAllLines(path);
       
        for (String sor : sorok) {
            String[] s = sor.split(",");
            String rsz = s[0];
            int ido = Integer.parseInt(s[1]);
            double osszeg = Double.parseDouble(s[2]);
            String fizetes = s[3];
            //Fizetes fizet = Fizetes.valueOf(s[3]);
           
            Fuvar fuvar = new Fuvar(rsz, ido, osszeg, fizetes);
            fuvarok.add(fuvar);
        }
        
        osszesFuvar();
        legdragabbFuvarRendszama();
        legolcsobbFuvarForintban();
        hanyKartyas();
        mindenFizetesMeghatarozottE();
        hanyDbAuto();
        hanyFizetesiMod();
        melyikAutoMennyiFuvar();
    }
    
    private static void osszesFuvar() {
        double osszeg = 0;
        int i = 0;
        while(i < fuvarok.size()){
            osszeg += fuvarok.get(i).getOsszeg();
            i++;
        }
        System.out.println("1.: Összes fuvar értéke: " + osszeg);
    }

    private static void legdragabbFuvarRendszama() {
        double max = fuvarok.get(0).getOsszeg();
        int maxIndex = 0;
        int i = 0;
        
        while(i < fuvarok.size()){
            if(fuvarok.get(i).getOsszeg() > max){
                max = fuvarok.get(i).getOsszeg();
                maxIndex = i;
            }
            i++;
        }
        System.out.println("2.: legdrágább fuvar rendszáma: " + fuvarok.get(maxIndex).getRsz());  
    }

    private static void legolcsobbFuvarForintban() {
        double min = fuvarok.get(0).getOsszeg();
        int minIndex = 0;
        int i = 0;
        
        while(i < fuvarok.size()){
            if(fuvarok.get(i).getOsszeg() < min){
                min = fuvarok.get(i).getOsszeg();
                minIndex = i;
            }
            i++;
        }
        double arfolyam = 351.95;
        System.out.println("3.: legolcsóbb fuvar forintban: " + fuvarok.get(minIndex).getOsszeg() * arfolyam + "Ft");
    }

    private static void hanyKartyas() {
        int db = 0;
        int i = 0;
        
        while(i< fuvarok.size()){
            if(fuvarok.get(i).getFizet().equals("kártya")){
                db ++;
            }
            i++;
        }
        System.out.println("4.: hány kártyás fizetés volt: " + db);
    }

    private static void mindenFizetesMeghatarozottE() {
        int i = 0;
        
        while(i< fuvarok.size() && !fuvarok.get(i).getFizet().equals("-")){
            i++;
        }
        String valasz = i >= fuvarok.size() ? "igen" : "nem";
        System.out.println("5.: minden fizetési mód meghatározoztt: " + valasz);
    }

    private static void hanyDbAuto() {
       Set<String> autoDb = new TreeSet <>();
        for (Fuvar fuvar : fuvarok) {
            autoDb.add(fuvar.getRsz());
        }
        System.out.println("6.: hány darab autó van a rendszerben: " + autoDb.size());
    }

    private static void hanyFizetesiMod() {
       Set<String> fizetesiModDb = new TreeSet <>();
        for (Fuvar fuvar : fuvarok) {
            fizetesiModDb.add(fuvar.getFizet());
        }
        System.out.println("7.: hányféle fizetési mód van: " + fizetesiModDb.size());
    }

    private static void melyikAutoMennyiFuvar() {
        Map<String, Integer> melyikAutoMennyi = new HashMap<>();
        for (Fuvar fuvar : fuvarok) {
            String kulcs = fuvar.getRsz();
            if(melyikAutoMennyi.containsKey(kulcs)){
                int ertek = melyikAutoMennyi.get(kulcs);
                melyikAutoMennyi.put(kulcs, ++ertek);
            }else{ 
                melyikAutoMennyi.put(kulcs, 1);
            }
        }
        System.out.println("8.: melyik autó mennyi fuvart teljesített: ");
        for (Map.Entry<String, Integer> entry : melyikAutoMennyi.entrySet()) {
            String kulcs = entry.getKey();
            Integer ertek = entry.getValue();
            System.out.printf("[%s] = %d\n", kulcs, ertek);
        }
    }

}
