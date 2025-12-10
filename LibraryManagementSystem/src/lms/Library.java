/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author USER
 */

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully.");
    }

    public void borrowBook(int bookId, int memberId) {
        Book bookToBorrow = findBook(bookId);
        Member member = findMember(memberId);

        if (bookToBorrow != null && member != null) {
            if (bookToBorrow.isAvailable()) {
                bookToBorrow.setAvailable(false);
                System.out.println(member.getName() + " successfully borrowed '" + bookToBorrow.getTitle() + "'");
            } else {
                System.out.println("Sorry, that book is currently unavailable.");
            }
        } else {
            System.out.println("Invalid Book ID or Member ID.");
        }
    }

    public void returnBook(int bookId) {
        Book bookToReturn = findBook(bookId);
        if (bookToReturn != null) {
            bookToReturn.setAvailable(true);
            System.out.println("Book '" + bookToReturn.getTitle() + "' returned successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {
        System.out.println("\n--- Library Catalog ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private Member findMember(int id) {
        for (Member m : members) {
            if (m.getMemberId() == id) return m;
        }
        return null;
    }
}