import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {

        this.model = model;
        this.view = view;

        this.view.setButtonListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(e);
            }
        });
    }

    private void calculate(ActionEvent e) {

        try {

            double firstNumber = view.getFirstNumber();
            double secondNumber = view.getSecondNumber();
            double result;

            if (e.getSource() == view.getAddButton()) {
                result = model.add(firstNumber, secondNumber);

            } else if (e.getSource() == view.getSubtractButton()) {
                result = model.subtract(firstNumber, secondNumber);

            } else if (e.getSource() == view.getMultiplyButton()) {
                result = model.multiply(firstNumber, secondNumber);

            } else {
                if (secondNumber == 0) {
                    view.showError("Cannot divide by zero.");
                    return;
                }

                result = model.divide(firstNumber, secondNumber);
            }

            view.setResult(result);

        } catch (NumberFormatException ex) {
            view.showError("Please enter valid numbers.");
        }
    }
}