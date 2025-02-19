import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CekCuaca extends JFrame {
    private JTextField kotaField, hasilField;
    private JButton btnCek, btnClear, btnExit;

    public CekCuaca() {
        setTitle("Aplikasi Cek Cuaca");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel input
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JLabel labelKota = new JLabel("Masukkan Kota:");
        kotaField = new JTextField();
        JLabel labelHasil = new JLabel("Hasil Cuaca:");
        hasilField = new JTextField();
        hasilField.setEditable(false);
        
        inputPanel.add(labelKota);
        inputPanel.add(kotaField);
        inputPanel.add(labelHasil);
        inputPanel.add(hasilField);
        
        // Panel tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnCek = new JButton("Cek Cuaca");
        btnClear = new JButton("Hapus");
        btnExit = new JButton("Keluar");
        
        buttonPanel.add(btnCek);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);
        
        // Tambahkan ke frame
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Event Handling
        btnCek.addActionListener(e -> cekCuaca());
        btnClear.addActionListener(e -> clearFields());
        btnExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void cekCuaca() {
        String kota = kotaField.getText().trim();
        if (kota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simulasi hasil cuaca
        String hasilCuaca = "Cerah";
        if (kota.equalsIgnoreCase("Jakarta")) {
            hasilCuaca = "Hujan";
        } else if (kota.equalsIgnoreCase("Bandung")) {
            hasilCuaca = "Mendung";
        }
        
        hasilField.setText(hasilCuaca);
    }

    private void clearFields() {
        kotaField.setText("");
        hasilField.setText("");
        kotaField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CekCuaca::new);
    }
}