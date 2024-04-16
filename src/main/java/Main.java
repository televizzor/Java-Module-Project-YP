import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class RubFormat{
    int rub;

    String formatter(int rub){

        this.rub = rub;
        String ruble = "";
        if (rub >= 10){
            ruble = "Рублей";
        } else {
            switch (rub){
                case 1:
                    ruble = "Рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    ruble = "Рубля";
                    break;
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    ruble = "Рублей";
                    break;
            }

        }

        return ruble;

    }
}


class Product{
    String name;
    float price;

    Product(String name,float price){
        this.name = name;
        this.price = price;
    }

}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        System.out.println("Введите количество гостей среди которых нужно разделить счёт");
        int peoples = 0;
        float sum = 0;
        while (true){
            if (sc.hasNextInt()) {
                peoples = sc.nextInt();
                if (peoples < 1) {
                    System.out.println("Введите правильное количество гостей");
                    continue;
                } else if (peoples == 1){
                    System.out.println("Делить не нужно, конец программы");
                    return;
                } else {
                    System.out.println("Количество гостей: " + peoples);
                    break;
                }
            } else {
                System.out.println("Введите целое число гостей");
                //sc.next();
                continue;
            }

        }
        sc.nextLine();
        while(true){
            System.out.println("Введите название товара или 'Завершить' для отмены");
            String name = sc.nextLine();
            if (name.isEmpty()){
                System.out.println("Название товара не может быть пустым");
                continue;

            } else if (name.matches("\\d+")){
                System.out.println("Название товара не может состоять только из цифр");
                continue;
                
            } else if (name.equalsIgnoreCase("Завершить")) {
                break;
            }


            System.out.println("Введите цену товара");
            while(true){

                if(sc.hasNextFloat()){
                    float price = sc.nextFloat();
                    sc.nextLine();
                    if (price > 0){
                        products.add(new Product(name,price));
                        sum += price;
                        System.out.println("Товар " + name + " добавлен со стоимостью " + price);
                        break;
                    } else System.out.println("Введите корректную цену товара");

                } else {
                    System.out.println("Введите число");
                    sc.next();
                }


            }

        }
        if (products.isEmpty()) {
            System.out.println("Вы не добавили ни одного товара");
        } else System.out.println("Добавленные товары: ");
        ;
        for (int i = 0; i < products.size(); i++){
            System.out.println("Товар: " + products.get(i).name + " стоимостью: " + products.get(i).price);
        }
        RubFormat rubFormat = new RubFormat();
        float totalSum = sum/(float)peoples;
        int rub = (int) totalSum;
        if ((int)totalSum > 10 && (int)totalSum <= 20) {
            rub = (int) totalSum;
        } else {
            rub = (int) totalSum % 10;

        }

        String ruble = rubFormat.formatter(rub);

        System.out.print(String.format("Каждый гость должен заплатить: %.2f %s",totalSum, ruble ));





    }
}