package demo.entity;

public class Entity {
    int id;
    String name;
    int age;

    public Entity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Entity() {
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
