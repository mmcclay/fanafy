package test;

/**
 * Created with IntelliJ IDEA.
 * User: mmcclay
 * Date: 9/4/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class MikeTree {


    public MikeTree[] roots = new MikeTree[256];

    public void add(String key) {



        if (roots[key.charAt(0)] == null) {
            roots[key.charAt(0)] = new MikeTree();
        }
        MikeTree currentRoot = roots[key.charAt(0)];

        for (int i = 1; i < key.length(); i++) {

            if (currentRoot.roots[key.charAt(i)] == null) {
                currentRoot.roots[key.charAt(i)] = new MikeTree();

            }
            currentRoot = currentRoot.roots[key.charAt(i)];

        }

        return;
    }

    public boolean isWord(String key) {

        MikeTree currentRoot = null;
        int i = 0;

        do {
            currentRoot = roots[key.charAt(i)];
            i++;
        }
        while (currentRoot != null && i < key.length());

        return i == key.length();

    }

    public static void main(String[] args) {

        MikeTree mikeTree = new MikeTree();

        mikeTree.add("hello");
        mikeTree.add("hel");
        mikeTree.add("hab");
        mikeTree.add("abcd");


        mikeTree.isWord("thisisnot");
        mikeTree.isWord("hel");
        mikeTree.isWord("hell");
        mikeTree.isWord("hello");







    }





}
