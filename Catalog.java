package org.example.hw06;

import java.math.BigDecimal;
import java.util.*;

public class Catalog {
    Laptop l1 = new Laptop("Huawei", 15.6, "Free DOS",16, "Nvidia RTX 3060",
            6, 1000, "Gray", new BigDecimal(1000));
    Laptop l2 = new Laptop("Honor", 17.3, "Windows 10",8, "Intel UHD Graphics",
            0, 256, "Blue", new BigDecimal(500));
    Laptop l3 = new Laptop("Digma", 15.6, "No OS", 8, "Intel Iris Xe graphics",
            0, 512, "Black", new BigDecimal(700));
    Laptop l4 = new Laptop("CHUWI", 17.3, "Windows 11", 8, "AMD Radeon Graphics",
            4, 2000, "Silver", new BigDecimal(300));
    public List<Laptop> allLaptops = new ArrayList<>(Arrays.asList(l1, l2, l3, l4));

    public static int findChoice(Map<Integer, String> mapList) {
        int choice = -1;
        printMap(mapList);
        Scanner s = new Scanner(System.in);
        System.out.print("Введите цифру: ");
        while (choice < 1 || choice > mapList.size()) {
            if (s.hasNextInt()) choice = s.nextInt();
            if (!(choice > 0 && choice < mapList.size()+1)) {
                System.out.println("/Такой цифры нет");
                System.out.print("Введите цифру: ");
                s.nextLine();
            }
        }
        return choice;
    }

    public void filterList(Integer num){
        int count = 1;
        int choice;
        Map <Integer, String> findList = new HashMap<>();
        switch (num){
            case (1):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getManufacturer())){
                        findList.put(count, el.getManufacturer());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getManufacturer().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (2):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getScreenDiagonal().toString())){
                        findList.put(count, el.getScreenDiagonal().toString());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getScreenDiagonal().toString().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (3):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getProcessorManufacturer())){
                        findList.put(count, el.getProcessorManufacturer());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getProcessorManufacturer().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (4):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getTypeOfGraphicsAccelerator())){
                        findList.put(count, el.getTypeOfGraphicsAccelerator());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getTypeOfGraphicsAccelerator().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case (5):
                for (Laptop el: allLaptops) {
                    if (!findList.values().contains(el.getStorageType())){
                        findList.put(count, el.getStorageType());
                        count++;
                    }
                }
                choice = findChoice(findList);
                for (Laptop el: allLaptops) {
                    if (el.getStorageType().equals(findList.get(choice))){
                        System.out.println(el);
                    }
                }
                break;
            case(6):
                System.out.println("Будет показан ноутбук с минимально близкой ценой!");
                int sum = 0;
                Scanner s = new Scanner(System.in);
                System.out.print("Введите сумму: ");
                while (sum <= 0) {
                    if (s.hasNextInt()) sum = s.nextInt();
                    if (sum <= 0) {
                        System.out.println("Не корректный ввод!");
                        System.out.print("Введите сумму: ");
                        s.nextLine();
                    }
                }
                NavigableSet <BigDecimal> priceSet = new TreeSet<>();
                for (Laptop el: allLaptops) {
                    priceSet.add(el.getPrice());
                }
                BigDecimal find = priceSet.floor(BigDecimal.valueOf(sum));
                if (find == null) find = priceSet.ceiling(BigDecimal.valueOf(sum));

                for (Laptop el: allLaptops) {
                    if (el.getPrice().compareTo(find) == 0){
                        System.out.println(el);
                    }
                }
                break;
        }
    }

    public static void printMap(Map <Integer, String> map){
        for (Map.Entry<Integer, String> item : map.entrySet()) {
            System.out.printf("%d - %s;%n", item.getKey(), item.getValue());
        }
    }
}
