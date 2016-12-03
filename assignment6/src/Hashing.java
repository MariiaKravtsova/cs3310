import java.util.ArrayList;

/**
 *
 */
public class Hashing {

    private static final int SIZE = 659;

    ArrayList<String> studentList = new ArrayList<String>(SIZE);

    public void add(String studentname) {
        int hash;
        int i;

        hash = 7;
        for (i = 0; i < studentname.length(); i++) {
            hash = hash^studentname.charAt(i);
        }
        System.out.print(hash);
        //studentList.add(hash, studentname);
    }
}
