/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import components.Lauta;
import components.Kuningas;
import components.Sotilas;
import components.Lahetti;
import components.Kuningatar;
import components.Nappula;
import components.Torni;
import components.Ratsu;
import java.util.Scanner;
import java.util.regex.*;
import ui.*;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
    }
//        Lauta lauta = new Lauta();
//        lauta.alustaLauta();
//        System.out.println("alustettu");
//        int[] koordinaatit = new int[2];
//        koordinaatit[0] = 0;
//        koordinaatit[1] = 0;
//        System.out.println("Tornit");
//        lauta.aseta(new Torni("valkoinen", lauta), koordinaatit);
//        koordinaatit[0] = 7;
//        lauta.aseta(new Torni("valkoinen", lauta), koordinaatit);
//
//        koordinaatit[1] = 7;
//        lauta.aseta(new Torni("musta", lauta), koordinaatit);
//        koordinaatit[0] = 0;
//        lauta.aseta(new Torni("musta", lauta), koordinaatit);
//        System.out.println("ratsut");
//        koordinaatit[0] = 1;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Ratsu("valkoinen", lauta), koordinaatit);
//        koordinaatit[0] = 6;
//        lauta.aseta(new Ratsu("valkoinen", lauta), koordinaatit);
//
//        koordinaatit[1] = 7;
//        lauta.aseta(new Ratsu("musta", lauta), koordinaatit);
//        koordinaatit[0] = 1;
//        lauta.aseta(new Ratsu("musta", lauta), koordinaatit);
//        System.out.println("lahetit");
//        koordinaatit[0] = 2;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Lahetti("valkoinen", lauta), koordinaatit);
//        koordinaatit[0] = 5;
//        lauta.aseta(new Lahetti("valkoinen", lauta), koordinaatit);
//
//        koordinaatit[1] = 7;
//        lauta.aseta(new Lahetti("musta", lauta), koordinaatit);
//        koordinaatit[0] = 2;
//        lauta.aseta(new Lahetti("musta", lauta), koordinaatit);
//        System.out.println("kuningattaret");
//        koordinaatit[0] = 3;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Kuningatar("valkoinen", lauta), koordinaatit);
//        koordinaatit[1] = 7;
//        lauta.aseta(new Kuningatar("musta", lauta), koordinaatit);
//        System.out.println("kuninkaat");
//        koordinaatit[0] = 4;
//        koordinaatit[1] = 0;
//        lauta.aseta(new Kuningas("valkoinen", lauta), koordinaatit);
//        koordinaatit[1] = 7;
//        lauta.aseta(new Kuningas("musta", lauta), koordinaatit);
//        
//        
//
//        System.out.println("sotilaat");
//        koordinaatit[1] = 1;
//        for (int i = 0; i < 8; i++) {
//            koordinaatit[0] = i;
//            lauta.aseta(new Sotilas("valkoinen", lauta), koordinaatit);
//        }
//        koordinaatit[1] = 6;
//        for (int i = 0; i < 8; i++) {
//            koordinaatit[0] = i;
//            lauta.aseta(new Sotilas("musta", lauta), koordinaatit);
//        }
////        
////        UI ui = new UI(lauta);
////        
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new UI(lauta).setVisible(true);
////            }
////        });
//
//        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;
//
//        String line;
//        Scanner lukija = new Scanner(System.in);
//
//        while (true) {
//            lauta.printBoardState();
////            ui.updateUI();
//            System.out.println("");
//            if (vuoro == Nappula.Puoli.VALKOINEN) {
//                System.out.print("Valkoisen ");
//            } else {
//                System.out.print("Mustan ");
//            }
//            System.out.println("vuoro, komento muotoa d2-d4, tyhjä lopettaa pelin");
//            line = lukija.nextLine();
//            if (line.isEmpty()) {
//                break;
//            }
//            int[][] startEndPoints = lauta.parseCommand(line, vuoro);
//            if (startEndPoints == null) {
//                continue;
//            }
//            if (startEndPoints[0][0] < 8 && startEndPoints[0][0] > -1 && startEndPoints[0][1] < 8 && startEndPoints[0][1] > -1) {
//                Nappula nappula = lauta.getNappula(startEndPoints[0]);
//                if (nappula.getPuoli() != vuoro) {
//                    System.out.println("Ruudussa ei nappulaasi");
//                    continue;
//                }
//                if (Liikkuminen.koitaSiirtya(nappula,startEndPoints[1], lauta)) {
//                    if (vuoro == Nappula.Puoli.VALKOINEN) {
//                        vuoro = Nappula.Puoli.MUSTA;
//                    } else {
//                        vuoro = Nappula.Puoli.VALKOINEN;
//                    }
//                } else {
//                    System.out.print("(" + startEndPoints[0][0] + "," + startEndPoints[0][1] + ")");
//                    System.out.println("-(" + startEndPoints[1][0] + "," + startEndPoints[1][1] + ")");
//                    System.out.println("Laiton siirto");
//                }
//            } else {
//                System.out.println("ruutu "
//                        + "(koordinaatit {" + startEndPoints[0][0] + ","
//                        + startEndPoints[0][1] + "})" + " ei laudalla");
//            }
//        }
//    }
}