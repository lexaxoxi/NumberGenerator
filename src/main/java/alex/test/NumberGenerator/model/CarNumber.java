package alex.test.NumberGenerator.model;

import jakarta.persistence.*;
import lombok.*;
import java.text.DecimalFormat;
import java.util.Objects;

@Entity
@Table(name = "car_numbers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class CarNumber {

    private static final String REGION = " 116RUS";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    private char firstChar;
    private int number;
    private char secondChar;
    private char thirdChar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumber carNumber = (CarNumber) o;
        return firstChar == carNumber.firstChar &&
                number == carNumber.number &&
                secondChar == carNumber.secondChar &&
                thirdChar == carNumber.thirdChar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstChar, number, secondChar, thirdChar);
    }

    @Override
    public String toString() {
        return firstChar + new DecimalFormat("000").format(number) + secondChar + thirdChar + REGION;
    }

}
