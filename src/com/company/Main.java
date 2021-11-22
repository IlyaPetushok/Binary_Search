package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int value;
        String name;
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        ArrayList<String> list = new ArrayList<String>();
        //add name
        while (!flag) {
            System.out.println("Do you want add name in this book?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            value = in.nextInt();
            if (value == 1) {
                name = in.next();
                list.add(name);
            } else {
                flag = true;
                if (list.size() < 2) {
                    System.out.println("book must have more 1 name");
                    flag = false;
                }
            }
        }
        list = SortBook(list);
        System.out.println("Input name you want find");
        name=in.next();
        System.out.println(list.get(BinarySearch(list,name))+"number"+BinarySearch(list,name));
    }

    //sort book for binarysearch
    public static ArrayList<String> SortBook(ArrayList<String> list) {
        boolean flag = true;
        String word1, word2, name;
        int h ;
        while (flag) {
            flag = false;
            for (int i = 0; i < list.size() - 1; i++) {
                h = 1;
                word1 = list.get(i).substring(h - 1, h);
                word2 = list.get(i + 1).substring(h - 1, h);
                while (word1.equals(word2)) {
                    h++;
                    word1 = list.get(i).substring(h - 1, h);
                    word2 = list.get(i + 1).substring(h - 1, h);
                }
                if (Equals(word1) > Equals(word2)) {
                    name = list.get(i + 1);
                    list.set(i + 1, list.get(i));
                    list.set(i, name);
                    flag = true;
                }
            }

        }
        return list;
    }

    //equals Alphabet and word
    public static int Equals(String word) {
        int value = 0;
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        for (int i = 0; i < 23; i++) {
            if (Alphabet.substring(i, i + 1).equals(word.toUpperCase())) {
                value = i + 1;
            }
        }
        return value;
    }

    public static int BinarySearch(ArrayList<String> list,String name){
        int h=1;
        int low=0,high=list.size()-1;
        int index=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(list.get(mid).equals(name)){
                index=mid;
                break;
            }
            else{
                String word1=list.get(mid).substring(h-1,h);
                String word2=name.substring(h-1,h);
                if(Equals(word1)==Equals(word2)){
                    h++;
                    word1=list.get(mid).substring(h-1,h);
                    word2=name.substring(h-1,h);
                }
                if(Equals(word1)>Equals(word2)){
                    high=mid-1;
                }
                if(Equals(word1)<Equals(word2)){
                    low=mid+1;
                }
            }

        }
        return index;
    }
}
