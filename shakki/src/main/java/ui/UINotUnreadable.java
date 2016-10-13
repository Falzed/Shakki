package ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import logic.Game;
import java.awt.GridLayout;
import javax.swing.GroupLayout.*;

/**
 * Luokka toteuttaa ohjelman graafisen käyttöliittymän. Siirrot syötetään laudan
 * alapuolella olevaan tekstikenttään, joko muodossa (algebrallinen
 * koordinaatti)-(algebrallinen koordinaatti) tai liikutettava nappula
 * algebrallisessa notaatiossa ja pelkkä loppupiste (esim Qd6 siirtää
 * kuningattaren d6:een). Sotilaalla syödessä lisätään x tällöin x komennon
 * eteen.
 *
 * @author oemkulma
 */
public class UINotUnreadable extends javax.swing.JFrame {

    private JPanel[][] panels;
    private JLabel[][] labels;

    /**
     *
     * @param peli
     */
    public UINotUnreadable(Game peli) {
        initComponents(peli);
    }

    //Netbeansin generoimaa, refaktoroin toivottavasti myöhemmin luettavampaan muotoon
    @SuppressWarnings("unchecked")
    private void initComponents(Game peli) {
        this.peli = peli;

        historiaKentta = new javax.swing.JTextArea(20, 20);
        historiaButton = new javax.swing.JButton();
        historiaButton.setText("Submit");

        scrollpane = new javax.swing.JScrollPane();
        Dimension dimension = new Dimension(100, 100);

        this.panels = new JPanel[peli.getLauta().getLeveys()][peli.getLauta().getPituus()];
        this.labels = new JLabel[peli.getLauta().getLeveys()][peli.getLauta().getPituus()];
        JLabel[][] coordinateLabels = new JLabel[peli.getLauta().getLeveys()][peli.getLauta().getPituus()];

        for (int i = 0; i < peli.getLauta().getLeveys(); i++) {
            for (int j = 0; j < peli.getLauta().getPituus(); j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setMinimumSize(dimension);
                panels[i][j].setPreferredSize(dimension);
                labels[i][j] = new JLabel("");
                char merkki = (char) (97 + i);
                String label = Character.toString(merkki);
                label += Integer.toString(j + 1);
                coordinateLabels[i][j] = new JLabel(label);
                labels[i][j].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labels[i][j].setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                labels[i][j].setFont(new Font("Unifont", 1, 50));
                if ((i + j) % 2 == 0) {
                    panels[i][j].setBackground(new java.awt.Color(210, 140, 70));
                } else {
                    panels[i][j].setBackground(new java.awt.Color(255, 255, 255));
                }
            }
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        String merkki = Character.toString('\u265A');
        javax.swing.GroupLayout[][] groupLayouts = new javax.swing.GroupLayout[peli.getLauta().getLeveys()][peli.getLauta().getPituus()];
        for (int i = 0; i < peli.getLauta().getLeveys(); i++) {
            for (int j = 0; j < peli.getLauta().getPituus(); j++) {
                groupLayouts[i][j] = new javax.swing.GroupLayout(panels[i][j]);
                panels[i][j].setLayout(groupLayouts[i][j]);
                groupLayouts[i][j].setHorizontalGroup(
                        groupLayouts[i][j].createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayouts[i][j].createSequentialGroup()
                                .addGap(2)
                                .addComponent(coordinateLabels[i][j])
                                .addGap(0, 9, 100)                                
                                .addComponent(labels[i][j])
                                .addContainerGap(24, Short.MAX_VALUE)
                        )
//                        .addComponent(coordinateLabels[i][j])
//                        .addComponent(labels[i][j])
                );
                groupLayouts[i][j].setVerticalGroup(
                        groupLayouts[i][j].createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayouts[i][j].createSequentialGroup()
                                .addGap(3)
                                .addComponent(coordinateLabels[i][j])
                                .addGap(3)
                                .addComponent(labels[i][j])
                                .addContainerGap(25, Short.MAX_VALUE)
                        )
                );
            }
        }

