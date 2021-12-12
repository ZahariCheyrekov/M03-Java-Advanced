package M03_JavaAdvanced.L08_Generics.Lab.T01JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar =new Jar<>();

        jar.add("First");
        jar.add("Second");
        jar.add("Third");

        System.out.println(jar.remove());
    }
}
