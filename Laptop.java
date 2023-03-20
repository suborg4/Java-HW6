package org.example.hw06;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Класс объекта ноутбук
 */

@Data
@AllArgsConstructor
public class Laptop {

    private final BigDecimal MIN_PRICE = new BigDecimal(0);
    private String manufacturer;
    private String model;
    private Double screenDiagonal;
    private String operatingSystem;
    private Integer ram;
    private String typeOfGraphicsAccelerator;
    private Integer videoMemorySize;
    private Integer hddVolume;
    private String color;
    private BigDecimal price;


    public void setPrice(BigDecimal price) {
        if (price.compareTo(MIN_PRICE) <= 0){
            System.out.println("За подарками к Деду Морозу, цена должна быть выше 0");
        } else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Ноутбук " + manufacturer + " " + model + ":\n" +
                "Диагональ экрана = " + screenDiagonal + '\n' +
                "ОС = " + operatingSystem + '\n' +
                "ОЗУ = " + ram + "Гб" + '\n' +
                "Тип графики = " + typeOfGraphicsAccelerator + '\n' +
                "Объем видеопамяти = " + videoMemorySize + "Гб" + '\n' +
                "Объем HDD = " + hddVolume + "Гб" + '\n' +
                "Цвет = " + color + '\n' +
                "Цена = " + price + '\n';
    }
}