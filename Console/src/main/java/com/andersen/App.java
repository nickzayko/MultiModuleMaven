package com.andersen;

import java.util.List;
import java.util.Scanner;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input begin price: ");
        int begin = scanner.nextInt();
        System.out.println("Input end price: ");
        int end = scanner.nextInt();

        QueryController controller = new QueryController();
        List list = controller.getCarsWhichPriceBetween(begin, end);

        System.out.println("------------Result-------------");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
