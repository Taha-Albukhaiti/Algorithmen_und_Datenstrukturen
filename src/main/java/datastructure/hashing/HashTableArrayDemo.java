package datastructure.hashing;

public class HashTableArrayDemo {
    public static void main(String[] args) {
        HashTableArray<String> hashTableArray = new HashTableArray<>(5);
        hashTableArray.put(11, "Ali");
        hashTableArray.put(16, "kali");
        hashTableArray.put(15, "Taha");
        System.out.println(hashTableArray.get(11) + " und sein Index im Array ist: " + hashTableArray.getHash(11));
        System.out.println(hashTableArray.get(16) + " und sein Index im Array ist: " + hashTableArray.getHash(16));
        System.out.println(hashTableArray.get(15) + " und sein Index im Array ist: " + hashTableArray.getHash(15));
    }
}
