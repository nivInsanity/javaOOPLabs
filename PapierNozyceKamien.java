import java.util.Scanner;

//sorry for polish language in code - used only because of my college instructions

public class PapierNozyceKamien {

    static String nazwy[] = { "papier", "nozyce", "kamien" };

    static String podajNazwe(int id) {
        return nazwy[id];
    }

    static int losujPrzedmiot() {
        return (int)(Math.random() * 3);
    }

    static int pytanieOPrzedmiot() {
        int przedmiot = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print("Jaki wybierasz przedmiot? ");
            System.out.println("0 - papier, 1 - nozyce, 2 - kamien:");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt() != true) {
                System.out.println("Zła wartość! Podaj właściwy numer!");
                continue;
            }
            przedmiot = sc.nextInt();
            if (przedmiot < 3 && przedmiot > -1) {
                isValid = true;
                continue;
            }
            else {
                System.out.println("Zła wartość! Podaj właściwy numer!");
            }
        }
        return przedmiot;
    }

    static int liczWygrana(int przedmiotGracza, int przedmiotKomputera) {
        if ( (przedmiotGracza == 0 && przedmiotKomputera==2) ||
             (przedmiotGracza == 1 && przedmiotKomputera==0) ||
             (przedmiotGracza == 2 && przedmiotKomputera==1)){
            return 1;
        } else if (przedmiotGracza == przedmiotKomputera) {
            return 0;
        } else {
            return -1;
        }
    }

    static void wypiszWynik(int punkty) {
        if (punkty == 0) {
            System.out.println("Remis");
        } else if (punkty > 0) {
            System.out.println("Gracz wygrywa o " + punkty + " zwycięstwa");
        } else {
            System.out.println("Gracz przegrywa o " + (-punkty) + " wygrane");
        }
    }
    public static void main(String[] args) {
     int punkty = 0;
     do {
         int przedmiotGracza = pytanieOPrzedmiot();
         System.out.println("Gracz wybrał: " + podajNazwe(przedmiotGracza));
         int przedmiotKomputera = losujPrzedmiot();
         System.out.println("Wybrałem: " + podajNazwe(przedmiotKomputera));
         punkty += liczWygrana(przedmiotGracza, przedmiotKomputera);
         wypiszWynik(punkty);
     } while (punkty < 2 && punkty > -2);
     if (punkty == 2) {
         System.out.println("Wygrałeś! Gratulacje!");
     } else {
         System.out.println("Przegrałeś, spróbuj ponownie.");
     }
    }

}
