package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void startGrocery(){

        int choice;
        do{
            System.out.println("Yapılmık istenen operasyonu seçin. (0= çıkış, 1= ekleme, 2= çıkarma)");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2 :
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        }
        while(choice != 0);
        scanner.close();
    }

    public static  void addItems(String input){
        String[] items = input.split(",");
        for (String item : items){
            if(!groceryList.contains(item)){
                groceryList.add(item);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input){
        String[] items = input.split(",");
        for(String item : items){
            groceryList.remove(item);
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemsInList(String item){
        return groceryList.contains(item);
    }

    public static void printSorted(){
        sortItems();
        System.out.println("Mevcut Pazar Listesi: ");
        for(String item : groceryList){
            System.out.println(item);
        }
    }

    public static void sortItems(){
        Collections.sort(groceryList);
    }

}
