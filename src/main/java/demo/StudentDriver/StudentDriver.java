package demo.StudentDriver;

import demo.entity.Entity;
import demo.service.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentDriver {
    public static void main(String[] args)  {
        Service service= new Service();
//        loading and connnection will be established
while (true){
        System.out.println("Welocome to my school");

        System.out.println("enter 1 save data");
        System.out.println("enter 2 to update data");
        System.out.println("enter 3 to fetch data");
        System.out.println("enter 4 to delete data");
        System.out.println("enter 5 to exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your choice");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
            System.out.println("enter student id");
            int id = sc.nextInt();
            System.out.println("enter student name");
            String name = sc.next();
            System.out.println("enter student age");
            int age= sc.nextInt();
            Entity st = new Entity();
            st.setId(id);
            st.setName(name);
            st.setAge(age);

            int res = service.save(st);
            if(res!=0){
                System.out.println("data saved");
            }
            break;

        case 2:
        System.out.println("Enter student id to update");
        int vid = sc.nextInt();
        System.out.println("enter new student name");
        String uname= sc.next();
        System.out.println("Enter new student age");
        int vage= sc.nextInt();
        Entity st1= new Entity();
        st1.setId(vid);
        st1.setName(uname);
        st1.setAge(vage);

        int vres= Service.update(st1);
        if (vres!=0){
            System.out.println("data updated");
    }break;
            case 3 :
                List<Entity> list = service.fetch();
                for(Entity lt : list){
                    System.out.println(lt);
                }
                break;

            case 4:
                System.out.println("enter id to delete");
                int id1 = sc.nextInt();
                if (Service.delete(id1)!=0){
                    System.out.println("data deleted");}
                    break;
            case 5:
                System.out.println("thank you");
                sc.close();
                System.exit(0);
            default:
                System.out.println("invalid choice");
                break;
}}}}
