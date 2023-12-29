package Nomor16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerceptronGUI extends JFrame {
    private JTextField textFieldX0;
    private JTextField textFieldX1;
    private JButton buttonTest;
    private JTextArea textAreaResult;

    private final double ALPHA = 1;
    private double[] bobot = {0, 0, 0}; // w0, w1, b

    public PerceptronGUI() {
        inisialisasiUI();
        setupPerceptron();
    }

    private void inisialisasiUI() {
        setTitle("Pengenalan Karakter dengan Perceptron");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Input x0:"));
        textFieldX0 = new JTextField();
        panel.add(textFieldX0);

        panel.add(new JLabel("Input x1:"));
        textFieldX1 = new JTextField();
        panel.add(textFieldX1);

        buttonTest = new JButton("Uji");
        buttonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ujiKarakter();
            }
        });
        panel.add(buttonTest);

        textAreaResult = new JTextArea();
        textAreaResult.setEditable(false);
        panel.add(new JScrollPane(textAreaResult));

        add(panel);
    }

    private void setupPerceptron() {
        // Inisialisasi bobot perceptron 
    }

    private void ujiKarakter() {
        try {
            int x0_uji = Integer.parseInt(textFieldX0.getText());
            int x1_uji = Integer.parseInt(textFieldX1.getText());

            double net_uji = x0_uji * bobot[0] + x1_uji * bobot[1] + 1 * bobot[2];
            int y_uji = (net_uji > 0) ? 1 : ((net_uji < 0) ? -1 : 0);

            textAreaResult.setText("Hasil: " + y_uji);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input tidak valid. Harap masukkan angka untuk x0 dan x1.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PerceptronGUI().setVisible(true);
            }
        });
    }
}
