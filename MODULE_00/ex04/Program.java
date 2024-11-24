package ex04;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Program {
    static class Pairs {
        private char character;
        private int count;

        public Pairs(char character, int count) {
            this.character = character;
            this.count = count;
        }

        public char getCharacter() {
            return character;
        }

        public int getCount() {
            return count;
        }
    }

    static class PairsList {
        private List<Pairs> pairs;

        public PairsList() {
            pairs = new ArrayList<>();
        }

        public void add(char character) {
            pairs.add(new Pairs(character, 1));
        }

        public void addToCount(char character) {
            for (Pairs pair : pairs) {
                if (pair.getCharacter() == character) {
                    pair.count++;
                    return;
                }
            }
        }

        public List<Pairs> getPairs() {
            return pairs;
        }

        public boolean contains(char character) {
            for (Pairs pair : pairs) {
                if (pair.getCharacter() == character) {
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return pairs.size();
        }
    }


    public static void main(String[] args) {
        PairsList pairsList = new PairsList();
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        for (char character : input) {
            if (pairsList.contains(character))
                pairsList.addToCount(character);
            else
                pairsList.add(character);
        }

        for (Pairs pair : pairsList.getPairs()) {
            System.out.println(pair.getCharacter() + " " + pair.getCount());
        }
        scanner.close();
    }
}
