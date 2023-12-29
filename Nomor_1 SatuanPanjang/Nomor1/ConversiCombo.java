package Nomor1;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversiCombo extends JFrame {

    private JPanel basePanel = null;
    private JComboBox<String> jComboBoxR = null;
    private JTextField jTextFieldInput = null;
    private JButton buttonKonversi = null;
    private JComboBox<String> jComboBoxS = null;
    private JTextField jTextFieldIOutput = null;
    private String[] label = new String[]{
        "KM", "HM", "DAM", "M", "DM", "CM", "MM"
    };

    public ConversiCombo() {
        initUI();
    }

    private void initUI() {
        setContentPane(getBasePanel());
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JPanel getBasePanel() {
        if (basePanel == null) {
            basePanel = new JPanel();
            basePanel.add(getJComboBoxR());
            basePanel.add(getJTextFieldInput());
            basePanel.add(getButtonKonversi());
            basePanel.add(getJComboBoxS());
            basePanel.add(getJTextFieldIOutput());
            basePanel.setBackground(Color.blue);

        }
        return basePanel;
    }

    private JComboBox<String> getJComboBoxR() {
        if (jComboBoxR == null) {
            jComboBoxR = new JComboBox<>(label);
        }
        return jComboBoxR;
    }

    private JComboBox<String> getJComboBoxS() {
        if (jComboBoxS == null) {
            jComboBoxS = new JComboBox<>(label);
        }
        return jComboBoxS;
    }

    private JTextField getJTextFieldInput() {
        if (jTextFieldInput == null) {
           jTextFieldInput = new JTextField();
            jTextFieldInput.setPreferredSize(new Dimension(80, 20));
//            jTextFieldInput.setBackground(Color.red);
        }
        return jTextFieldInput;
    }

    private JButton getButtonKonversi() {
        if (buttonKonversi == null) {
            buttonKonversi = new JButton("Convert-->");
            buttonKonversi.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   int indexIn = jComboBoxR.getSelectedIndex();
                   int indexOut = jComboBoxS.getSelectedIndex();
                   
                   String sInput = jTextFieldInput.getText();
                   double input = Double.parseDouble(sInput);
                   double output = convert(indexIn, indexOut, input);
                   if (input > output){
                        jTextFieldIOutput.setText("" + String.format("%.06f", output));
                    }else{
                       jTextFieldIOutput.setText("" + output);
                   }
                    
                    //fieldCM.setText(String.valueOf(Double.parseDouble(fieldKM.getText()) * 100_000));
                }
            });
        }
        return buttonKonversi;
    }
    
    private double convert(int dari, int ke, double value){
        double result = value;
        //convert ke km
        double km = value / Math.pow(10, dari);
        result = km * Math.pow(10, ke);
        
        return result;
    }


    private JTextField getJTextFieldIOutput() {
        if (jTextFieldIOutput == null) {
            jTextFieldIOutput= new JTextField();
            jTextFieldIOutput.setPreferredSize(new Dimension(80, 20));
        }
        return jTextFieldIOutput;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConversiCombo myWindow = new ConversiCombo();
            }

        }
        );

    }
}
