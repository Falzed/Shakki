package ui;

import components.Kuningas;
import components.Kuningatar;
import components.Lahetti;
import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import components.Lauta;
import components.Nappula;
import components.Ratsu;
import components.Sotilas;
import components.Torni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import logic.Liikkuminen;
import logic.Parser;

/**
 * Luokka toteuttaa ohjelman graafisen käyttöliittymän.
 * @author oemkulma
 */
public class UI extends javax.swing.JFrame {

    /**
     *
     */
    public UI() {
        initComponents();
    }

    //Netbeansin generoimaa, refaktoroin toivottavasti myöhemmin luettavampaan muotoon
    @SuppressWarnings("unchecked")
    private void initComponents() {
        lauta = new Lauta();
        lauta.alustaLauta();
        variants.Standard.setUp(lauta);
        vuoro = Nappula.Puoli.VALKOINEN;

        a1 = new javax.swing.JPanel();
        Dimension dimension = new Dimension(100, 100);
        a1.setMinimumSize(dimension);
        a2 = new javax.swing.JPanel();
        a2.setMinimumSize(dimension);
        a3 = new javax.swing.JPanel();
        a3.setMinimumSize(dimension);
        a4 = new javax.swing.JPanel();
        a5 = new javax.swing.JPanel();
        a6 = new javax.swing.JPanel();
        a7 = new javax.swing.JPanel();
        a8 = new javax.swing.JPanel();

        b1 = new javax.swing.JPanel();
        b2 = new javax.swing.JPanel();
        b3 = new javax.swing.JPanel();
        b4 = new javax.swing.JPanel();
        b5 = new javax.swing.JPanel();
        b6 = new javax.swing.JPanel();
        b7 = new javax.swing.JPanel();
        b8 = new javax.swing.JPanel();

        c1 = new javax.swing.JPanel();
        c2 = new javax.swing.JPanel();
        c3 = new javax.swing.JPanel();
        c4 = new javax.swing.JPanel();
        c5 = new javax.swing.JPanel();
        c6 = new javax.swing.JPanel();
        c7 = new javax.swing.JPanel();
        c8 = new javax.swing.JPanel();

        d1 = new javax.swing.JPanel();
        d2 = new javax.swing.JPanel();
        d3 = new javax.swing.JPanel();
        d4 = new javax.swing.JPanel();
        d5 = new javax.swing.JPanel();
        d6 = new javax.swing.JPanel();
        d7 = new javax.swing.JPanel();
        d8 = new javax.swing.JPanel();

        e1 = new javax.swing.JPanel();
        e2 = new javax.swing.JPanel();
        e3 = new javax.swing.JPanel();
        e4 = new javax.swing.JPanel();
        e5 = new javax.swing.JPanel();
        e6 = new javax.swing.JPanel();
        e7 = new javax.swing.JPanel();
        e8 = new javax.swing.JPanel();

        f1 = new javax.swing.JPanel();
        f2 = new javax.swing.JPanel();
        f3 = new javax.swing.JPanel();
        f4 = new javax.swing.JPanel();
        f5 = new javax.swing.JPanel();
        f6 = new javax.swing.JPanel();
        f7 = new javax.swing.JPanel();
        f8 = new javax.swing.JPanel();

        g1 = new javax.swing.JPanel();
        g2 = new javax.swing.JPanel();
        g3 = new javax.swing.JPanel();
        g4 = new javax.swing.JPanel();
        g5 = new javax.swing.JPanel();
        g6 = new javax.swing.JPanel();
        g7 = new javax.swing.JPanel();
        g8 = new javax.swing.JPanel();

        h1 = new javax.swing.JPanel();
        h2 = new javax.swing.JPanel();
        h3 = new javax.swing.JPanel();
        h4 = new javax.swing.JPanel();
        h5 = new javax.swing.JPanel();
        h6 = new javax.swing.JPanel();
        h7 = new javax.swing.JPanel();
        h8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        a1.setBackground(new java.awt.Color(210, 140, 70));
        a2.setBackground(new java.awt.Color(255, 255, 255));
        a3.setBackground(new java.awt.Color(210, 140, 70));
        a4.setBackground(new java.awt.Color(255, 255, 255));
        a5.setBackground(new java.awt.Color(210, 140, 70));
        a6.setBackground(new java.awt.Color(255, 255, 255));
        a7.setBackground(new java.awt.Color(210, 140, 70));
        a8.setBackground(new java.awt.Color(255, 255, 255));

        b1.setBackground(new java.awt.Color(255, 255, 255));
        b2.setBackground(new java.awt.Color(210, 140, 70));
        b3.setBackground(new java.awt.Color(255, 255, 255));
        b4.setBackground(new java.awt.Color(210, 140, 70));
        b5.setBackground(new java.awt.Color(255, 255, 255));
        b6.setBackground(new java.awt.Color(210, 140, 70));
        b7.setBackground(new java.awt.Color(255, 255, 255));
        b8.setBackground(new java.awt.Color(210, 140, 70));

        c1.setBackground(new java.awt.Color(210, 140, 70));
        c2.setBackground(new java.awt.Color(255, 255, 255));
        c3.setBackground(new java.awt.Color(210, 140, 70));
        c4.setBackground(new java.awt.Color(255, 255, 255));
        c5.setBackground(new java.awt.Color(210, 140, 70));
        c6.setBackground(new java.awt.Color(255, 255, 255));
        c7.setBackground(new java.awt.Color(210, 140, 70));
        c8.setBackground(new java.awt.Color(255, 255, 255));

        d1.setBackground(new java.awt.Color(255, 255, 255));
        d2.setBackground(new java.awt.Color(210, 140, 70));
        d3.setBackground(new java.awt.Color(255, 255, 255));
        d4.setBackground(new java.awt.Color(210, 140, 70));
        d5.setBackground(new java.awt.Color(255, 255, 255));
        d6.setBackground(new java.awt.Color(210, 140, 70));
        d7.setBackground(new java.awt.Color(255, 255, 255));
        d8.setBackground(new java.awt.Color(210, 140, 70));

        e1.setBackground(new java.awt.Color(210, 140, 70));
        e2.setBackground(new java.awt.Color(255, 255, 255));
        e3.setBackground(new java.awt.Color(210, 140, 70));
        e4.setBackground(new java.awt.Color(255, 255, 255));
        e5.setBackground(new java.awt.Color(210, 140, 70));
        e6.setBackground(new java.awt.Color(255, 255, 255));
        e7.setBackground(new java.awt.Color(210, 140, 70));
        e8.setBackground(new java.awt.Color(255, 255, 255));

        f1.setBackground(new java.awt.Color(255, 255, 255));
        f2.setBackground(new java.awt.Color(210, 140, 70));
        f3.setBackground(new java.awt.Color(255, 255, 255));
        f4.setBackground(new java.awt.Color(210, 140, 70));
        f5.setBackground(new java.awt.Color(255, 255, 255));
        f6.setBackground(new java.awt.Color(210, 140, 70));
        f7.setBackground(new java.awt.Color(255, 255, 255));
        f8.setBackground(new java.awt.Color(210, 140, 70));

        g1.setBackground(new java.awt.Color(210, 140, 70));
        g2.setBackground(new java.awt.Color(255, 255, 255));
        g3.setBackground(new java.awt.Color(210, 140, 70));
        g4.setBackground(new java.awt.Color(255, 255, 255));
        g5.setBackground(new java.awt.Color(210, 140, 70));
        g6.setBackground(new java.awt.Color(255, 255, 255));
        g7.setBackground(new java.awt.Color(210, 140, 70));
        g8.setBackground(new java.awt.Color(255, 255, 255));

        h1.setBackground(new java.awt.Color(255, 255, 255));
        h2.setBackground(new java.awt.Color(210, 140, 70));
        h3.setBackground(new java.awt.Color(255, 255, 255));
        h4.setBackground(new java.awt.Color(210, 140, 70));
        h5.setBackground(new java.awt.Color(255, 255, 255));
        h6.setBackground(new java.awt.Color(210, 140, 70));
        h7.setBackground(new java.awt.Color(255, 255, 255));
        h8.setBackground(new java.awt.Color(210, 140, 70));

        String merkki = Character.toString('\u265A');

        merkki = Character.toString('\u2656');
        a1label = new JLabel(merkki);
        a1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a1label.setFont(new Font("Unifont", 1, 50));
        a1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        a2label = new JLabel(merkki);
        a2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a2label.setFont(new Font("Unifont", 1, 50));
        a2.setPreferredSize(dimension);

        a3label = new JLabel("");
        a3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a3label.setFont(new Font("Unifont", 1, 50));
        a3.setPreferredSize(dimension);

        a4label = new JLabel("");
        a4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a4label.setFont(new Font("Unifont", 1, 50));
        a4.setPreferredSize(dimension);

        a5label = new JLabel("");
        a5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a5label.setFont(new Font("Unifont", 1, 50));
        a5.setPreferredSize(dimension);

        a6label = new JLabel("");
        a6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a6label.setFont(new Font("Unifont", 1, 50));
        a6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        a7label = new JLabel(merkki);
        a7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a7label.setFont(new Font("Unifont", 1, 50));
        a7.setPreferredSize(dimension);

        merkki = Character.toString('\u265C');
        a8label = new JLabel(merkki);
        a8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a8label.setFont(new Font("Unifont", 1, 50));
        a8.setPreferredSize(dimension);

        merkki = Character.toString('\u2657');
        b1label = new JLabel(merkki);
        b1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b1label.setFont(new Font("Unifont", 1, 50));
        b1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        b2label = new JLabel(merkki);
        b2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b2label.setFont(new Font("Unifont", 1, 50));
        b2.setPreferredSize(dimension);

        b3label = new JLabel("");
        b3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b3label.setFont(new Font("Unifont", 1, 50));
        b3.setPreferredSize(dimension);

        b4label = new JLabel("");
        b4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b4label.setFont(new Font("Unifont", 1, 50));
        b4.setPreferredSize(dimension);

        b5label = new JLabel("");
        b5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b5label.setFont(new Font("Unifont", 1, 50));
        b5.setPreferredSize(dimension);

        b6label = new JLabel("");
        b6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b6label.setFont(new Font("Unifont", 1, 50));
        b6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        b7label = new JLabel(merkki);
        b7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b7label.setFont(new Font("Unifont", 1, 50));
        b7.setPreferredSize(dimension);

        merkki = Character.toString('\u265E');
        b8label = new JLabel(merkki);
        b8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b8label.setFont(new Font("Unifont", 1, 50));
        b8.setPreferredSize(dimension);

        merkki = Character.toString('\u2657');
        c1label = new JLabel(merkki);
        c1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c1label.setFont(new Font("Unifont", 1, 50));
        c1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        c2label = new JLabel(merkki);
        c2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c2label.setFont(new Font("Unifont", 1, 50));
        c2.setPreferredSize(dimension);

        c3label = new JLabel("");
        c3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c3label.setFont(new Font("Unifont", 1, 50));
        c3.setPreferredSize(dimension);

        c4label = new JLabel("");
        c4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c4label.setFont(new Font("Unifont", 1, 50));
        c4.setPreferredSize(dimension);

        c5label = new JLabel("");
        c5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c5label.setFont(new Font("Unifont", 1, 50));
        c5.setPreferredSize(dimension);

        c6label = new JLabel("");
        c6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c6label.setFont(new Font("Unifont", 1, 50));
        c6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        c7label = new JLabel(merkki);
        c7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c7label.setFont(new Font("Unifont", 1, 50));
        c7.setPreferredSize(dimension);

        merkki = Character.toString('\u265D');
        c8label = new JLabel(merkki);
        c8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c8label.setFont(new Font("Unifont", 1, 50));
        c8.setPreferredSize(dimension);

        merkki = Character.toString('\u2655');
        d1label = new JLabel(merkki);
        d1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d1label.setFont(new Font("Unifont", 1, 50));
        d1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        d2label = new JLabel(merkki);
        d2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d2label.setFont(new Font("Unifont", 1, 50));
        d2.setPreferredSize(dimension);

        d3label = new JLabel("");
        d3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d3label.setFont(new Font("Unifont", 1, 50));
        d3.setPreferredSize(dimension);

        d4label = new JLabel("");
        d4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d4label.setFont(new Font("Unifont", 1, 50));
        d4.setPreferredSize(dimension);

        d5label = new JLabel("");
        d5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d5label.setFont(new Font("Unifont", 1, 50));
        d5.setPreferredSize(dimension);

        d6label = new JLabel("");
        d6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d6label.setFont(new Font("Unifont", 1, 50));
        d6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        d7label = new JLabel(merkki);
        d7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d7label.setFont(new Font("Unifont", 1, 50));
        d7.setPreferredSize(dimension);

        merkki = Character.toString('\u265B');
        d8label = new JLabel(merkki);
        d8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d8label.setFont(new Font("Unifont", 1, 50));
        d8.setPreferredSize(dimension);

        merkki = Character.toString('\u2654');
        e1label = new JLabel(merkki);
        e1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e1label.setFont(new Font("Unifont", 1, 50));
        e1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        e2label = new JLabel(merkki);
        e2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e2label.setFont(new Font("Unifont", 1, 50));
        e2.setPreferredSize(dimension);

        e3label = new JLabel("");
        e3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e3label.setFont(new Font("Unifont", 1, 50));
        e3.setPreferredSize(dimension);

        e4label = new JLabel("");
        e4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e4label.setFont(new Font("Unifont", 1, 50));
        e4.setPreferredSize(dimension);

        e5label = new JLabel("");
        e5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e5label.setFont(new Font("Unifont", 1, 50));
        e5.setPreferredSize(dimension);

        e6label = new JLabel("");
        e6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e6label.setFont(new Font("Unifont", 1, 50));
        e6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        e7label = new JLabel(merkki);
        e7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e7label.setFont(new Font("Unifont", 1, 50));
        e7.setPreferredSize(dimension);

        merkki = Character.toString('\u265A');
        e8label = new JLabel(merkki);
        e8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        e8label.setFont(new Font("Unifont", 1, 50));
        e8.setPreferredSize(dimension);

        merkki = Character.toString('\u2657');
        f1label = new JLabel(merkki);
        f1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f1label.setFont(new Font("Unifont", 1, 50));
        f1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        f2label = new JLabel(merkki);
        f2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f2label.setFont(new Font("Unifont", 1, 50));
        f2.setPreferredSize(dimension);

        f3label = new JLabel("");
        f3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f3label.setFont(new Font("Unifont", 1, 50));
        f3.setPreferredSize(dimension);

        f4label = new JLabel("");
        f4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f4label.setFont(new Font("Unifont", 1, 50));
        f4.setPreferredSize(dimension);

        f5label = new JLabel("");
        f5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f5label.setFont(new Font("Unifont", 1, 50));
        f5.setPreferredSize(dimension);

        f6label = new JLabel("");
        f6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f6label.setFont(new Font("Unifont", 1, 50));
        f6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        f7label = new JLabel(merkki);
        f7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f7label.setFont(new Font("Unifont", 1, 50));
        f7.setPreferredSize(dimension);

        merkki = Character.toString('\u265D');
        f8label = new JLabel(merkki);
        f8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f8label.setFont(new Font("Unifont", 1, 50));
        f8.setPreferredSize(dimension);

        merkki = Character.toString('\u2658');
        g1label = new JLabel(merkki);
        g1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g1label.setFont(new Font("Unifont", 1, 50));
        g1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        g2label = new JLabel(merkki);
        g2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g2label.setFont(new Font("Unifont", 1, 50));
        g2.setPreferredSize(dimension);

        g3label = new JLabel("");
        g3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g3label.setFont(new Font("Unifont", 1, 50));
        g3.setPreferredSize(dimension);

        g4label = new JLabel("");
        g4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g4label.setFont(new Font("Unifont", 1, 50));
        g4.setPreferredSize(dimension);

        g5label = new JLabel("");
        g5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g5label.setFont(new Font("Unifont", 1, 50));
        g5.setPreferredSize(dimension);

        g6label = new JLabel("");
        g6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g6label.setFont(new Font("Unifont", 1, 50));
        g6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        g7label = new JLabel(merkki);
        g7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g7label.setFont(new Font("Unifont", 1, 50));
        g7.setPreferredSize(dimension);

        merkki = Character.toString('\u265E');
        g8label = new JLabel(merkki);
        g8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        g8label.setFont(new Font("Unifont", 1, 50));
        g8.setPreferredSize(dimension);

        merkki = Character.toString('\u2656');
        h1label = new JLabel(merkki);
        h1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h1label.setFont(new Font("Unifont", 1, 50));
        h1.setPreferredSize(dimension);

        merkki = Character.toString('\u2659');
        h2label = new JLabel(merkki);
        h2label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h2label.setFont(new Font("Unifont", 1, 50));
        h2.setPreferredSize(dimension);

        h3label = new JLabel("");
        h3label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h3label.setFont(new Font("Unifont", 1, 50));
        h3.setPreferredSize(dimension);

        h4label = new JLabel("");
        h4label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h4label.setFont(new Font("Unifont", 1, 50));
        h4.setPreferredSize(dimension);

        h5label = new JLabel("");
        h5label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h5label.setFont(new Font("Unifont", 1, 50));
        h5.setPreferredSize(dimension);

        h6label = new JLabel("");
        h6label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h6label.setFont(new Font("Unifont", 1, 50));
        h6.setPreferredSize(dimension);

        merkki = Character.toString('\u265F');
        h7label = new JLabel(merkki);
        h7label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h7label.setFont(new Font("Unifont", 1, 50));
        h7.setPreferredSize(dimension);

        merkki = Character.toString('\u265C');
        h8label = new JLabel(merkki);
        h8label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        h8label.setFont(new Font("Unifont", 1, 50));
        h8.setPreferredSize(dimension);

        javax.swing.GroupLayout a1Layout = new javax.swing.GroupLayout(a1);
        a1.setLayout(a1Layout);
        a1Layout.setHorizontalGroup(
                a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a1label));
        a1Layout.setVerticalGroup(
                a1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a2Layout = new javax.swing.GroupLayout(a2);
        a2.setLayout(a2Layout);
        a2Layout.setHorizontalGroup(
                a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a2label));
        a2Layout.setVerticalGroup(
                a2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a3Layout = new javax.swing.GroupLayout(a3);
        a3.setLayout(a3Layout);
        a3Layout.setHorizontalGroup(
                a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a3label));
        a3Layout.setVerticalGroup(
                a3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a4Layout = new javax.swing.GroupLayout(a4);
        a4.setLayout(a4Layout);
        a4Layout.setHorizontalGroup(
                a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a4label));
        a4Layout.setVerticalGroup(
                a4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a5Layout = new javax.swing.GroupLayout(a5);
        a5.setLayout(a5Layout);
        a5Layout.setHorizontalGroup(
                a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a5label));
        a5Layout.setVerticalGroup(
                a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a6Layout = new javax.swing.GroupLayout(a6);
        a6.setLayout(a6Layout);
        a6Layout.setHorizontalGroup(
                a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a6label));
        a6Layout.setVerticalGroup(
                a6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a7Layout = new javax.swing.GroupLayout(a7);
        a7.setLayout(a7Layout);
        a7Layout.setHorizontalGroup(
                a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a7label));
        a7Layout.setVerticalGroup(
                a7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout a8Layout = new javax.swing.GroupLayout(a8);
        a8.setLayout(a8Layout);
        a8Layout.setHorizontalGroup(
                a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(a8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(a8label));
        a8Layout.setVerticalGroup(
                a8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(a8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(a8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout b1Layout = new javax.swing.GroupLayout(b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(
                b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b1label));
        b1Layout.setVerticalGroup(
                b1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b2Layout = new javax.swing.GroupLayout(b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(
                b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b2label));
        b2Layout.setVerticalGroup(
                b2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b3Layout = new javax.swing.GroupLayout(b3);
        b3.setLayout(b3Layout);
        b3Layout.setHorizontalGroup(
                b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b3label));
        b3Layout.setVerticalGroup(
                b3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b4Layout = new javax.swing.GroupLayout(b4);
        b4.setLayout(b4Layout);
        b4Layout.setHorizontalGroup(
                b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b4label));
        b4Layout.setVerticalGroup(
                b4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b5Layout = new javax.swing.GroupLayout(b5);
        b5.setLayout(b5Layout);
        b5Layout.setHorizontalGroup(
                b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b5label));
        b5Layout.setVerticalGroup(
                b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b6Layout = new javax.swing.GroupLayout(b6);
        b6.setLayout(b6Layout);
        b6Layout.setHorizontalGroup(
                b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b6label));
        b6Layout.setVerticalGroup(
                b6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b7Layout = new javax.swing.GroupLayout(b7);
        b7.setLayout(b7Layout);
        b7Layout.setHorizontalGroup(
                b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b7label));
        b7Layout.setVerticalGroup(
                b7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout b8Layout = new javax.swing.GroupLayout(b8);
        b8.setLayout(b8Layout);
        b8Layout.setHorizontalGroup(
                b8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(b8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(b8label));
        b8Layout.setVerticalGroup(
                b8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(b8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(b8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout c1Layout = new javax.swing.GroupLayout(c1);
        c1.setLayout(c1Layout);
        c1Layout.setHorizontalGroup(
                c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c1label));
        c1Layout.setVerticalGroup(
                c1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c2Layout = new javax.swing.GroupLayout(c2);
        c2.setLayout(c2Layout);
        c2Layout.setHorizontalGroup(
                c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c2label));
        c2Layout.setVerticalGroup(
                c2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c3Layout = new javax.swing.GroupLayout(c3);
        c3.setLayout(c3Layout);
        c3Layout.setHorizontalGroup(
                c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c3label));
        c3Layout.setVerticalGroup(
                c3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c4Layout = new javax.swing.GroupLayout(c4);
        c4.setLayout(c4Layout);
        c4Layout.setHorizontalGroup(
                c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c4label));
        c4Layout.setVerticalGroup(
                c4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
        c5.setLayout(c5Layout);
        c5Layout.setHorizontalGroup(
                c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c5label));
        c5Layout.setVerticalGroup(
                c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c6Layout = new javax.swing.GroupLayout(c6);
        c6.setLayout(c6Layout);
        c6Layout.setHorizontalGroup(
                c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c6label));
        c6Layout.setVerticalGroup(
                c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c7Layout = new javax.swing.GroupLayout(c7);
        c7.setLayout(c7Layout);
        c7Layout.setHorizontalGroup(
                c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c7label));
        c7Layout.setVerticalGroup(
                c7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout c8Layout = new javax.swing.GroupLayout(c8);
        c8.setLayout(c8Layout);
        c8Layout.setHorizontalGroup(
                c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(c8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(c8label));
        c8Layout.setVerticalGroup(
                c8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(c8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(c8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout d1Layout = new javax.swing.GroupLayout(d1);
        d1.setLayout(d1Layout);
        d1Layout.setHorizontalGroup(
                d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d1label));
        d1Layout.setVerticalGroup(
                d1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d2Layout = new javax.swing.GroupLayout(d2);
        d2.setLayout(d2Layout);
        d2Layout.setHorizontalGroup(
                d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d2label));
        d2Layout.setVerticalGroup(
                d2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d3Layout = new javax.swing.GroupLayout(d3);
        d3.setLayout(d3Layout);
        d3Layout.setHorizontalGroup(
                d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d3label));
        d3Layout.setVerticalGroup(
                d3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d4Layout = new javax.swing.GroupLayout(d4);
        d4.setLayout(d4Layout);
        d4Layout.setHorizontalGroup(
                d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d4label));
        d4Layout.setVerticalGroup(
                d4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d5Layout = new javax.swing.GroupLayout(d5);
        d5.setLayout(d5Layout);
        d5Layout.setHorizontalGroup(
                d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d5label));
        d5Layout.setVerticalGroup(
                d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d6Layout = new javax.swing.GroupLayout(d6);
        d6.setLayout(d6Layout);
        d6Layout.setHorizontalGroup(
                d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d6label));
        d6Layout.setVerticalGroup(
                d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d7Layout = new javax.swing.GroupLayout(d7);
        d7.setLayout(d7Layout);
        d7Layout.setHorizontalGroup(
                d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d7label));
        d7Layout.setVerticalGroup(
                d7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout d8Layout = new javax.swing.GroupLayout(d8);
        d8.setLayout(d8Layout);
        d8Layout.setHorizontalGroup(
                d8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(d8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(d8label));
        d8Layout.setVerticalGroup(
                d8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(d8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(d8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout e1Layout = new javax.swing.GroupLayout(e1);
        e1.setLayout(e1Layout);
        e1Layout.setHorizontalGroup(
                e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e1label));
        e1Layout.setVerticalGroup(
                e1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e2Layout = new javax.swing.GroupLayout(e2);
        e2.setLayout(e2Layout);
        e2Layout.setHorizontalGroup(
                e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e2label));
        e2Layout.setVerticalGroup(
                e2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e3Layout = new javax.swing.GroupLayout(e3);
        e3.setLayout(e3Layout);
        e3Layout.setHorizontalGroup(
                e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e3label));
        e3Layout.setVerticalGroup(
                e3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e4Layout = new javax.swing.GroupLayout(e4);
        e4.setLayout(e4Layout);
        e4Layout.setHorizontalGroup(
                e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e4label));
        e4Layout.setVerticalGroup(
                e4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e5Layout = new javax.swing.GroupLayout(e5);
        e5.setLayout(e5Layout);
        e5Layout.setHorizontalGroup(
                e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e5label));
        e5Layout.setVerticalGroup(
                e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e6Layout = new javax.swing.GroupLayout(e6);
        e6.setLayout(e6Layout);
        e6Layout.setHorizontalGroup(
                e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e6label));
        e6Layout.setVerticalGroup(
                e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e7Layout = new javax.swing.GroupLayout(e7);
        e7.setLayout(e7Layout);
        e7Layout.setHorizontalGroup(
                e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e7label));
        e7Layout.setVerticalGroup(
                e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout e8Layout = new javax.swing.GroupLayout(e8);
        e8.setLayout(e8Layout);
        e8Layout.setHorizontalGroup(
                e8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(e8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(e8label));
        e8Layout.setVerticalGroup(
                e8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(e8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(e8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout f1Layout = new javax.swing.GroupLayout(f1);
        f1.setLayout(f1Layout);
        f1Layout.setHorizontalGroup(
                f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f1label));
        f1Layout.setVerticalGroup(
                f1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f2Layout = new javax.swing.GroupLayout(f2);
        f2.setLayout(f2Layout);
        f2Layout.setHorizontalGroup(
                f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f2label));
        f2Layout.setVerticalGroup(
                f2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f3Layout = new javax.swing.GroupLayout(f3);
        f3.setLayout(f3Layout);
        f3Layout.setHorizontalGroup(
                f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f3label));
        f3Layout.setVerticalGroup(
                f3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f4Layout = new javax.swing.GroupLayout(f4);
        f4.setLayout(f4Layout);
        f4Layout.setHorizontalGroup(
                f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f4label));
        f4Layout.setVerticalGroup(
                f4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f5Layout = new javax.swing.GroupLayout(f5);
        f5.setLayout(f5Layout);
        f5Layout.setHorizontalGroup(
                f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f5label));
        f5Layout.setVerticalGroup(
                f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f6Layout = new javax.swing.GroupLayout(f6);
        f6.setLayout(f6Layout);
        f6Layout.setHorizontalGroup(
                f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f6label));
        f6Layout.setVerticalGroup(
                f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f7Layout = new javax.swing.GroupLayout(f7);
        f7.setLayout(f7Layout);
        f7Layout.setHorizontalGroup(
                f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f7label));
        f7Layout.setVerticalGroup(
                f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout f8Layout = new javax.swing.GroupLayout(f8);
        f8.setLayout(f8Layout);
        f8Layout.setHorizontalGroup(
                f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(f8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(f8label));
        f8Layout.setVerticalGroup(
                f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(f8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(f8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout g1Layout = new javax.swing.GroupLayout(g1);
        g1.setLayout(g1Layout);
        g1Layout.setHorizontalGroup(
                g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g1label));
        g1Layout.setVerticalGroup(
                g1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g2Layout = new javax.swing.GroupLayout(g2);
        g2.setLayout(g2Layout);
        g2Layout.setHorizontalGroup(
                g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g2label));
        g2Layout.setVerticalGroup(
                g2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g3Layout = new javax.swing.GroupLayout(g3);
        g3.setLayout(g3Layout);
        g3Layout.setHorizontalGroup(
                g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g3label));
        g3Layout.setVerticalGroup(
                g3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g4Layout = new javax.swing.GroupLayout(g4);
        g4.setLayout(g4Layout);
        g4Layout.setHorizontalGroup(
                g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g4label));
        g4Layout.setVerticalGroup(
                g4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g5Layout = new javax.swing.GroupLayout(g5);
        g5.setLayout(g5Layout);
        g5Layout.setHorizontalGroup(
                g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g5label));
        g5Layout.setVerticalGroup(
                g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g6Layout = new javax.swing.GroupLayout(g6);
        g6.setLayout(g6Layout);
        g6Layout.setHorizontalGroup(
                g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g6label));
        g6Layout.setVerticalGroup(
                g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g7Layout = new javax.swing.GroupLayout(g7);
        g7.setLayout(g7Layout);
        g7Layout.setHorizontalGroup(
                g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g7label));
        g7Layout.setVerticalGroup(
                g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout g8Layout = new javax.swing.GroupLayout(g8);
        g8.setLayout(g8Layout);
        g8Layout.setHorizontalGroup(
                g8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(g8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(g8label));
        g8Layout.setVerticalGroup(
                g8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(g8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(g8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout h1Layout = new javax.swing.GroupLayout(h1);
        h1.setLayout(h1Layout);
        h1Layout.setHorizontalGroup(
                h1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h1Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h1label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h1label));
        h1Layout.setVerticalGroup(
                h1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h1Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h1label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h2Layout = new javax.swing.GroupLayout(h2);
        h2.setLayout(h2Layout);
        h2Layout.setHorizontalGroup(
                h2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h2Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h2label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h2label));
        h2Layout.setVerticalGroup(
                h2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h2Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h2label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h3Layout = new javax.swing.GroupLayout(h3);
        h3.setLayout(h3Layout);
        h3Layout.setHorizontalGroup(
                h3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h3Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h3label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h3label));
        h3Layout.setVerticalGroup(
                h3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h3Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h3label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h4Layout = new javax.swing.GroupLayout(h4);
        h4.setLayout(h4Layout);
        h4Layout.setHorizontalGroup(
                h4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h4Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h4label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h4label));
        h4Layout.setVerticalGroup(
                h4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h4Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h4label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h5Layout = new javax.swing.GroupLayout(h5);
        h5.setLayout(h5Layout);
        h5Layout.setHorizontalGroup(
                h5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h5Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h5label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h5label));
        h5Layout.setVerticalGroup(
                h5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h5Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h5label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h6Layout = new javax.swing.GroupLayout(h6);
        h6.setLayout(h6Layout);
        h6Layout.setHorizontalGroup(
                h6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h6Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h6label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h6label));
        h6Layout.setVerticalGroup(
                h6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h6Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h6label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h7Layout = new javax.swing.GroupLayout(h7);
        h7.setLayout(h7Layout);
        h7Layout.setHorizontalGroup(
                h7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h7Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h7label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h7label));
        h7Layout.setVerticalGroup(
                h7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h7Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h7label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout h8Layout = new javax.swing.GroupLayout(h8);
        h8.setLayout(h8Layout);
        h8Layout.setHorizontalGroup(
                h8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h8Layout.createSequentialGroup()
                        .addGap(0, 24, 100)
                        .addComponent(h8label)
                        .addContainerGap(24, Short.MAX_VALUE))
                .addComponent(h8label));
        h8Layout.setVerticalGroup(
                h8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(h8Layout.createSequentialGroup()
                        .addGap(0, 16, 100)
                        .addComponent(h8label)
                        .addContainerGap(16, Short.MAX_VALUE))
        );

//        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(d8);
//        d8.setLayout(jPanel8Layout);
//        jPanel8Layout.setHorizontalGroup(
//                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel8Layout.setVerticalGroup(
//                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c8.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(c8);
//        c8.setLayout(jPanel9Layout);
//        jPanel9Layout.setHorizontalGroup(
//                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel9Layout.setVerticalGroup(
//                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c7.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(c7);
//        c7.setLayout(jPanel10Layout);
//        jPanel10Layout.setHorizontalGroup(
//                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel10Layout.setVerticalGroup(
//                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d7.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(d7);
//        d7.setLayout(jPanel11Layout);
//        jPanel11Layout.setHorizontalGroup(
//                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel11Layout.setVerticalGroup(
//                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a8.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(a8);
//        a8.setLayout(jPanel12Layout);
//        jPanel12Layout.setHorizontalGroup(
//                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel12Layout.setVerticalGroup(
//                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b8.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(b8);
//        b8.setLayout(jPanel13Layout);
//        jPanel13Layout.setHorizontalGroup(
//                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel13Layout.setVerticalGroup(
//                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b7.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(b7);
//        b7.setLayout(jPanel14Layout);
//        jPanel14Layout.setHorizontalGroup(
//                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel14Layout.setVerticalGroup(
//                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a7.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(a7);
//        a7.setLayout(jPanel15Layout);
//        jPanel15Layout.setHorizontalGroup(
//                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel15Layout.setVerticalGroup(
//                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a6.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(a6);
//        a6.setLayout(jPanel16Layout);
//        jPanel16Layout.setHorizontalGroup(
//                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel16Layout.setVerticalGroup(
//                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b6.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(b6);
//        b6.setLayout(jPanel17Layout);
//        jPanel17Layout.setHorizontalGroup(
//                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel17Layout.setVerticalGroup(
//                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b5.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout b5Layout = new javax.swing.GroupLayout(b5);
//        b5.setLayout(b5Layout);
//        b5Layout.setHorizontalGroup(
//                b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        b5Layout.setVerticalGroup(
//                b5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a5.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout a5Layout = new javax.swing.GroupLayout(a5);
//        a5.setLayout(a5Layout);
//        a5Layout.setHorizontalGroup(
//                a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        a5Layout.setVerticalGroup(
//                a5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c6.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout c6Layout = new javax.swing.GroupLayout(c6);
//        c6.setLayout(c6Layout);
//        c6Layout.setHorizontalGroup(
//                c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        c6Layout.setVerticalGroup(
//                c6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d6.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout d6Layout = new javax.swing.GroupLayout(d6);
//        d6.setLayout(d6Layout);
//        d6Layout.setHorizontalGroup(
//                d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        d6Layout.setVerticalGroup(
//                d6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d5.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout d5Layout = new javax.swing.GroupLayout(d5);
//        d5.setLayout(d5Layout);
//        d5Layout.setHorizontalGroup(
//                d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        d5Layout.setVerticalGroup(
//                d5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c5.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout c5Layout = new javax.swing.GroupLayout(c5);
//        c5.setLayout(c5Layout);
//        c5Layout.setHorizontalGroup(
//                c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        c5Layout.setVerticalGroup(
//                c5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h5.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout h5Layout = new javax.swing.GroupLayout(h5);
//        h5.setLayout(h5Layout);
//        h5Layout.setHorizontalGroup(
//                h5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        h5Layout.setVerticalGroup(
//                h5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g5.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout g5Layout = new javax.swing.GroupLayout(g5);
//        g5.setLayout(g5Layout);
//        g5Layout.setHorizontalGroup(
//                g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        g5Layout.setVerticalGroup(
//                g5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g6.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout g6Layout = new javax.swing.GroupLayout(g6);
//        g6.setLayout(g6Layout);
//        g6Layout.setHorizontalGroup(
//                g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        g6Layout.setVerticalGroup(
//                g6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h6.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout h6Layout = new javax.swing.GroupLayout(h6);
//        h6.setLayout(h6Layout);
//        h6Layout.setHorizontalGroup(
//                h6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        h6Layout.setVerticalGroup(
//                h6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f6.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout f6Layout = new javax.swing.GroupLayout(f6);
//        f6.setLayout(f6Layout);
//        f6Layout.setHorizontalGroup(
//                f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        f6Layout.setVerticalGroup(
//                f6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f5.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout f5Layout = new javax.swing.GroupLayout(f5);
//        f5.setLayout(f5Layout);
//        f5Layout.setHorizontalGroup(
//                f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        f5Layout.setVerticalGroup(
//                f5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e5.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout e5Layout = new javax.swing.GroupLayout(e5);
//        e5.setLayout(e5Layout);
//        e5Layout.setHorizontalGroup(
//                e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        e5Layout.setVerticalGroup(
//                e5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e6.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout e6Layout = new javax.swing.GroupLayout(e6);
//        e6.setLayout(e6Layout);
//        e6Layout.setHorizontalGroup(
//                e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        e6Layout.setVerticalGroup(
//                e6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e7.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout e7Layout = new javax.swing.GroupLayout(e7);
//        e7.setLayout(e7Layout);
//        e7Layout.setHorizontalGroup(
//                e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        e7Layout.setVerticalGroup(
//                e7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f7.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout f7Layout = new javax.swing.GroupLayout(f7);
//        f7.setLayout(f7Layout);
//        f7Layout.setHorizontalGroup(
//                f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        f7Layout.setVerticalGroup(
//                f7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e8.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout e8Layout = new javax.swing.GroupLayout(e8);
//        e8.setLayout(e8Layout);
//        e8Layout.setHorizontalGroup(
//                e8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        e8Layout.setVerticalGroup(
//                e8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f8.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout f8Layout = new javax.swing.GroupLayout(f8);
//        f8.setLayout(f8Layout);
//        f8Layout.setHorizontalGroup(
//                f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        f8Layout.setVerticalGroup(
//                f8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g8.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout g8Layout = new javax.swing.GroupLayout(g8);
//        g8.setLayout(g8Layout);
//        g8Layout.setHorizontalGroup(
//                g8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        g8Layout.setVerticalGroup(
//                g8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g7.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout g7Layout = new javax.swing.GroupLayout(g7);
//        g7.setLayout(g7Layout);
//        g7Layout.setHorizontalGroup(
//                g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        g7Layout.setVerticalGroup(
//                g7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h7.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout h7Layout = new javax.swing.GroupLayout(h7);
//        h7.setLayout(h7Layout);
//        h7Layout.setHorizontalGroup(
//                h7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        h7Layout.setVerticalGroup(
//                h7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h8.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout h8Layout = new javax.swing.GroupLayout(h8);
//        h8.setLayout(h8Layout);
//        h8Layout.setHorizontalGroup(
//                h8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        h8Layout.setVerticalGroup(
//                h8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a4.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(a4);
//        a4.setLayout(jPanel40Layout);
//        jPanel40Layout.setHorizontalGroup(
//                jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel40Layout.setVerticalGroup(
//                jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b4.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(b4);
//        b4.setLayout(jPanel41Layout);
//        jPanel41Layout.setHorizontalGroup(
//                jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel41Layout.setVerticalGroup(
//                jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c4.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(c4);
//        c4.setLayout(jPanel42Layout);
//        jPanel42Layout.setHorizontalGroup(
//                jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel42Layout.setVerticalGroup(
//                jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d4.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(d4);
//        d4.setLayout(jPanel43Layout);
//        jPanel43Layout.setHorizontalGroup(
//                jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel43Layout.setVerticalGroup(
//                jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e4.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(e4);
//        e4.setLayout(jPanel44Layout);
//        jPanel44Layout.setHorizontalGroup(
//                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel44Layout.setVerticalGroup(
//                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f4.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(f4);
//        f4.setLayout(jPanel45Layout);
//        jPanel45Layout.setHorizontalGroup(
//                jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel45Layout.setVerticalGroup(
//                jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g4.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(g4);
//        g4.setLayout(jPanel46Layout);
//        jPanel46Layout.setHorizontalGroup(
//                jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel46Layout.setVerticalGroup(
//                jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h4.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(h4);
//        h4.setLayout(jPanel47Layout);
//        jPanel47Layout.setHorizontalGroup(
//                jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel47Layout.setVerticalGroup(
//                jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h3.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(h3);
//        h3.setLayout(jPanel48Layout);
//        jPanel48Layout.setHorizontalGroup(
//                jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel48Layout.setVerticalGroup(
//                jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g3.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(g3);
//        g3.setLayout(jPanel49Layout);
//        jPanel49Layout.setHorizontalGroup(
//                jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel49Layout.setVerticalGroup(
//                jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f3.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(f3);
//        f3.setLayout(jPanel50Layout);
//        jPanel50Layout.setHorizontalGroup(
//                jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel50Layout.setVerticalGroup(
//                jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e3.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(e3);
//        e3.setLayout(jPanel51Layout);
//        jPanel51Layout.setHorizontalGroup(
//                jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel51Layout.setVerticalGroup(
//                jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d3.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(d3);
//        d3.setLayout(jPanel52Layout);
//        jPanel52Layout.setHorizontalGroup(
//                jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel52Layout.setVerticalGroup(
//                jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c3.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(c3);
//        c3.setLayout(jPanel53Layout);
//        jPanel53Layout.setHorizontalGroup(
//                jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel53Layout.setVerticalGroup(
//                jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b3.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(b3);
//        b3.setLayout(jPanel54Layout);
//        jPanel54Layout.setHorizontalGroup(
//                jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel54Layout.setVerticalGroup(
//                jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a3.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(a3);
//        a3.setLayout(jPanel55Layout);
//        jPanel55Layout.setHorizontalGroup(
//                jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel55Layout.setVerticalGroup(
//                jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a2.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(a2);
//        a2.setLayout(jPanel56Layout);
//        jPanel56Layout.setHorizontalGroup(
//                jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel56Layout.setVerticalGroup(
//                jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b2.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(b2);
//        b2.setLayout(jPanel57Layout);
//        jPanel57Layout.setHorizontalGroup(
//                jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel57Layout.setVerticalGroup(
//                jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c2.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(c2);
//        c2.setLayout(jPanel58Layout);
//        jPanel58Layout.setHorizontalGroup(
//                jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel58Layout.setVerticalGroup(
//                jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d2.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(d2);
//        d2.setLayout(jPanel59Layout);
//        jPanel59Layout.setHorizontalGroup(
//                jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel59Layout.setVerticalGroup(
//                jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e2.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(e2);
//        e2.setLayout(jPanel60Layout);
//        jPanel60Layout.setHorizontalGroup(
//                jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel60Layout.setVerticalGroup(
//                jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f2.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(f2);
//        f2.setLayout(jPanel61Layout);
//        jPanel61Layout.setHorizontalGroup(
//                jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel61Layout.setVerticalGroup(
//                jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g2.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(g2);
//        g2.setLayout(jPanel62Layout);
//        jPanel62Layout.setHorizontalGroup(
//                jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel62Layout.setVerticalGroup(
//                jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h2.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(h2);
//        h2.setLayout(jPanel63Layout);
//        jPanel63Layout.setHorizontalGroup(
//                jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel63Layout.setVerticalGroup(
//                jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        a1.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(a1);
//        a1.setLayout(jPanel64Layout);
//        jPanel64Layout.setHorizontalGroup(
//                jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel64Layout.setVerticalGroup(
//                jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        b1.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel65Layout = new javax.swing.GroupLayout(b1);
//        b1.setLayout(jPanel65Layout);
//        jPanel65Layout.setHorizontalGroup(
//                jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel65Layout.setVerticalGroup(
//                jPanel65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        c1.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(c1);
//        c1.setLayout(jPanel66Layout);
//        jPanel66Layout.setHorizontalGroup(
//                jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel66Layout.setVerticalGroup(
//                jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        d1.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(d1);
//        d1.setLayout(jPanel67Layout);
//        jPanel67Layout.setHorizontalGroup(
//                jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel67Layout.setVerticalGroup(
//                jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        e1.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(e1);
//        e1.setLayout(jPanel68Layout);
//        jPanel68Layout.setHorizontalGroup(
//                jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel68Layout.setVerticalGroup(
//                jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        f1.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(f1);
//        f1.setLayout(jPanel69Layout);
//        jPanel69Layout.setHorizontalGroup(
//                jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel69Layout.setVerticalGroup(
//                jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        g1.setBackground(new java.awt.Color(255, 255, 255));
//
//        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(g1);
//        g1.setLayout(jPanel70Layout);
//        jPanel70Layout.setHorizontalGroup(
//                jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel70Layout.setVerticalGroup(
//                jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        h1.setBackground(new java.awt.Color(210, 140, 70));
//
//        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(h1);
//        h1.setLayout(jPanel71Layout);
//        jPanel71Layout.setHorizontalGroup(
//                jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel71Layout.setVerticalGroup(
//                jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGap(0, 100, Short.MAX_VALUE)
//        );
        komentoKentta = new javax.swing.JTextField();
        komentoKentta.setText("");
        komentoKentta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vuoro = logic.Main.suoritaKomento(lauta, vuoro, komentoKentta);
                updateUI();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                .addComponent(komentoKentta)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(komentoKentta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        UI ui = new UI();
        ui.aja();

    }

    public void aja() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UI ui = new UI();
                ui.setVisible(true);

            }
        });
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

        JLabel[] labels = getLabels();

//        while (true) {
//            lauta.printBoardState();
//            updateUI();
//            System.out.println("");
//            if (vuoro == Nappula.Puoli.VALKOINEN) {
//                System.out.print("Valkoisen ");
//            } else {
//                System.out.print("Mustan ");
//            }
//            System.out.println("vuoro, komento muotoa d2-d4, tyhjä lopettaa pelin");
//            int[][] startEndPoints = Parser.parseCommand(line, vuoro, lauta);
//            if (startEndPoints == null) {
//                continue;
//            }
//            if (startEndPoints[0][0] < 8 && startEndPoints[0][0] > -1 && startEndPoints[0][1] < 8 && startEndPoints[0][1] > -1) {
//                Nappula nappula = lauta.getNappula(startEndPoints[0]);
//                if (nappula.getPuoli() != vuoro) {
//                    System.out.println("Ruudussa ei nappulaasi");
//                    continue;
//                }
//                if (Liikkuminen.koitaSiirtya(nappula, startEndPoints[1], lauta)) {
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
    }

    /**
     *
     */
    public void updateUI() {
        a1label.setText(Character.toString(lauta.getNappula("a1").getMerkki()));
        a2label.setText(Character.toString(lauta.getNappula("a2").getMerkki()));
        a3label.setText(Character.toString(lauta.getNappula("a3").getMerkki()));
        a4label.setText(Character.toString(lauta.getNappula("a4").getMerkki()));
        a5label.setText(Character.toString(lauta.getNappula("a5").getMerkki()));
        a6label.setText(Character.toString(lauta.getNappula("a6").getMerkki()));
        a7label.setText(Character.toString(lauta.getNappula("a7").getMerkki()));
        a8label.setText(Character.toString(lauta.getNappula("a8").getMerkki()));

        b1label.setText(Character.toString(lauta.getNappula("b1").getMerkki()));
        b2label.setText(Character.toString(lauta.getNappula("b2").getMerkki()));
        b3label.setText(Character.toString(lauta.getNappula("b3").getMerkki()));
        b4label.setText(Character.toString(lauta.getNappula("b4").getMerkki()));
        b5label.setText(Character.toString(lauta.getNappula("b5").getMerkki()));
        b6label.setText(Character.toString(lauta.getNappula("b6").getMerkki()));
        b7label.setText(Character.toString(lauta.getNappula("b7").getMerkki()));
        b8label.setText(Character.toString(lauta.getNappula("b8").getMerkki()));

        c1label.setText(Character.toString(lauta.getNappula("c1").getMerkki()));
        c2label.setText(Character.toString(lauta.getNappula("c2").getMerkki()));
        c3label.setText(Character.toString(lauta.getNappula("c3").getMerkki()));
        c4label.setText(Character.toString(lauta.getNappula("c4").getMerkki()));
        c5label.setText(Character.toString(lauta.getNappula("c5").getMerkki()));
        c6label.setText(Character.toString(lauta.getNappula("c6").getMerkki()));
        c7label.setText(Character.toString(lauta.getNappula("c7").getMerkki()));
        c8label.setText(Character.toString(lauta.getNappula("c8").getMerkki()));

        d1label.setText(Character.toString(lauta.getNappula("d1").getMerkki()));
        d2label.setText(Character.toString(lauta.getNappula("d2").getMerkki()));
        d3label.setText(Character.toString(lauta.getNappula("d3").getMerkki()));
        d4label.setText(Character.toString(lauta.getNappula("d4").getMerkki()));
        d5label.setText(Character.toString(lauta.getNappula("d5").getMerkki()));
        d6label.setText(Character.toString(lauta.getNappula("d6").getMerkki()));
        d7label.setText(Character.toString(lauta.getNappula("d7").getMerkki()));
        d8label.setText(Character.toString(lauta.getNappula("d8").getMerkki()));

        e1label.setText(Character.toString(lauta.getNappula("e1").getMerkki()));
        e2label.setText(Character.toString(lauta.getNappula("e2").getMerkki()));
        e3label.setText(Character.toString(lauta.getNappula("e3").getMerkki()));
        e4label.setText(Character.toString(lauta.getNappula("e4").getMerkki()));
        e5label.setText(Character.toString(lauta.getNappula("e5").getMerkki()));
        e6label.setText(Character.toString(lauta.getNappula("e6").getMerkki()));
        e7label.setText(Character.toString(lauta.getNappula("e7").getMerkki()));
        e8label.setText(Character.toString(lauta.getNappula("e8").getMerkki()));

        f1label.setText(Character.toString(lauta.getNappula("f1").getMerkki()));
        f2label.setText(Character.toString(lauta.getNappula("f2").getMerkki()));
        f3label.setText(Character.toString(lauta.getNappula("f3").getMerkki()));
        f4label.setText(Character.toString(lauta.getNappula("f4").getMerkki()));
        f5label.setText(Character.toString(lauta.getNappula("f5").getMerkki()));
        f6label.setText(Character.toString(lauta.getNappula("f6").getMerkki()));
        f7label.setText(Character.toString(lauta.getNappula("f7").getMerkki()));
        f8label.setText(Character.toString(lauta.getNappula("f8").getMerkki()));

        g1label.setText(Character.toString(lauta.getNappula("g1").getMerkki()));
        g2label.setText(Character.toString(lauta.getNappula("g2").getMerkki()));
        g3label.setText(Character.toString(lauta.getNappula("g3").getMerkki()));
        g4label.setText(Character.toString(lauta.getNappula("g4").getMerkki()));
        g5label.setText(Character.toString(lauta.getNappula("g5").getMerkki()));
        g6label.setText(Character.toString(lauta.getNappula("g6").getMerkki()));
        g7label.setText(Character.toString(lauta.getNappula("g7").getMerkki()));
        g8label.setText(Character.toString(lauta.getNappula("g8").getMerkki()));

        h1label.setText(Character.toString(lauta.getNappula("h1").getMerkki()));
        h2label.setText(Character.toString(lauta.getNappula("h2").getMerkki()));
        h3label.setText(Character.toString(lauta.getNappula("h3").getMerkki()));
        h4label.setText(Character.toString(lauta.getNappula("h4").getMerkki()));
        h5label.setText(Character.toString(lauta.getNappula("h5").getMerkki()));
        h6label.setText(Character.toString(lauta.getNappula("h6").getMerkki()));
        h7label.setText(Character.toString(lauta.getNappula("h7").getMerkki()));
        h8label.setText(Character.toString(lauta.getNappula("h8").getMerkki()));
    }

    public String getKomento() {
        return komentoKentta.getText();
    }

    /**
     *
     * @return 
     */
//    public void suoritaKomento() {
//        int[][] startEndPoints = Parser.parseCommand(komentoKentta.getText(), vuoro, lauta);
//        if (startEndPoints == null) {
//            System.out.println("Laiton siirto");
//        } else {
//            if (startEndPoints[0][0] < 8 && startEndPoints[0][0] > -1 && startEndPoints[0][1] < 8 && startEndPoints[0][1] > -1) {
//                Nappula nappula = lauta.getNappula(startEndPoints[0]);
//                if (nappula.getPuoli() != vuoro) {
//                    System.out.println("Ruudussa ei nappulaasi");
//                }
//                if (Liikkuminen.koitaSiirtya(nappula, startEndPoints[1], lauta)) {
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
//        komentoKentta.setText("");
//    }

    public JLabel[] getLabels() {
        JLabel[] labels = new JLabel[64];
        labels[0] = a1label;
        labels[1] = a2label;
        labels[2] = a3label;
        labels[3] = a4label;
        labels[4] = a5label;
        labels[5] = a6label;
        labels[6] = a7label;
        labels[7] = a8label;

        labels[8] = b1label;
        labels[9] = b2label;
        labels[10] = b3label;
        labels[11] = b4label;
        labels[12] = b5label;
        labels[13] = b6label;
        labels[14] = b7label;
        labels[15] = b8label;

        labels[16] = c1label;
        labels[17] = c2label;
        labels[18] = c3label;
        labels[19] = c4label;
        labels[20] = c5label;
        labels[21] = c6label;
        labels[22] = c7label;
        labels[23] = c8label;

        labels[24] = d1label;
        labels[25] = d2label;
        labels[26] = d3label;
        labels[27] = d4label;
        labels[28] = d5label;
        labels[29] = d6label;
        labels[30] = d7label;
        labels[31] = d8label;

        labels[32] = e1label;
        labels[33] = e2label;
        labels[34] = e3label;
        labels[35] = e4label;
        labels[36] = e5label;
        labels[37] = e6label;
        labels[38] = e7label;
        labels[39] = e8label;

        labels[40] = f1label;
        labels[41] = f2label;
        labels[42] = f3label;
        labels[43] = f4label;
        labels[44] = f5label;
        labels[45] = f6label;
        labels[46] = f7label;
        labels[47] = f8label;

        labels[48] = g1label;
        labels[49] = g2label;
        labels[50] = g3label;
        labels[51] = g4label;
        labels[52] = g5label;
        labels[53] = g6label;
        labels[54] = g7label;
        labels[55] = g8label;

        labels[56] = h1label;
        labels[57] = h2label;
        labels[58] = h3label;
        labels[59] = h4label;
        labels[60] = h5label;
        labels[61] = h6label;
        labels[62] = h7label;
        labels[63] = h8label;
        return labels;
    }

    private Lauta lauta;

    private javax.swing.JPanel a1;
    private javax.swing.JPanel a2;
    private javax.swing.JPanel a3;
    private javax.swing.JPanel a4;
    private javax.swing.JPanel a5;
    private javax.swing.JPanel a6;
    private javax.swing.JPanel a7;
    private javax.swing.JPanel a8;

    private javax.swing.JPanel b1;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b4;
    private javax.swing.JPanel b5;
    private javax.swing.JPanel b6;
    private javax.swing.JPanel b7;
    private javax.swing.JPanel b8;

    private javax.swing.JPanel c1;
    private javax.swing.JPanel c2;
    private javax.swing.JPanel c3;
    private javax.swing.JPanel c4;
    private javax.swing.JPanel c5;
    private javax.swing.JPanel c6;
    private javax.swing.JPanel c7;
    private javax.swing.JPanel c8;

    private javax.swing.JPanel d1;
    private javax.swing.JPanel d2;
    private javax.swing.JPanel d3;
    private javax.swing.JPanel d4;
    private javax.swing.JPanel d5;
    private javax.swing.JPanel d6;
    private javax.swing.JPanel d7;
    private javax.swing.JPanel d8;

    private javax.swing.JPanel e1;
    private javax.swing.JPanel e2;
    private javax.swing.JPanel e3;
    private javax.swing.JPanel e4;
    private javax.swing.JPanel e5;
    private javax.swing.JPanel e6;
    private javax.swing.JPanel e7;
    private javax.swing.JPanel e8;

    private javax.swing.JPanel f1;
    private javax.swing.JPanel f2;
    private javax.swing.JPanel f3;
    private javax.swing.JPanel f4;
    private javax.swing.JPanel f5;
    private javax.swing.JPanel f6;
    private javax.swing.JPanel f7;
    private javax.swing.JPanel f8;

    private javax.swing.JPanel g1;
    private javax.swing.JPanel g2;
    private javax.swing.JPanel g3;
    private javax.swing.JPanel g4;
    private javax.swing.JPanel g5;
    private javax.swing.JPanel g6;
    private javax.swing.JPanel g7;
    private javax.swing.JPanel g8;

    private javax.swing.JPanel h1;
    private javax.swing.JPanel h2;
    private javax.swing.JPanel h3;
    private javax.swing.JPanel h4;
    private javax.swing.JPanel h5;
    private javax.swing.JPanel h6;
    private javax.swing.JPanel h7;
    private javax.swing.JPanel h8;

    private JLabel a1label;
    private JLabel a2label;
    private JLabel a3label;
    private JLabel a4label;
    private JLabel a5label;
    private JLabel a6label;
    private JLabel a7label;
    private JLabel a8label;

    private JLabel b1label;
    private JLabel b2label;
    private JLabel b3label;
    private JLabel b4label;
    private JLabel b5label;
    private JLabel b6label;
    private JLabel b7label;
    private JLabel b8label;

    private JLabel c1label;
    private JLabel c2label;
    private JLabel c3label;
    private JLabel c4label;
    private JLabel c5label;
    private JLabel c6label;
    private JLabel c7label;
    private JLabel c8label;

    private JLabel d1label;
    private JLabel d2label;
    private JLabel d3label;
    private JLabel d4label;
    private JLabel d5label;
    private JLabel d6label;
    private JLabel d7label;
    private JLabel d8label;

    private JLabel e1label;
    private JLabel e2label;
    private JLabel e3label;
    private JLabel e4label;
    private JLabel e5label;
    private JLabel e6label;
    private JLabel e7label;
    private JLabel e8label;

    private JLabel f1label;
    private JLabel f2label;
    private JLabel f3label;
    private JLabel f4label;
    private JLabel f5label;
    private JLabel f6label;
    private JLabel f7label;
    private JLabel f8label;

    private JLabel g1label;
    private JLabel g2label;
    private JLabel g3label;
    private JLabel g4label;
    private JLabel g5label;
    private JLabel g6label;
    private JLabel g7label;
    private JLabel g8label;

    private JLabel h1label;
    private JLabel h2label;
    private JLabel h3label;
    private JLabel h4label;
    private JLabel h5label;
    private JLabel h6label;
    private JLabel h7label;
    private JLabel h8label;

    private javax.swing.JTextField komentoKentta;

    private Nappula.Puoli vuoro;
}
