package seminar01.HW01.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

        assertThat(Calculator.calculation(2, 2, '+')).isEqualTo(4);
        assertThat(Calculator.calculation(4, 2, '-')).isEqualTo(2);
        assertThat(Calculator.calculation(8, 2, '/')).isEqualTo(4);
        assertThat(Calculator.calculation(3, 2, '*')).isEqualTo(6);

        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);

        assertThat(Calculator.squareRootExtraction(36.0)).isEqualTo(6);

        // HW Task 01: Positive tests
        assertThat(Calculator.calculateDiscount(100.0, 10)).isEqualTo(90.0);
        assertThat(Calculator.calculateDiscount(200.0, 25)).isEqualTo(150.0);
        assertThat(Calculator.calculateDiscount(100.0,0)).isEqualTo(100.00);
        assertThat(Calculator.calculateDiscount(100.0,100)).isEqualTo(0);
        // Negative tests
        assertThatThrownBy(()->Calculator.calculateDiscount(-50.0, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("The purchase amount cannot be negative.");
        assertThatThrownBy(()->Calculator.calculateDiscount(100.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("The discount amount must be between 0 and 100");
        assertThatThrownBy(()->Calculator.calculateDiscount(100.0, 105))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("The discount amount must be between 0 and 100");
    }
}
