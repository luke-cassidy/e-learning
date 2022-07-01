package extensions.callingextensions;

public class CallingExtensions {

    static class Parent {
        public String memberFoo() {
            return "parent";
        }

        public String foo() {
            return "parent";
        }

        public String foo(String string) {
            return "parent: " + string;
        }
    }

    static class Child extends Parent {
        public String memberFoo() {
            return "child";
        }

        public String foo() {
            return "child";
        }

        public String foo(String string) {
            return "child: " + string;
        }
    }

    public static String foo(Parent parent) {
        return "parent";
    }

    public static String foo(Child child) {
        return "child";
    }

    public static String foo(Parent parent, String string) {
        return "parent: " + string;
    }

    public static String foo(Child child, String string) {
        return "child: " + string;
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(foo(parent));
        System.out.println(parent.memberFoo());
        System.out.println(parent.foo());
        System.out.println(parent.foo("test"));
        System.out.println(foo(parent, "test"));
    }
}
