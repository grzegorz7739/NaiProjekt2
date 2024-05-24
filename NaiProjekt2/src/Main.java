import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LoadFile loadFile = new LoadFile("plecak.txt");
        int pojemnoscPlecaka = loadFile.getPojemnoscPlecaka();
        int liczbaPrzedmiotow = loadFile.getLiczbaPrzedmiotow();
        int[] wartosci = new int[liczbaPrzedmiotow];
        int[] wagi = new int[liczbaPrzedmiotow];
        ArrayList<ArrayList<Integer>> listaRozwiazan = new ArrayList<>();
        ArrayList<WartoscWaga> lista = loadFile.getWartosciWagi();

        for (int i = 0 ; i <  liczbaPrzedmiotow; i++) {
            wartosci[i] = lista.get(i).getWartosc();
            wagi[i] = lista.get(i).getWaga();
        }

        int maxWeight = 0;
        ArrayList<Integer> maxSubset = new ArrayList<>();
        int maxIter = 0;

        for (int i = 0; i < (1<<25); i++)
        {
            StringBuilder str = new StringBuilder();
            str.append(i + ". ");

            int allValue = 0;
            int allWeight = 0;
            ArrayList<Integer> subsetNow = new ArrayList<>();
            for (int j = 0; j < 25; j++) {

                if ((i & (1 << j)) > 0) {
                    str.append(wartosci[j] + ", ");
                    subsetNow.add(wartosci[j]);
                    allValue += wartosci[j];
                    allWeight += wagi[j];
                }
            }
            if (allValue <= pojemnoscPlecaka){
                listaRozwiazan.add(subsetNow);
                System.out.println(String.format("%-40s %-20s %-20s" ,str,allWeight,allValue));
                if (allWeight > maxWeight){
                    maxWeight = allWeight;
                    maxSubset = subsetNow;
                    maxIter = i;
                }
            }
        }
        StringBuilder str = new StringBuilder(Integer.toBinaryString(maxIter));
        System.out.println("Maksymalna waga to: " + maxWeight + " Wektor dla tej wagi to: " +  maxSubset);
        System.out.println(str.reverse() + " Maksymalna iteracja " + maxIter);



    }

}