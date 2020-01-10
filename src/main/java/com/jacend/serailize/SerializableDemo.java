package com.jacend.serailize;


import java.io.*;

public class SerializableDemo {

    public static void main(String[] args) {
        User2 user = new User2();
        user.setName("jacend feng");
        user.setAge(30);
        System.out.println(user);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempfile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file = new File("tempfile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            System.out.println(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                file.deleteOnExit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
