public class Main {

    public static void main(String[] args) {
        binaryStreeImplicit bs = new binaryStreeImplicit();

        mydata data = new mydata();

        data.stuName = "Dean";
        data.courseNumber = 80085;
        data.grade = 'F';

        bs.insert(data);

        mydata data2 = new mydata();

        data2.stuName = "Chris";
        data2.courseNumber = 885;
        data2.grade = 'A';

        bs.insert(data2);

        mydata data3 = new mydata();

        data3.stuName = "James";
        data3.courseNumber = 885;
        data3.grade = 'A';

        bs.insert(data3);

        mydata data4 = new mydata();

        data4.stuName = "Adam";
        data4.courseNumber = 885;
        data4.grade = 'A';

        bs.insert(data4);

        mydata data5 = new mydata();

        data5.stuName = "Darwin";
        data5.courseNumber = 885;
        data5.grade = 'A';

        bs.insert(data5);

        int i;
        for (i = 0; i < bs.treeSize; i++) {
            System.out.println(bs.tree.get(i).stuName);
        }
    }
}
