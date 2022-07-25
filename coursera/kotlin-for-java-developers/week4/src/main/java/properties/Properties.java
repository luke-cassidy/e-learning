package properties;

import org.jetbrains.annotations.NotNull;

public class Properties {

    public static void main(String[] args) {
        ContactKotlin contactKotlin = new ContactKotlin("Luke", "London");
        System.out.println("contact: " + contactKotlin.getName() + ", lives in: " + contactKotlin.getAddress());

        ContactJava contactJava = new ContactJava("Luke", "London");
        System.out.println("contact: " + contactJava.getName() + ", lives in: " + contactJava.getAddress());

        PersonKotlin personKotlin = new PersonKotlin("Luke", 29);
        System.out.println("person: " + personKotlin.getName() + ", is: " + personKotlin.getAge());

        PersonJava personJava = new PersonJava("Luke", 29);
        System.out.println("person: " + personJava.getName() + ", is: " + personJava.getAge());

    }

    static final class ContactJava {
        @NotNull
        private final String name;
        @NotNull
        private final String address;

        public ContactJava(@NotNull String name, @NotNull String address) {
            this.name = name;
            this.address = address;
        }

        @NotNull
        public final String getName() {
            return name;
        }

        @NotNull
        public final String getAddress() {
            return address;
        }
    }

    static final class PersonJava {
        @NotNull
        private final String name;
        private int age;

        public PersonJava(@NotNull String name, int age) {
            this.name = name;
            this.age = age;
        }

        @NotNull
        public final String getName() {
            return name;
        }

        public final int getAge() {
            return age;
        }

        public final void setAge(int age) {
            this.age = age;
        }
    }

}
