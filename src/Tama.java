import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tama extends Leny {
    public String nev;
    public int ehseg = -5;
    private final int EHSEG_HATAR = 15;
    public Tama(String nev) {
        this.nev = nev;
        olvas_allapot();
    }

    @Override
    public void ertelmezo() {
        Scanner sc = new Scanner(System.in);
        
        String parancs = "";
        while(!parancs.equals("vege")) {
            System.out.print(this.nev + "> ");
            parancs = sc.nextLine();
            if (parancs.equals("etet")) {
                this.ehseg = this.ehseg - 5;
            }
            if(parancs.equals("vege")) {
                kiir_allapot();
            }
            eheztetes();
            elet_kezeles();
        }

    }
    private void eheztetes() {
        //éheztetés
        this.ehseg++;
        if(this.ehseg > 0) {
            System.out.println("Éhes vagyok!");
        }
    }
    private void elet_kezeles() {
        if(this.ehseg > EHSEG_HATAR) {
            System.out.println("Éhen haltam...");
            System.exit(0);
        }
    }
    private void kiir_allapot() {
        try {
            probal_kiir_allapot();
        } catch (IOException e) {
            System.err.println("Hiba! A fájlba írás sikertelen.");
        }   
    }
    private void probal_kiir_allapot() throws IOException{
        FileWriter fw = new FileWriter("allapot.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(this.ehseg);
        pw.close();
    }
    private void olvas_allapot() {
        try {
            probal_olvas_allapot();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található.");
        }
    }
    private void probal_olvas_allapot() throws FileNotFoundException{
        File f = new File("allapot.txt");
        Scanner sc = new Scanner(f);
        String ehsegStr = sc.nextLine();
        this.ehseg = Integer.parseInt(ehsegStr);
        sc.close();
    }
}
