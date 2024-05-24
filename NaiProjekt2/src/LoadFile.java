import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoadFile {
    private String fileName;
    private int pojemnoscPlecaka;
    private int liczbaPrzedmiotow;
    private ArrayList<WartoscWaga> wartosciWagi = new ArrayList<>();
    LoadFile(String fileName){
        this.fileName = fileName;
        File file = new File("C:\\Users\\Grzegorz\\Desktop\\" + fileName);
        try {
            Scanner scanner = new Scanner(file);
            int num = 1;
            String[] kn = null;
            String[] wartosci = null;
            String[] wagi = null;
            while(scanner.hasNextLine()){
                if(num == 1){
                    kn = scanner.nextLine().split(" ");
                }
                if(num == 2){
                    wartosci = scanner.nextLine().split(",");
                }
                if(num == 3){
                    wagi = scanner.nextLine().split(",");
                }
                num++;
            }
            this.pojemnoscPlecaka = Integer.parseInt(kn[0]);
            this.liczbaPrzedmiotow = Integer.parseInt(kn[1]);
            for (int i = 0; i < liczbaPrzedmiotow; i++){
                int num1 = Integer.parseInt(wartosci[i]);
                int num2 = Integer.parseInt(wagi[i]);
                wartosciWagi.add(new WartoscWaga(num1,num2));
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPojemnoscPlecaka() {
        return pojemnoscPlecaka;
    }

    public int getLiczbaPrzedmiotow() {
        return liczbaPrzedmiotow;
    }

    public ArrayList<WartoscWaga> getWartosciWagi() {
        return wartosciWagi;
    }
}
