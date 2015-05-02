package maekawa;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Simple static methods for the remaining classes. Most of them are (or can be) tested.
 *
 * @author Cassio dos Santos Sousa <dssntss2@illinois.edu>
 * @version 1.0
 */
public final class Utils {

    /**
     * Generates a list containing the subset of a node given its identifier.
     *
     * @param identifier a number between 0 and 8, corresponding to a given node.
     * @return an array list containing five identifiers for the voting set.
     */
    public static ArrayList<Integer> subset(int identifier) {
        if (identifier < 0 || identifier > 8)
            throw new IllegalArgumentException("You set the wrong identifier");
        HashSet<Integer> subset = new HashSet<>();
        subset.add(identifier);
        switch (identifier % 3) {
            case 0:     // First column
                subset.add(identifier + 1);
                subset.add(identifier + 2);
                if (identifier == 3 || identifier == 6)
                    subset.add(0);
                if (identifier == 0 || identifier == 6)
                    subset.add(3);
                if (identifier == 0 || identifier == 3)
                    subset.add(6);
                break;
            case 1:     // Second column
                subset.add(identifier - 1);
                subset.add(identifier + 1);
                if (identifier == 4 || identifier == 7)
                    subset.add(1);
                if (identifier == 1 || identifier == 7)
                    subset.add(4);
                if (identifier == 1 || identifier == 4)
                    subset.add(7);
                break;
            case 2:     // Third column
                subset.add(identifier - 1);
                subset.add(identifier - 2);
                if (identifier == 5 || identifier == 8)
                    subset.add(2);
                if (identifier == 2 || identifier == 8)
                    subset.add(5);
                if (identifier == 2 || identifier == 5)
                    subset.add(8);
                break;
        }
        ArrayList<Integer> subsetList = new ArrayList<>(subset);
        Collections.sort(subsetList);
        return subsetList;
    }

    /**
     * Prints a subset as a sequence of numbers separated only by spaces, no commas or square brackets.
     *
     * @param subset an array list corresponding to a subset.
     * @return a string that removes the square brackets and the commas from the traditional toString() method.
     */
    public static String printSubset(ArrayList<Integer> subset) {
        return subset.toString().replaceAll("[,\\[\\]]", "");
    }

    /**
     * Sorts a list of messages according to their timestamps.
     *
     * @param messageList a list of Message objects.
     */
    public static void sortMessageList(List<Message> messageList) {
        Collections.sort(messageList, (m1, m2) -> (int) (m1.sentTime - m2.sentTime));
    }

}