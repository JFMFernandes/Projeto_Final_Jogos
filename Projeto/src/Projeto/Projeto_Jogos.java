/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Projeto;

/**
 *
 * @author Beatriz Moleirinho & João Fernandes
 */
import java.util.*;
    public class Projeto_Jogos {


        static Scanner in = new Scanner(System.in);
        public static String nome = new String();


        public static void main(String[] args) {

            int op;
            double creditos = 0;
            double update_creditos = 0;

            System.out.print("Indique o seu Nome:");
            while ( in .hasNextDouble()) {
                System.out.println("Erro: Insira um nome!");
                System.out.print("Indique o seu Nome:"); in .next();
            }
            nome = in .nextLine();

            do {
                System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
                System.out.println("» BEM VINDO AO EMULADOR DA SORTE  »");
                System.out.println("«  Escolha uma opção para jogar   «");
                System.out.println("«««««««««««««««««««««««««««««««««««");
                System.out.println("»» Nome: " + nome);
                System.out.println("»» Creditos: " + creditos);
                System.out.println("»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»");
                System.out.println("»» 1 - Slot Machine              ««");
                System.out.println("»» 2 - Sobe e Desce              ««");
                System.out.println("»» 3 - Pedra Papel Tesoura       ««");
                System.out.println("»» 4 - Raspadinha da Sorte       ««");
                System.out.println("»» 5 - Inserir Créditos          ««");
                System.out.println("»» 6 - Consultar Créditos        ««");
                System.out.println("»» 7 - Sair                      ««");
                System.out.println("«««««««««««««««««««««««««««««««««««");
                System.out.println(" ");
                System.out.print("»» Opção:         ");
                while (! in .hasNextInt()) {
                    System.out.println("Erro: Insira um valor correto!");
                    System.out.print("»» Opção:         "); in .next();
                }
                op = in .nextInt();

                switch (op) {
                    case 1:
                        creditos = verificarCreditos(creditos, op, update_creditos);
                        break;
                    case 2:
                        creditos = verificarCreditos(creditos, op, update_creditos);
                        break;
                    case 3:
                        creditos = verificarCreditos(creditos, op, update_creditos);
                        break;
                    case 4:
                        creditos = verificarCreditos(creditos, op, update_creditos);
                        break;
                    case 5:
                        if (creditos <= 0) {
                            do {
                                System.out.print("»» Inserir créditos: ");
                                while (! in .hasNextDouble()) {
                                    System.out.println("Erro: Insira um valor válido");
                                    System.out.print("»» Inserir créditos: "); in .next();
                                }
                                creditos = in .nextDouble();
                            } while (creditos <= 0);
                            System.out.println("»» Seus créditos: " + creditos);
                            System.out.println(" ");

                        } else {
                            do {

                                System.out.print("»» Inserir créditos: ");
                                while (! in .hasNextDouble()) {
                                    System.out.println("Erro: Insira um valor válido!");
                                    System.out.print("»» Inserir créditos: "); in .next();
                                }
                                update_creditos = in .nextDouble();
                            } while (update_creditos <= 0);
                            creditos += update_creditos;

                            System.out.println("»» Seus créditos: " + creditos);
                            System.out.println(" ");
                        }
                        break;
                    case 6:
                        System.out.println("»» Seus créditos: " + creditos);
                        System.out.println(" ");
                        break;
                    case 7:
                        System.out.println("»»  Voce levantou " + creditos + " creditos   ««");
                        System.out.println("»»      Obrigado por jogar       ««");
                        System.out.println("«««««««««««««««««««««««««««««««««««");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("»» Escolha uma opção válida(1-7) ««");
                        break;
                }
            } while (op != 7);
        }




        static double verificarCreditos(double creditos, int op, double update_creditos) {
            if (creditos <= 0) {
                System.out.println("»»  Insira créditos para jogar  ««");
                System.out.println("»» Seus créditos: " + creditos);
                System.out.println(" ");
            } else if (creditos > 0 && op == 1) {
                update_creditos = SlotMachine.machineSlot(creditos);
                creditos = update_creditos;
                System.out.println(" ");
                System.out.println("»» Seus créditos: " + creditos);
                System.out.println(" ");
            } else if (creditos > 0 && op == 2) {
                update_creditos = Sobe_e_Desce.mainSobe(creditos);
                creditos = update_creditos;
                System.out.println(" ");
                System.out.println("»» Seus créditos: " + creditos);
                System.out.println(" ");
            } else if (creditos > 0 && op == 3) {
                update_creditos = Pe_Pa_Te.mainPPT(creditos);
                creditos = update_creditos;
                System.out.println(" ");
                System.out.println("»» Seus créditos: " + creditos);
                System.out.println(" ");
            } else if (creditos > 0 && op == 4) {
                update_creditos = Raspadinha_da_Sorte.mainRaspadinha(creditos);
                creditos = update_creditos;
                System.out.println(" ");
                System.out.println("»» Seus créditos: " + creditos);
                System.out.println(" ");
            }
            return creditos;
        }
    }
