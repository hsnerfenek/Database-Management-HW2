import java.util.ArrayList;

/**
 * Created by Hasan on 10/4/2017.
 */
public class DatabaseHafta2Odev {

    public static void main(String[] args) {

        int[][] tablo = new int[][] {
                new int[] { 1, 10, 11, 12},
                new int[] { 2, 2, 3, 3},
                new int[] { 3, 4, 3, 1},
                new int[] { 5, 2, 1, 4},
                new int[] { 1, 2, 3, 1},
                new int[] { 3, 2, 3, 6},

        };

        matrisTekrarListele(tablo);

    }

    static public void matrisTekrarListele(int[][] matris)
    {
        for (int sayacSatir =0; sayacSatir < matris[0].length; sayacSatir++)
        {
            ArrayList<Integer> tekrarEtmeyenler = new ArrayList<Integer>();
            ArrayList<Integer> tekrarEdenler = new ArrayList<Integer>();
            for (int sayacSütun = 0; sayacSütun < matris.length; sayacSütun++)
            {
                listeyeEkle(matris[sayacSütun][sayacSatir],tekrarEtmeyenler,tekrarEdenler);
                System.out.println();
            }
            System.out.print(sayacSatir+1 +". sütunda tekrar etmeyen elemanlar: ");
            for (int sayac = 0; sayac< tekrarEtmeyenler.size(); sayac++)
                System.out.print(tekrarEtmeyenler.get(sayac)+ ", ");
            System.out.print("\nTekrar edenler: ");
            for (int sayac = 0; sayac < tekrarEdenler.size(); sayac++)
                System.out.print(tekrarEdenler.get(sayac) + ", ");
            System.out.print("\n");
        }
    }
    static public void listeyeEkle(int sayi, ArrayList<Integer> tekrarEtmeyenler, ArrayList<Integer> tekrarEdenler)
    {
        if (tekrarEtmeyenler.isEmpty())
        {
            tekrarEtmeyenler.add(sayi);
            return;
        }
        for (int sayac=0; sayac <tekrarEtmeyenler.size(); sayac++)
        {
            int sayi2 = tekrarEtmeyenler.get(sayac);
            if (sayi2 == sayi)
            {
                tekrarEtmeyenler.remove(sayac);
                tekrarEdenListeyeElemanEkle(sayi,tekrarEdenler);
                return;
            }
        }
        for (int sayac = 0; sayac < tekrarEdenler.size(); sayac++)
            if (tekrarEdenler.get(sayac) == sayi)
                return;
        tekrarEtmeyenListeyeElemanEkle(sayi,tekrarEtmeyenler);
        return;
    }
    static public void tekrarEtmeyenListeyeElemanEkle(int sayi,ArrayList<Integer> tekrarEtmeyenler)
    {
        int sayi2 = tekrarEtmeyenler.get(0),sayac = 0;
        while(sayi2 < sayi && sayac < tekrarEtmeyenler.size())
        {
            sayac++;
            if (sayac < tekrarEtmeyenler.size())
                sayi2 = tekrarEtmeyenler.get(sayac);
        }
        tekrarEtmeyenler.add(sayac,sayi);
        return;
    }
    static public void tekrarEdenListeyeElemanEkle(int sayi,ArrayList<Integer> tekrarEdenler)
    {
        if (tekrarEdenler.isEmpty())
        {
            tekrarEdenler.add(sayi);
            return;
        }
        int sayi2 = tekrarEdenler.get(0);
        int sayac = 0;
        while(sayi2 < sayi && sayac < tekrarEdenler.size())
        {
            sayac++;
            if (sayac < tekrarEdenler.size())
                sayi2 = tekrarEdenler.get(sayac);
            if (sayi2 == sayi)
                return;
        }
        tekrarEdenler.add(sayac,sayi);
        return;

    }
}
