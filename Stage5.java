package budget;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Stage5 {

    public static void main(String[] args) throws IOException {

        Map<String, Double> all = new LinkedHashMap<>();
        Map<String, Double> sortedAll = new LinkedHashMap<>();

        Map<String, Double> sortedType = new LinkedHashMap<>();
        Map<String, Double> sortedT = new LinkedHashMap<>();
        Map<String, Double> sortedFood = new LinkedHashMap<>();
        Map<String, Double> sortedClothes = new LinkedHashMap<>();
        Map<String, Double> sortedEntertain = new LinkedHashMap<>();
        Map<String, Double> sortedOther = new LinkedHashMap<>();

        Map<String, Double> food = new LinkedHashMap<>();
        Map<String, Double> cloth = new LinkedHashMap<>();
        Map<String, Double> entertain = new LinkedHashMap<>();
        Map<String, Double> other = new LinkedHashMap<>();

        boolean exit = true; boolean exit2 = true; boolean exit3 = true;
        double balance = 0;
        double total = 0; double food_total = 0; double cloth_total = 0; double entertain_total = 0; double other_total = 0;
        do {
            System.out.println("\nChoose your action:\n1) Add income\n2) Add purchase\n3) Show list of purchases\n4) Balance\n5) Save\n6) Load\n7) Analyze (Sort)\n0) Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch(option) {
                case 1:
                    System.out.println();
                    System.out.println("Enter income:");
                    int income = sc.nextInt();
                    balance = balance + income;
                    System.out.println("Income was added!");
                    break;
                case 2:
                    do {
                        System.out.println("\nChoose the type of purchase\n1) Food\n2) Clothes\n3) Entertainment\n4) Other\n5) Back");
                        int opt2 = sc.nextInt();
                        switch(opt2) {
                            case 1:
                                System.out.println("\nEnter purchase name:");
                                sc.nextLine();
                                String food_name = sc.nextLine();
                                System.out.println("Enter its price:");
                                double food_price = sc.nextDouble();
                                balance -= food_price;
                                String str_food_price = String.format("%1.2f", food_price);
                                food.put(food_name+" $"+str_food_price, food_price);
                                all.put(food_name+" $"+str_food_price, food_price);
                                System.out.println("Purchase was added!");
                                break;
                            case 2:
                                System.out.println("\nEnter purchase name:");
                                sc.nextLine();
                                String cloth_name = sc.nextLine();
                                System.out.println("Enter its price:");
                                double cloth_price = sc.nextDouble();
                                balance -= cloth_price;
                                String str_cloth_price = String.format("%1.2f", cloth_price);
                                cloth.put(cloth_name+" $"+str_cloth_price, cloth_price);
                                all.put(cloth_name+" $"+str_cloth_price, cloth_price);
                                System.out.println("Purchase was added!");
                                break;
                            case 3:
                                System.out.println("\nEnter purchase name:");
                                sc.nextLine();
                                String entertain_name = sc.nextLine();
                                System.out.println("Enter its price:");
                                double entertain_price = sc.nextDouble();
                                balance -= entertain_price;
                                String str_entertain_price = String.format("%1.2f", entertain_price);
                                entertain.put(entertain_name+" $"+str_entertain_price, entertain_price);
                                all.put(entertain_name+" $"+str_entertain_price, entertain_price);
                                System.out.println("Purchase was added!");
                                break;
                            case 4:
                                System.out.println("\nEnter purchase name:");
                                sc.nextLine();
                                String other_name = sc.nextLine();
                                System.out.println("Enter its price:");
                                double other_price = sc.nextDouble();
                                balance -= other_price;
                                String str_other_price = String.format("%1.2f", other_price);
                                other.put(other_name+" $"+str_other_price, other_price);
                                all.put(other_name+" $"+str_other_price, other_price);
                                System.out.println("Purchase was added!");
                                break;
                            case 5:
                                System.out.println();
                                exit2 = false;
                                break;
                        }
                    }while(exit2);
                    break;
                case 3:
                    if(all.isEmpty()) {
                        System.out.println("\nThe purchase list is empty!\n");
                    }else {
                        do {
                            System.out.println("\nChoose the type of purchases\n1) Food\n2) Clothes\n3) Entertainment\n4) Other\n5) All\n6) Back");
                            int opt3 = sc.nextInt();
                            switch(opt3) {
                                case 1:
                                    System.out.println();
                                    if(food.isEmpty()) {
                                        System.out.println("The purchase list is empty!");
                                    }else {
                                        System.out.println("Food:");
                                        food.forEach((name, price) -> System.out.println(name));
                                        food_total = food.values().stream().mapToDouble(d -> d).sum();
                                        System.out.print("Total sum: $");
                                        System.out.printf("%.2f", food_total);
                                        System.out.println();
                                    }
                                    break;
                                case 2:
                                    System.out.println();
                                    if(cloth.isEmpty()) {
                                        System.out.println("The purchase list is empty!");
                                    }else {
                                        System.out.println("Clothes:");
                                        cloth.forEach((name, price) -> System.out.println(name));
                                        cloth_total = cloth.values().stream().mapToDouble(d -> d).sum();
                                        System.out.print("Total sum: $");
                                        System.out.printf("%.2f", cloth_total);
                                        System.out.println();
                                    }
                                    break;
                                case 3:
                                    System.out.println();
                                    if(entertain.isEmpty()) {
                                        System.out.println("The purchase list is empty!");
                                    }else {
                                        System.out.println("Entertainment:");
                                        entertain.forEach((name, price) -> System.out.println(name));
                                        entertain_total = entertain.values().stream().mapToDouble(d -> d).sum();
                                        System.out.print("Total sum: $");
                                        System.out.printf("%.2f", entertain_total);
                                        System.out.println();
                                    }
                                    break;
                                case 4:
                                    System.out.println();
                                    if(other.isEmpty()) {
                                        System.out.println("The purchase list is empty!");
                                    }else {
                                        System.out.println("Other:");
                                        other.forEach((name, price) -> System.out.println(name));
                                        other_total = other.values().stream().mapToDouble(d -> d).sum();
                                        System.out.print("Total sum: $");
                                        System.out.printf("%.2f", other_total);
                                        System.out.println();
                                    }
                                    break;
                                case 5:
                                    System.out.println();
                                    System.out.println("All:");
                                    all.forEach((name, price) -> System.out.println(name));
                                    total = all.values().stream().mapToDouble(d -> d).sum();
                                    System.out.print("Total sum: $");
                                    System.out.printf("%.2f", total);
                                    System.out.println();
                                    break;
                                case 6:
                                    System.out.println();
                                    exit3 = false;
                                    break;
                            }

                        }while(exit3);
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Balance: $");
                    System.out.printf("%.2f", balance);
                    System.out.println();
                    break;
                case 5:
                    BufferedWriter bw = new BufferedWriter(new FileWriter("purchases.txt"));
                    String p_balance = String.format("%1.2f", balance);
                    bw.write("Balance: $"+p_balance+"\n");

                    food.forEach((name, grade) -> {
                        try {
                            bw.write("1)"+name+System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    cloth.forEach((name, grade) -> {
                        try {
                            bw.write("2)"+name+System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    entertain.forEach((name, grade) -> {
                        try {
                            bw.write("3)"+name+System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    other.forEach((name, grade) -> {
                        try {
                            bw.write("4)"+name+System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    total = all.values().stream().mapToDouble(d -> d).sum();
                    String p_total = String.format("%1.2f", total);
                    bw.write("Total sum: $"+p_total);

                    bw.close();
                    System.out.println("Purchases were saved!");
                    break;
                case 6:
                    BufferedReader br = new BufferedReader(new FileReader("purchases.txt"));
                    int n = 0;
                    String s;
                    while((s = br.readLine()) != null) {
                        n += 1;
                    }

                    for(int i=0; i < n; ++i) {
                        String line= Files.readAllLines(Paths.get("purchases.txt")).get(i);
                        String[] splt = line.split("\\$");
                        if (splt.length == 2) {
                            if (line.charAt(0) == '1') {
                                String loaded_f = splt[0].replaceAll("1\\)", "");
                                food.put(loaded_f + "$" + splt[1], Double.valueOf(splt[1]));
                                all.put(loaded_f + "$" + splt[1], Double.valueOf(splt[1]));
                            } else if (line.charAt(0) == '2') {
                                String loaded_c = splt[0].replaceAll("2\\)", "");
                                cloth.put(loaded_c + "$" + splt[1], Double.valueOf(splt[1]));
                                all.put(loaded_c + "$" + splt[1], Double.valueOf(splt[1]));
                            } else if (line.charAt(0) == '3') {
                                String loaded_e = splt[0].replaceAll("3\\)", "");
                                entertain.put(loaded_e + "$" + splt[1], Double.valueOf(splt[1]));
                                all.put(loaded_e + "$" + splt[1], Double.valueOf(splt[1]));
                            } else if (line.charAt(0) == '4') {
                                String loaded_o = splt[0].replaceAll("4\\)", "");
                                other.put(loaded_o + "$" + splt[1], Double.valueOf(splt[1]));
                                all.put(loaded_o + "$" + splt[1], Double.valueOf(splt[1]));
                            } else if (line.charAt(0) == 'B') {
                                balance = Double.valueOf(splt[1]);
                            } else if (line.charAt(0) == 'T') {
                                total = Double.valueOf(splt[1]);
                            }
                        }else if (splt.length == 3){
                            if(line.charAt(0) == '1') {
                                String loaded_f = splt[0].replaceAll("1\\)", "");
                                food.put(loaded_f+"$"+splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                                all.put(loaded_f+"$"+splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                            }else if(line.charAt(0) == '2') {
                                String loaded_c = splt[0].replaceAll("2\\)", "");
                                cloth.put(loaded_c+"$"+splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                                all.put(loaded_c+"$"+splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                            }else if(line.charAt(0) == '3') {
                                String loaded_e = splt[0].replaceAll("3\\)", "");
                                entertain.put(loaded_e+"$"+splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                                all.put(loaded_e+"$"+splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                            }else if(line.charAt(0) == '4') {
                                String loaded_o = splt[0].replaceAll("4\\)", "");
                                other.put(loaded_o + "$" + splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                                all.put(loaded_o + "$" + splt[1]+"$"+splt[2], Double.valueOf(splt[2]));
                            }
                        }

                    }
                    System.out.println("\nPurchases were loaded!");
                    break;
                case 7:
                    int c = 0;
                    do {
                        System.out.println("\n1) Sort all purchases\n2) Sort by type\n3) Sort certain type\n4) Back");
                        int opt7 = sc.nextInt();
                        switch(opt7) {
                            case 1:
                                if(all.isEmpty()) {
                                    System.out.println("\nThe purchase list is empty!");
                                }else {
                                    System.out.println("\nAll:");
                                    sortedAll = all.entrySet()
                                            .stream()
                                            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                            .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                                                    (entry1, entry2) -> entry2, LinkedHashMap::new));
                                    sortedAll.forEach((str, price) -> System.out.println(str));
                                    total = all.values().stream().mapToDouble(d -> d).sum();
                                    System.out.print("Total sum: $");
                                    System.out.printf("%.2f", total);
                                    System.out.println();
                                }
                                break;
                            case 2:
                                System.out.println("\nTypes:");
                                if(all.isEmpty()) {
                                    System.out.println("Food - $0\nEntertainment - $0\nClothes - $0\nOther - $0\nTotal sum: $0");
                                }else {
                                    food_total = food.values().stream().mapToDouble(d -> d).sum();
                                    cloth_total = cloth.values().stream().mapToDouble(d -> d).sum();
                                    entertain_total = entertain.values().stream().mapToDouble(d -> d).sum();
                                    other_total = other.values().stream().mapToDouble(d -> d).sum();
                                    total = all.values().stream().mapToDouble(d -> d).sum();
                                    String str_food = String.format("%1.2f", food_total);
                                    String str_entertain = String.format("%1.2f", entertain_total);
                                    String str_cloth = String.format("%1.2f", cloth_total);
                                    String str_other = String.format("%1.2f", other_total);

                                    sortedType.put("Food - $"+str_food, food_total);
                                    sortedType.put("Entertainment - $"+str_entertain, entertain_total);
                                    sortedType.put("Clothes - $"+str_cloth, cloth_total);
                                    sortedType.put("Other - $"+str_other, other_total);

                                    sortedT = sortedType.entrySet()
                                            .stream()
                                            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                            .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                                                    (entry1, entry2) -> entry2, LinkedHashMap::new));
                                    sortedT.forEach((str, price) -> System.out.println(str));
                                    System.out.print("Total sum: $");
                                    System.out.printf("%.2f", total);
                                    System.out.println();
                                }
                                break;
                            case 3:
                                System.out.println("\nChoose the type of purchase\n1) Food\n2) Clothes\n3) Entertainment\n4) Other");
                                int opt7_3 = sc.nextInt();
                                switch(opt7_3) {
                                    case 1:
                                        if(food.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        }else {
                                            System.out.println("\nFood:");
                                            sortedFood = food.entrySet()
                                                    .stream()
                                                    .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                                                            (entry1, entry2) -> entry2, LinkedHashMap::new));
                                            sortedFood.forEach((str, price) -> System.out.println(str));
                                            food_total = food.values().stream().mapToDouble(d -> d).sum();
                                            System.out.print("Total sum: $");
                                            System.out.printf("%.2f", food_total);
                                            System.out.println();
                                        }
                                        break;
                                    case 2:
                                        if(cloth.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        }else {
                                            System.out.println("\nClothes:");
                                            sortedClothes = cloth.entrySet()
                                                    .stream()
                                                    .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                                                            (entry1, entry2) -> entry2, LinkedHashMap::new));
                                            sortedClothes.forEach((str, price) -> System.out.println(str));
                                            cloth_total = cloth.values().stream().mapToDouble(d -> d).sum();
                                            System.out.print("Total sum: $");
                                            System.out.printf("%.2f", cloth_total);
                                            System.out.println();
                                        }
                                        break;
                                    case 3:
                                        if(entertain.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        }else {
                                            System.out.println("\nEntertainment:");
                                            sortedEntertain = entertain.entrySet()
                                                    .stream()
                                                    .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                                                            (entry1, entry2) -> entry2, LinkedHashMap::new));
                                            sortedEntertain.forEach((str, price) -> System.out.println(str));
                                            entertain_total = entertain.values().stream().mapToDouble(d -> d).sum();
                                            System.out.print("Total sum: $");
                                            System.out.printf("%.2f", entertain_total);
                                            System.out.println();
                                        }
                                        break;
                                    case 4:
                                        if(other.isEmpty()) {
                                            System.out.println("\nThe purchase list is empty!");
                                        }else {
                                            System.out.println("\nOther:");
                                            sortedOther = other.entrySet()
                                                    .stream()
                                                    .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                                                    .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                                                            (entry1, entry2) -> entry2, LinkedHashMap::new));
                                            sortedOther.forEach((str, price) -> System.out.println(str));
                                            other_total = other.values().stream().mapToDouble(d -> d).sum();
                                            System.out.print("Total sum: $");
                                            System.out.printf("%.2f", other_total);
                                            System.out.println();
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                System.out.println();
                                c +=1;
                                break;
                        }
                    }while(c == 0);
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Bye!");
                    exit = false;
                    break;
            }
        }while(exit);
    }
}
