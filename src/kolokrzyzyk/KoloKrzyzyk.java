/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolokrzyzyk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Patrycja
 */
public class KoloKrzyzyk {

    public static char[] tab = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    public static Scanner input = new Scanner(System.in);
    public static boolean znak = true;

    public static void wypiszTablice() {
        System.out.println("--------------");
        System.out.println(" | " + tab[1] + " | " + tab[2] + " | " + tab[3] + " | ");
        System.out.println("--------------");
        System.out.println(" | " + tab[4] + " | " + tab[5] + " | " + tab[6] + " | ");
        System.out.println("--------------");
        System.out.println(" | " + tab[7] + " | " + tab[8] + " | " + tab[9] + " | ");
        System.out.println("--------------");
    }

    public static boolean sprawdzWynik() {
        if ((tab[9] == tab[7] && tab[8] == tab[7] && tab[7] != ' ')
                || (tab[6] == tab[5] && tab[4] == tab[5] && tab[6] != ' ')
                || (tab[3] == tab[2] && tab[2] == tab[1] && tab[3] != ' ')
                || (tab[1] == tab[4] && tab[4] == tab[7] && tab[1] != ' ')
                || (tab[2] == tab[5] && tab[5] == tab[8] && tab[2] != ' ')
                || (tab[3] == tab[6] && tab[6] == tab[9] && tab[3] != ' ')
                || (tab[1] == tab[5] && tab[5] == tab[9] && tab[1] != ' ')
                || (tab[3] == tab[5] && tab[5] == tab[7] && tab[3] != ' ')) {
            if (znak) {
                System.out.println("Wygrałeś graczu");
            } else {
                System.out.println("Wygrał komputer ");
            }
            return true;
        }
        if ((tab[1] != ' ' && tab[2] != ' ' && tab[3] != ' ')
                && (tab[4] != ' ' && tab[5] != ' ' && tab[6] != ' ')
                && (tab[7] != ' ' && tab[8] != ' ' && tab[9] != ' ')) {

            System.out.println("Remis !");
            return true;
        }
        znak =!znak;
        return false;
    }

    public static void Gracz() {
        int stop = 0;
        while (stop == 0) {
            int pole = input.nextInt();
            if (pole > 0 && pole < 10) {
                if (tab[pole] == ' ') {
                    tab[pole] = 'O';
                    stop = 1;
                } else {
                    System.out.println("To pole jest zajęte, wybierz inne.");
                }
            }
        }
    }

    public static void Komputer() {

        for (int i = 1; i < 4; i = i + 3) {

            if (tab[i] == tab[i + 1] && tab[i] == 'X' && tab[i + 2] == ' ') {
                tab[i + 2] = 'X';
                return;
            }

            if (tab[i] == tab[i + 2] && tab[i] == 'X' && tab[i + 1] == ' ') {
                tab[i + 1] = 'X';
                return;
            }

            if (tab[i + 2] == tab[i + 1] && tab[i + 1] == 'X' && tab[i] == ' ') {
                tab[i + 1] = 'X';
                return;
            }

            if (tab[i] == tab[i + 3] && tab[i] == 'X' && tab[i + 6] == ' ') {
                tab[i + 6] = 'X';
                return;
            }

            if (tab[i] == tab[i + 6] && tab[i] == 'X' && tab[i + 3] == ' ') {
                tab[i + 3] = 'X';
                return;
            }

            if (tab[i + 6] == tab[i + 3] && tab[i + 3] == 'X' && tab[i] == ' ') {
                tab[i] = 'X';
                return;
            }
       
        }
        //------------------------------------------------------------------------ Przekątne
        if (tab[1] == tab[5] && tab[1] == 'X' && tab[9] == ' ') {
            tab[9] = 'X';
            return;
        }

        if (tab[1] == tab[9] && tab[1] == 'X' && tab[5] == ' ') {
            tab[5] = 'X';
            return;
        }

        if (tab[5] == tab[9] && tab[5] == 'X' && tab[1] == ' ') {
            tab[1] = 'X';
            return;
        }

        if (tab[3] == tab[5] && tab[3] == 'X' && tab[7] == ' ') {
            tab[7] = 'X';
            return;
        }

        if (tab[3] == tab[7] && tab[3] == 'X' && tab[5] == ' ') {
            tab[5] = 'X';
            return;
        }

        if (tab[5] == tab[7] && tab[5] == 'X' && tab[3] == ' ') {
            tab[3] = 'X';
            return;
        }

        //---------------------------------------------------------------------- Blokowanie
        for (int i = 1; i < 4; i = i + 3) {

            if (tab[i] == tab[i + 1] && tab[i] == 'O' && tab[i + 2] == ' ') {
                tab[i + 2] = 'X';
                return;
            }
            if (tab[i] == tab[i + 2] && tab[i] == 'O' && tab[i + 1] == ' ') {
                tab[i + 1] = 'X';
                return;
            }
            if (tab[i + 2] == tab[i + 1] && tab[i + 1] == 'O' && tab[i] == ' ') {
                tab[i + 1] = 'X';
                return;
            }
            if (tab[i] == tab[i + 3] && tab[i] == 'O' && tab[i + 6] == ' ') {
                tab[i + 6] = 'X';
                return;
            }
            if (tab[i] == tab[i + 6] && tab[i] == 'O' && tab[i + 3] == ' ') {
                tab[i + 3] = 'X';
                return;
            }
            if (tab[i + 6] == tab[i + 3] && tab[i + 3] == 'O' && tab[i] == ' ') {
                tab[i] = 'X';
                return;
            }
        }

        if (tab[1] == tab[5] && tab[1] == 'O' && tab[9] == ' ') {
            tab[9] = 'X';
            return;
        }
        if (tab[1] == tab[9] && tab[1] == 'O' && tab[5] == ' ') {
            tab[5] = 'X';
            return;
        }
        if (tab[5] == tab[9] && tab[5] == 'O' && tab[1] == ' ') {
            tab[1] = 'X';
            return;
        }
        if (tab[3] == tab[5] && tab[3] == 'O' && tab[7] == ' ') {
            tab[7] = 'X';
            return;
        }
        if (tab[5] == tab[7] && tab[5] == 'O' && tab[3] == ' ') {
            tab[3] = 'X';
            return;
        }
        if (tab[3] == tab[7] && tab[3] == 'O' && tab[7] == ' ') {
            tab[7] = 'X';
            return;
        } 
        
        else {
        boolean koniec = false;
        Random random = new Random();
        while (koniec == false) {
            int poleK = random.nextInt(9) + 1;
            if (tab[poleK] == ' ') {
                tab[poleK] = 'X';
                koniec = true;
            }
        }
    }}

    public static void main(String[] args) {

        while (sprawdzWynik() == false) {
            wypiszTablice();
            if (znak) {
                Komputer();
            } else {
                Gracz();
            }
        }
        wypiszTablice();
    }
}
