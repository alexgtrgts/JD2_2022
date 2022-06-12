package entity;

import lombok.*;

@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@MyTable(name = "car")
public class Car {

    public Car(String carname, String color, int price) {
        this.carname = carname;
        this.color = color;
        this.price = price;
    }

    @MyColumn(name = "id")
    private int id;

    @MyColumn(name = "carname")
    private String carname;

    @MyColumn(name = "color")
    private String color;

    @MyColumn(name = "price")
    private int price;

}