        komentoKentta = new javax.swing.JTextField();
        komentoKentta.setText("");
        komentoKentta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                peli.suoritaKomento(komentoKentta.getText());
                historiaKentta.setText(peli.getTurnHistory().toString());
                komentoKentta.setText("");
                updateUI();
            }
        });

        historiaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!peli.getTurnHistory().toString().equals(historiaKentta.getText())) {
                    String historiaString = historiaKentta.getText();
                    peli.clearHistory();
                    peli.applyHistory(historiaString);
                    updateUI();
                }
            }
        });
        JPanel lautaPanel = new JPanel();
        javax.swing.GroupLayout lautaLayout = new javax.swing.GroupLayout(lautaPanel);
        lautaPanel.setLayout(lautaLayout);
//        getContentPane().setLayout(lautaLayout);
        Group parallel = lautaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        for (int j = 0; j < peli.getLauta().getPituus(); j++) {
            Group sequential = lautaLayout.createSequentialGroup();

            for (int i = 0; i < peli.getLauta().getLeveys(); i++) {
                sequential.addComponent(panels[i][j], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
            }
            parallel.addGroup(sequential);
        }
        parallel.addComponent(komentoKentta);
        lautaLayout.setHorizontalGroup(parallel);

        SequentialGroup sequential = lautaLayout.createSequentialGroup();
        for (int j = peli.getLauta().getPituus() - 1; j >= 0; j--) {
            Group parallelLoop = lautaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            for (int i = 0; i < peli.getLauta().getLeveys(); i++) {
                parallelLoop.addComponent(panels[i][j], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
                if (i != peli.getLauta().getLeveys() - 1) {
                    parallelLoop.addGap(100);
                }
            }
            sequential.addGroup(parallelLoop);
        }
        sequential.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        sequential.addComponent(komentoKentta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        lautaLayout.setVerticalGroup(
                lautaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sequential)
        );

//        historiaKentta.setColumns(20);
//        historiaKentta.setRows(5);
//        historiaKentta.setText("");
        scrollpane.setViewportView(historiaKentta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(lautaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(historiaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                ));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lautaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(historiaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )));

        pack();
    }// </editor-fold>                        

    /**
     * turha
     *
     * @param args
     */
    public static void main(String args[]) {
        Game peli = new Game();
        UINotUnreadable ui = new UINotUnreadable(peli);
        ui.aja();

    }

    /**
     * turha
     */
    public void aja() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Game peli = new Game();
                UI ui = new UI(peli);
                ui.setVisible(true);

            }
        });
    }

    /**
     * Metodi päivittää UI:n.
     */
    public void updateUI() {
        historiaKentta.setText(peli.getTurnHistory().toString());
        for (int i = 0; i < peli.getLauta().getLeveys(); i++) {
            for (int j = 0; j < peli.getLauta().getPituus(); j++) {
                int[] koordinaatit = {i, j};
                labels[i][j].setText(Character.toString(peli.getLauta().getNappula(koordinaatit).getMerkki()));
            }
        }
    }

    public String popupKorotus() {
        // a jframe here isn't strictly necessary, but it makes the example a little more real
        JFrame frame = new JFrame("InputDialog Example #1");

        // prompt the user to enter their name
        Object[] possibilities = {"Kuningatar", "Ratsu", "Torni", "Lähetti"};
        String s = (String) JOptionPane.showInputDialog(
                frame,
                "",
                "Sotilaan korotus",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Kuningatar");
        return s;
    }

    /**
     *
     * @return
     */
    public String getKomento() {
        return komentoKentta.getText();
    }

    /**
     *
     * @return
     */
    public JLabel[][] getLabels() {
        return this.labels;
    }

    private javax.swing.JTextField komentoKentta;

    private javax.swing.JTextArea historiaKentta;
    private javax.swing.JScrollPane scrollpane;

    private JButton historiaButton;

    private Game peli;
}