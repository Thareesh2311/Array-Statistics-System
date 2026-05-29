import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ArrayStatisticsSystem extends JFrame implements ActionListener {

    JLabel titleLabel, sizeLabel, arrayLabel;

    JTextField sizeField, arrayField;

    JButton calculateButton;

    JTextArea resultArea;

    public ArrayStatisticsSystem() {

        setTitle("Array Statistics System");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 248, 255));

        titleLabel = new JLabel("ARRAY STATISTICS SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(80, 20, 350, 30);
        add(titleLabel);

        sizeLabel = new JLabel("Enter Array Size:");
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        sizeLabel.setBounds(40, 80, 150, 25);
        add(sizeLabel);

        sizeField = new JTextField();
        sizeField.setBounds(200, 80, 200, 30);
        add(sizeField);

        arrayLabel = new JLabel("Enter Elements (space separated):");
        arrayLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        arrayLabel.setBounds(40, 140, 300, 25);
        add(arrayLabel);

        arrayField = new JTextField();
        arrayField.setBounds(40, 180, 360, 35);
        add(arrayField);

        calculateButton = new JButton("Calculate Statistics");
        calculateButton.setBounds(130, 240, 220, 40);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.setBackground(Color.BLUE);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.addActionListener(this);
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(40, 310, 380, 120);
        resultArea.setFont(new Font("Monospaced", Font.BOLD, 16));
        resultArea.setEditable(false);
        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            int size = Integer.parseInt(sizeField.getText());

            String input = arrayField.getText();

            String[] numbers = input.split(" ");

            if(numbers.length != size) {
                JOptionPane.showMessageDialog(this,
                        "Number of elements does not match array size!");
                return;
            }

            int[] arr = new int[size];

            for(int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }

            int max = arr[0];
            int min = arr[0];
            int sum = 0;
            int evenCount = 0;
            int oddCount = 0;

            for(int i = 0; i < size; i++) {

                if(arr[i] > max) {
                    max = arr[i];
                }

                if(arr[i] < min) {
                    min = arr[i];
                }

                sum += arr[i];

                if(arr[i] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }

            double average = (double) sum / size;

            resultArea.setText(
                    "Maximum Element : " + max + "\n" +
                    "Minimum Element : " + min + "\n" +
                    "Average         : " + average + "\n" +
                    "Even Count      : " + evenCount + "\n" +
                    "Odd Count       : " + oddCount
            );

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter valid input!");
        }
    }

    public static void main(String[] args) {

        new ArrayStatisticsSystem();
    }
}