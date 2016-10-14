//package ui;
//
//import java.awt.event.ActionEvent;
//
//
//public class Kuuntelijat {
//    private UI ui;
//    public void historiaAsetettu(ActionEvent e) {
//                if (!peli.getTurnHistory().toString().equals(historiaKentta.getText())) {
//                    String historiaString = historiaKentta.getText();
//                    peli.clearHistory();
//                    peli.applyHistory(historiaString);
//                    updateUI();
//                }
//            }
//    
//    public void komentoAnnettu(ActionEvent e) {
//                peli.suoritaKomento(komentoKentta.getText());
//                historiaKentta.setText(peli.getTurnHistory().toString());
//                komentoKentta.setText("");
//                updateUI();
//            }
//}
