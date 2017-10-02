package com.kodlla;

import java.util.*;
import java.lang.*;
import java.io.*;

class Book {

    String author;
    String title;

    public Book (String author, String title) {
        this.author = author;
        this.title = title;
    }

    public boolean equals(Book e) {
        return (this.author == e.author) && (this.title == e.title);
    }

    public int hashCode() {
        return title.length() + author.length();
    }
}

class MyMeasureTest {

    public static void main (String[] args) throws java.lang.Exception {
        long begin = System.nanoTime();
        LinkedList<Book> myList = new LinkedList<Book>();
        for(int n = 0; n < 50; n++) {
            myList.add(new Book("Author" + n, "Title" + n));
        }
        long end = System.nanoTime();
        System.out.println("Creating has taken:" + (end - begin) + "nano sec");

        System.out.println("Quantity of elements in the LinkedList:" + myList.size());
        // remove element at the beginning of the collection
        begin = System.nanoTime();
        myList.remove(0);
        end = System.nanoTime();

        System.out.println("Removing the element at the beginning of collection has taken:" + (end - begin) + "nano sec");

        //remove element at the end of collection
        begin = System.nanoTime();
        myList.remove(myList.size()-1);
        end = System.nanoTime();

        System.out.println("Removing the element at the end of collection has taken:" + (end - begin) + "nano sec");

        //add element in the beginning of the collection
        begin = System.nanoTime();
        myList.add(0, new Book("Katarzyna Grochola", "Abc"));
        end = System.nanoTime();

        System.out.println("Adding element at the beginning of the collection has taken: " + (end - begin) + "nano sec");

        // add element in the end of the collection
        begin = System.nanoTime();
        myList.add(myList.size(),  new Book("Ernest Hemingway", "Podróż"));
        end = System.nanoTime();
        System.out.println("Adding element in the end of the collection has taken: " + (end - begin) + "nano sec");

        System.out.println("Quantity of elements in the LinkedList:" + myList.size());

        HashMap<Book, Integer> myHashMap = new HashMap<>();

        for(int n = 0; n < 400; n++) {
            Book book = new Book("Author" + n, "Title" + n) ;
            myHashMap.put(book, n);
        }

        System.out.println("HashMap size is:" + myHashMap.size());
        Book book = new Book("Author" , "Title") ;

        begin = System.nanoTime();
        myHashMap.put(book, 1);
        end = System.nanoTime();
        System.out.println("Adding one entry to hashMap: " + (end - begin) + "nano sec");

        begin = System.nanoTime();
        myHashMap.remove(book, myList);
        end = System.nanoTime();
        System.out.println("Remove one entry to hashMap: " + (end - begin) + "nano sec");
    }
}
