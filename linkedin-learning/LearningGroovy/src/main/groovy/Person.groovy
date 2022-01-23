import groovy.transform.Canonical
import groovy.transform.ToString

@Canonical()
@ToString(excludes = ["fullName", "middleAged"])
class Person implements Serializable {
    String firstName
    String lastName
    int age

    String getFullName() {
        firstName + " " + lastName
    }

    boolean isMiddleAged() {
        if (age >= 45 && age <= 65) {
            true
        } else {
            false
        }
    }
}
