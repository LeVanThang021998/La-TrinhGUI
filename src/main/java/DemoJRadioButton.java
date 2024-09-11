import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DemoJRadioButton extends JFrame {

    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txtSo1, txtSo2, txtKq;
    private JButton btTinh;
    private JRadioButton rdCong, rdTru, rdNhan, rdChia;

    public DemoJRadioButton() {
        setTitle("Tính toán đơn giản");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2, 5, 5));

        // First row: Input So 1
        p1.add(lb1 = new JLabel("Số 1:"));
        p1.add(txtSo1 = new JTextField());
        txtSo1.setPreferredSize(new Dimension(100, 30));

        // Second row: Input So 2
        p1.add(lb2 = new JLabel("Số 2:"));
        p1.add(txtSo2 = new JTextField());

        // Third row: Operation selection (Phép tính)
        p1.add(lb3 = new JLabel("Phép tính:"));
        JPanel p2 = new JPanel();
        p2.add(rdCong = new JRadioButton("+"));
        p2.add(rdTru = new JRadioButton("-"));
        p2.add(rdNhan = new JRadioButton("*"));
        p2.add(rdChia = new JRadioButton("/"));
        p1.add(p2);

        // Group the radio buttons
        ButtonGroup btgPhepTinh = new ButtonGroup();
        btgPhepTinh.add(rdCong);
        btgPhepTinh.add(rdTru);
        btgPhepTinh.add(rdNhan);
        btgPhepTinh.add(rdChia);
        rdCong.setSelected(true); // Default to addition

        // Fourth row: Display result (Kết quả)
        p1.add(new JLabel("Kết quả:"));
        p1.add(txtKq = new JTextField());
        txtKq.setEditable(false); // Result field should be read-only

        // Add the panel to the frame
        add(p1);

        // Add button "Tính" to the bottom of the frame
        add(btTinh = new JButton("Tính"), BorderLayout.SOUTH);

        // Action listener for the "Tính" button
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get values from input fields
                    double x = Double.parseDouble(txtSo1.getText());
                    double y = Double.parseDouble(txtSo2.getText());
                    double Kq;

                    // Check which operation is selected
                    if (rdCong.isSelected()) {
                        Kq = x + y;
                    } else if (rdTru.isSelected()) {
                        Kq = x - y;
                    } else if (rdNhan.isSelected()) {
                        Kq = x * y;
                    } else {
                        if (y == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        Kq = x / y;
                    }

                    // Display the result
                    txtKq.setText(String.valueOf(Kq));
                } catch (NumberFormatException ex) {
                    txtKq.setText("Invalid input");
                } catch (ArithmeticException ex) {
                    txtKq.setText("Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        DemoJRadioButton frm = new DemoJRadioButton();
        frm.setVisible(true);
    }
}
