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

        public void sort() {
            pairs.sort((a, b) -> {
                if (a.getCount() == b.getCount())
                    return a.getCharacter() - b.getCharacter();
                return b.getCount() - a.getCount();
            });
        }

        public int getCountWidth(Pairs pair) {
            if (pair.getCount() >= 100) return 3;
            else if (pair.getCount() >= 10) return 2;
            else return 1;
        }

        public void printGraph() {
            if (pairs.isEmpty()) return;
            
            int displayCount = Math.min(10, pairs.size());
            int maxCount = pairs.get(0).getCount();
            int graphHeight = 10;
        
            for (int row = graphHeight; row >= 1; row--) {
                for (int i = 0; i < displayCount; i++) {
                    Pairs pair = pairs.get(i);
                    double proportion = (double) pair.getCount() / maxCount;
                    int height = (int) Math.round(proportion * graphHeight);
                    
                    int countWidth = getCountWidth(pair);
                    
                    if (height == row) {
                        if (i > 0) System.out.print(" ");
                        System.out.print(pair.getCount());
                    } else if (height > row) {
                        if (i > 0) System.out.print(" ");
                        for (int j = 1; j < countWidth; j++) System.out.print(" ");
                        System.out.print("#");
                    } else {
                        if (i > 0) System.out.print(" ");
                        for (int j = 0; j < countWidth; j++) System.out.print(" ");
                    }
                }
                System.out.println();
            }
        
            for (int i = 0; i < displayCount; i++) {
                if (i > 0) System.out.print(" ");
                int countWidth = getCountWidth(pairs.get(i));
                for (int j = 1; j < countWidth; j++) System.out.print(" ");
                System.out.print(pairs.get(i).getCharacter());
            }
            System.out.println();
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
        pairsList.sort();

        pairsList.printGraph();
        scanner.close();
    }
}
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42