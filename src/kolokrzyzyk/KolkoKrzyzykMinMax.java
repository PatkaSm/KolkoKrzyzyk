package kolokrzyzyk;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patrycja
 */
public class KolkoKrzyzykMinMax {

    public static void wypiszTablice(char tab[]) {
        System.out.println("--------------");
        System.out.println(" | " + tab[1] + " | " + tab[2] + " | " + tab[3] + " | ");
        System.out.println("--------------");
        System.out.println(" | " + tab[4] + " | " + tab[5] + " | " + tab[6] + " | ");
        System.out.println("--------------");
        System.out.println(" | " + tab[7] + " | " + tab[8] + " | " + tab[9] + " | ");
        System.out.println("--------------");
    }

    public static boolean CzyWygrana(char tab[], char gracz) {
        boolean test = false;  // przyjmuje true jeśli zawodnik ma 3 figury

        for (int i = 1; i <= 7; i += 3) {
            if ((tab[i] == gracz) && (tab[i + 1] == gracz) && (tab[i + 2] == gracz)) {
                test = true;
            }
        }

        for (int i = 1; i <= 7; i += 3) {
            if ((tab[i] == gracz) && (tab[i + 3] == gracz) && (tab[i + 6] == gracz)) {
                test = true;
            }
        }

        if ((tab[1] == gracz) && (tab[5] == gracz) && (tab[9] == gracz)
                || (tab[3] == gracz) && (tab[5] == gracz) && (tab[7] == gracz)) {
            test = true;
        }

        if (test == true) {
            wypiszTablice(tab);
            System.out.println("Wygrywa :" + gracz);
            return true;
        } else {
            return false;
        }
    }

    public static boolean CzyRemis(char tab[]) {
        if ((tab[1] != ' ' && tab[2] != ' ' && tab[3] != ' ')
                && (tab[4] != ' ' && tab[5] != ' ' && tab[6] != ' ')
                && (tab[7] != ' ' && tab[8] != ' ' && tab[9] != ' ')) {

            System.out.println("Remis !");

            return true;
        }
        return false;
    }

    int minmax(char tab[], char gracz) {

        int minmax, wartosc = 0;

        if (CzyWygrana(tab, gracz) == true) {
            return 1;
        } else if (CzyWygrana(tab, gracz) != true) {
            return -1;
        }

        if (CzyRemis(tab) == true) {
            return 0;
        }

        if (gracz == 'O') {
            gracz = 'K';
        } else {
            gracz = 'O';
        }
       
        return wartosc;

    }

    int komputer(char tab[]) {

        int ruch = 0, i, max , wartosc = 0;


        for (i = 1; i < 10; i++) {

            if (tab[i] == ' ') {
                tab[i] = 'X';
                max = minmax(tab, 'X');
                tab[i] = ' ';
                if (max  > wartosc) {
                    wartosc = max;
                    ruch = i;
                }

            }

        }
        return ruch;
    }
    
    void ruch(char tab[], char gracz){
    
    int pole;
    wypiszTablice(tab);
    if(gracz == 'O'){
    
        System.out.println("Gracz wybiera pole.");
        Scanner input = new Scanner(System.in);
        pole = input.nextInt();
    }
    else {
        System.out.println("Komputer wybiera pole.");
        pole = komputer(tab);
    }

    if(pole >=1 && pole <10 && tab[pole] ==' '){
        tab[pole] = gracz;
        if (gracz == 'O') {
            gracz = 'K';
        } else {
            gracz = 'O';
        }
    } 
    
    }

    public static void main(String[] args) {
        char gracz;
        char[] tab = new char[10];
       
    }
}
