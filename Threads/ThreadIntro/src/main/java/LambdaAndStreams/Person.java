package LambdaAndStreams;

public class Person {
    String name;
    String gender;
    int age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString(){
        return name+"("+age+")";
    }

}
