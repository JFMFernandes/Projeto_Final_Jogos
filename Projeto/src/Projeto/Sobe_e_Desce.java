/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.*;
import java.math.*;
/**
 *
 * @author Beatriz Moleirinho
 */
public class Sobe_e_Desce {
    static double aposta = 10;
    static Scanner in = new Scanner(System.in);
    static int g = 0, p = 0;
    static Random r = new Random();
    public static String conversor(int carta2) {
        String a;


        if (carta2 > 1 && carta2 < 11) {
            a = String.valueOf(carta2);
        } else if (carta2 == 11) {
            a = "Q";
        } else if (carta2 == 12) {
            a = "J";
        } else if (carta2 == 13) {
            a = "K";
        } else {
            a = "A";
        }
        return a;
    }

    public static double menu(int carta0, double creditos_sd) {
        char op;
        System.out.println(creditos_sd);

        do {
            if (creditos_sd > 0) {
                System.out.println("»» Escolha (S)Sobe ou (D)Desce? ««");
                System.out.println("Use qualquer outra tecla para sair");

                op = in .next().charAt(0);
                if (op == 's') {
                    op = 'S';
                }
                if (op == 'd') {
                    op = 'D';
                }

                int carta2 = cartaR();

                if (op == 'S' && carta2 > carta0) {
                    System.out.println();
                    System.out.println("»»»»Saiu " + conversor(carta2) + " de " + naipes() + "««««");
                    System.out.println(" Subiu! Acertou!");
                    creditos_sd += aposta;
                    System.out.println(Projeto_Jogos.nome + " tem " + creditos_sd + " creditos");
                }
                if (op == 'D' && carta2 < carta0) {
                    System.out.println();
                    System.out.println("»»»»Saiu " + conversor(carta2) + " de " + naipes() + "««««");
                    System.out.println("Desceu! Acertou!");
                    creditos_sd += aposta;

                    System.out.println(Projeto_Jogos.nome + " tem " + creditos_sd + " creditos");
                    g++;

                }
                if (op == 'S' && carta2 < carta0) {
                    System.out.println();
                    System.out.println("»»»»Saiu " + conversor(carta2) + " de " + naipes() + "««««");
                    System.out.println(" Desceu! Errou!");
                    creditos_sd -= aposta;

                    System.out.println(Projeto_Jogos.nome + " tem " + creditos_sd + " creditos");
                    p++;

                }
                if (op == 'D' && carta2 > carta0) {
                    System.out.println();
                    System.out.println("»»»»Saiu " + conversor(carta2) + " de " + naipes() + "««««");
                    System.out.println(" Subiu! Errou!");
                    System.out.println();
                    creditos_sd -= aposta;
                    System.out.println(Projeto_Jogos.nome + " tem " + creditos_sd + " creditos");
                }
                if (carta2 == carta0) {
                    System.out.println();
                    System.out.println("»»»»Saiu " + conversor(carta2) + " de " + naipes() + "««««");
                    System.out.println("Igualou! Nova oportunidade");
                    System.out.println();
                    System.out.println(Projeto_Jogos.nome + " tem " + creditos_sd + " creditos");
                }
                carta0 = carta2;
            } else {
                break;
            }
        } while (op == 'S' || op == 'D');
        System.out.println("Saíndo..." + creditos_sd);
        return creditos_sd;
    }
    public static String naipes() {

        String[] cartasT = {
            "Paus",
            "Copas",
            "Ouros",
            "Espadas"
        };
        int rand = ThreadLocalRandom.current().nextInt(cartasT.length);
        String naipeR = cartasT[rand];

        return naipeR;
    }

    public static int cartaR() {
        int[] cartaL = {
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12,
            13,
            14
        };
        int rand = ThreadLocalRandom.current().nextInt(cartaL.length);
        int cartaEsc = cartaL[rand];

        return cartaEsc;
    }

    public static double mainSobe(double creditos_sd) {

        double creditosf = creditos_sd;
        System.out.println("Olá " + Projeto_Jogos.nome + "!");

        System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
        System.out.println("»»   Bem-vindo ao Sobe e Desce  ««");
        System.out.println("««««««««««««««««««««««««««««««««««");

        int carta0 = cartaR();

        System.out.println();
        System.out.println("»»»»Saiu " + conversor(carta0) + " de " + naipes() + "««««");
        creditosf = menu(carta0, creditos_sd);


        return creditosf;
    }
}