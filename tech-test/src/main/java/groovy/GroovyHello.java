package groovy;


/**
 * java可以直接调用groovy的类
 */
public class GroovyHello {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.sayName1("dcl"));
        System.out.println(person.sayName2("dcl", " wind wind"));
        System.out.println(person.add(3, 5));

    }
}
