package Nomor2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KonversiNilaiGUI extends JFrame {
    private JTextField textFieldNilaiAngka;
    private JButton buttonKonversi;
    private JLabel labelHasil;

    public KonversiNilaiGUI() {
        inisialisasiUI();
    }

    private void inisialisasiUI() {
        setTitle("Konversi Nilai Mata Kuliah");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        panel.add(new JLabel("Masukkan Nilai Angka:"));
        textFieldNilaiAngka = new JTextField();
        panel.add(textFieldNilaiAngka);

        buttonKonversi = new JButton("Konversi");
        buttonKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                konversiNilai();
            }
        });
        panel.add(buttonKonversi);

        labelHasil = new JLabel("Hasil Konversi: ");
        panel.add(labelHasil);

        add(panel);
    }

    private void konversiNilai() {
        try {
            int nilaiAngka = Integer.parseInt(textFieldNilaiAngka.getText());

            String nilaiHuruf = konversiKeNilaiHuruf(nilaiAngka);

            labelHasil.setText("Hasil Konversi: " + nilaiHuruf);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid.");
        }
    }

    private String konversiKeNilaiHuruf(int nilaiAngka) {
        if (nilaiAngka >= 90 && nilaiAngka <= 100) {
            return "A";
        } else if (nilaiAngka >= 85 && nilaiAngka < 90) {
            return "A-";
        } else if (nilaiAngka >= 80 && nilaiAngka < 85) {
            return "B+";
        } else if (nilaiAngka >= 75 && nilaiAngka < 80) {
            return "B";
        } else if (nilaiAngka >= 70 && nilaiAngka < 75) {
            return "B-";
        } else if (nilaiAngka >= 60 && nilaiAngka < 70) {
            return "C";
        } else if (nilaiAngka >= 50 && nilaiAngka < 60) {
            return "D";
        } else if (nilaiAngka >= 0 && nilaiAngka < 50) {
            return "E";
        } else {
            return "Nilai tidak valid";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KonversiNilaiGUI().setVisible(true);
            }
        });
    }
}
