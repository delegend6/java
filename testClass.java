/*
BONIFACE DZIGBORDI


*/

package testClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RandomNumbers {

    int indexNumber;
    String fname;
    String lname;
    String dept;
    String level;
    int age;
    private List<Long> l = new ArrayList<>();

    public RandomNumbers() {
        fname = "";
        lname = "";
        dept = "";
        level = "";
        age = 0;
        indexNumber = 0;
    }

    public void addRandom(Long val) {
        l.add(val);

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Long> getL() {
        return l;
    }

    public void setL(List<Long> l) {
        this.l = l;
    }

    int getSize() {
        return l.size();
    }

    Object getValue(int i) {
        return l.get(i);
    }
}

public class testClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int opt;
        int id;
       // List <String> list=new ArrayList<>();
        String li = "";
        Scanner sc = new Scanner(System.in);
          System.out.print("Enter your id : ");
            id = sc.nextInt();
            for (int i = 0; i < id; i++) {

            long randnum = Math.round(Math.random() * 10);
            // list.add(String.valueOf(randnum));
            li  = li.concat(String.valueOf(randnum));
        }
            System.out.println("Class Name from id : "+li);
        RandomNumbers rn = new RandomNumbers();
        OUTER:
        do {
            System.out.println("1 - Register");
            System.out.println("2 - View");
            System.out.print("Enter your choice : ");
            
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    rn = Register();
                    try {
                        try (FileWriter fw = new FileWriter("RandomNumbers.txt")) {
                            fw.write(String.valueOf(rn.getIndexNumber()) + "\n");
                            String value;
                            for (int i = 0; i < rn.getSize(); i++) {
                                fw.write(String.valueOf(rn.getValue(i)) + "-");
                            }

                            fw.write("\n" + rn.getFname() + "\n");
                            fw.write(rn.getLname() + "\n");
                            fw.write(rn.getAge() + "\n");
                            fw.write(rn.getDept() + "\n");
                            fw.write(String.valueOf(rn.getLevel()) + "\n");
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    System.out.println("Success...");
                    break;
                case 2:
                    readdata();
                    break;
                default:
                    break OUTER;
            }
        } while (true);
    }

    private static RandomNumbers Register() {

        RandomNumbers n = new RandomNumbers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index number : ");
        n.setIndexNumber(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter first name : ");
        n.setFname(sc.nextLine());
        System.out.print("Enter last name : ");
        n.setLname(sc.nextLine());

        System.out.print("Enter level : ");
        n.setLevel(sc.nextLine());
        System.out.print("Enter department : ");
        n.setDept(sc.nextLine());

        System.out.print("Enter age : ");
        int a = sc.nextInt();
        n.setAge(a);
        for (int i = 0; i < a; i++) {

            long randnum = Math.round(Math.random() * 1000);
            n.addRandom(randnum);
        }

        sc.nextLine();
        return n;
    }

    private static void readdata() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int res = 1;
        System.out.print("Enter index number : ");
        int idx = sc.nextInt();
        File file = new File("RandomNumbers.txt");
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String str = s.nextLine();
            if (String.valueOf(idx).equals(str)) {
                res = 0;
                while (s.hasNextLine()) {
                    System.out.println(s.nextLine());
                    break;
                }
                break;
            }

        }
        if (res == 1) {
            System.out.println("Index is not found");
        }
        System.out.println();
    }
}
