
package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Kocsik {


    public static void main(String[] args) throws IOException {
       Path path = Path.of("fuvarok.csv");
       
       List<String> sorok = Files.readAllLines(path);
       
        for (String sor : sorok) {
            System.out.println("sor: " + sor);
        }
    }
    
}
