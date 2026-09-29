import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);

    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");

    private JLabel resultLabel = new JLabel("Result: ");

    public CalculatorView() {

        setTitle("MVC Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("First Number:"));
        panel.add(firstNumber);

        panel.add(new JLabel("Second Number:"));
        panel.add(secondNumber);

        panel.add(addButton);
        panel.add(subtractButton);

        panel.add(multiplyButton);
        panel.add(divideButton);

        panel.add(resultLabel);

        add(panel);
    }

    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(double result) {
        resultLabel.setText("Result: " + result);
    }

    public void setButtonListeners(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}