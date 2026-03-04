package Matura.Hashing;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook(2);
        phoneBook.put("a", 1);
        phoneBook.put("aa", 2);
        phoneBook.put("aaa", 3);
        phoneBook.put("aaaa", 4);
        phoneBook.put("", 1);
        phoneBook.put("aaaa", 5);
        phoneBook.put("bbbb", 6);

        System.out.println();
    }
}
