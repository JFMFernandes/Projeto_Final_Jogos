/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto;

/*
*@autor João Fernandes
*/
import java.text.DecimalFormat;
import java.util.*;


public class SlotMachine {

    static Scanner in = new Scanner(System.in);
    static DecimalFormat decimal = new DecimalFormat("#.##");

    private static final double ganho_dois = 2; // taxa para 2 numeros iguais
    private static final double ganho_tres = 3; // taxa para 3 numeros iguais
    private static final int jackpot = 8500; // Jackpot |7|7|7|
    private static int max_aposta = 250; // Valor máximo de cada aposta



    public static double machineSlot(double creditos_slot) {
        int op, continuar = 1;
        double aposta;
        do {
            op = Slot_menu(jackpot, creditos_slot);
            switch (op) {
                case 1:
                    do {
                        aposta = Pedir_aposta(max_aposta, creditos_slot);
                        creditos_slot = Slot(creditos_slot, aposta, jackpot, ganho_dois, ganho_tres);
                        if (creditos_slot != 0) {
                            continuar = Continuar(creditos_slot);
                        } else {
                            continuar = 2;
                        }

                    } while (continuar != 2);
                    op = 2;
                    break;
                case 2:
                    System.out.println("A sair...");
                    System.out.println("");
                    op = 2;
                    break;
                default:
                    System.out.println("Insira uma opção correta.");
                    break;
            }
        } while (op != 2);
        return creditos_slot;
    }




    static int Slot_menu(int jackpot, double creditos_slot) {
        int op;

        System.out.println("****************************************************");
        System.out.println("!!!------------*Olá " + Projeto_Jogos.nome + "*--------------!!!");
        System.out.println("!!!---------*Bem Vindo ao Slot Machine*----------!!!");
        System.out.println("!!!---------------*| 7 | 7 | 7 |*----------------!!!");
        System.out.println("!!!----------*Jackpot de " + jackpot + " créditos*----------!!!");
        System.out.println("!!!----------*você tem " + creditos_slot + " créditos*-----------!!!");
        System.out.println("!!!-------Pretende ir a jogo? (1)Sim (2)Não------!!!");
        System.out.println("****************************************************");
        System.out.print("Opção: ");
        while (! in .hasNextInt()) {
            System.out.println("Erro: Insira um valor correto!");
            System.out.print("Opção: "); in .next();
        }
        op = in .nextInt();
        return op;
    }

    static double Pedir_aposta(int max_aposta, double creditos_slot) {
        double aposta;
        boolean flag = false;
        do {
            aposta = 0;
            System.out.print("Insira o valor da sua aposta (máx." + max_aposta + "): ");
            while (! in .hasNextDouble()) {
                System.out.println("Erro: Insira um valor correto!");
                System.out.print("Insira o valor da sua aposta (máx." + max_aposta + "): "); in .next();
            }
            aposta = in .nextDouble();
            if (aposta > max_aposta || aposta <= 0) {
                System.out.println("!!!------------------VALOR INVÁLIDO--------------!!!");
                flag = false;
            } else if (creditos_slot < aposta) {
                System.out.println("!!!------------------VALOR INVÁLIDO--------------!!!");
                System.out.println("!!!-------------Você tem " + decimal.format(creditos_slot) + " créditos-----------!!!");
                flag = false;
            } else {
                System.out.println("****************************************************");
                System.out.println("!!!---------*Você apostou " + aposta + " créditos*--------!!!");
                flag = true;
            }
        } while (flag == false);
        return aposta;
    }


    static double Slot(double creditos_slot, double aposta, int jackpot, double ganho_dois, double ganho_tres) {

        Random aleatorio = new Random();
        int num1 = aleatorio.nextInt(10) + 1;
        int num2 = aleatorio.nextInt(10) + 1;
        int num3 = aleatorio.nextInt(10) + 1;
        creditos_slot = creditos_slot - aposta;
        System.out.println("!!!--------------Você tem " + decimal.format(creditos_slot) + " créditos-----------!!!");
        System.out.println("!!!----------------*| " + num1 + " | " + num2 + " | " + num3 + " |*---------------!!!");
        if ((num1 == 7) && (num2 == 7) && (num3 == 7)) {
            creditos_slot = creditos_slot + jackpot;
            System.out.println("!!!---**Você ganhou o JACKPOT de " + jackpot + " créditos**---!!!");
        } else if ((num1 == num2) && (num2 == num3)) {
            System.out.println("!!!---------*Você ganhou " + decimal.format(aposta * ganho_tres) + " créditos*----------!!!");
            creditos_slot = creditos_slot + aposta * ganho_tres;
        } else if ((num1 == num2) || (num1 == num3) || (num2 == num3)) {
            creditos_slot = creditos_slot + aposta * ganho_dois;
            System.out.println("!!!---------*Você ganhou " + decimal.format(aposta * ganho_dois) + " créditos*---------!!!");
        } else {
            System.out.println("!!!---------Não ganhou nada tente novamente-------!!!");
        }
        System.out.println("!!!----------Voce ficou com " + decimal.format(creditos_slot) + " créditos--------!!!");
        System.out.println("****************************************************");
        if (creditos_slot <= 0) {
            System.out.println("!!!-------------Créditos insuficientes-----------!!!");
        }
        return creditos_slot;
    }





    static int Continuar(double creditos_slot) {
        int op_update;
        do {
            System.out.println("Prentende continuar? (1)Sim (2)Não");
            System.out.println("Opção: ");
            while (! in .hasNextInt()) {
                System.out.println("Erro: Insira um valor correto!");
                System.out.print("Opção: "); in .next();
            }
            op_update = in .nextInt();
            switch (op_update) {
                case 1:
                    break;
                case 2:
                    System.out.println("!!!----------Você levantou " + decimal.format(creditos_slot) + " créditos--------!!!");
                    System.out.println("!!!-----------0brigado e volte sempre!-----------!!!");
                    break;
                default:
                    break;
            }
        } while (op_update != 1 && op_update != 2);
        return op_update;
    }
}