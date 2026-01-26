Hash_String & Hash_String_withobj

This repository contains two Java classes that demonstrate overriding hashCode() in different ways: mutable vs immutable design.

1️⃣ Hash_String_withobj – Immutable, Constructor-based
Description

This class creates a value object whose str cannot be modified after creation.

Safe for use in hash-based collections like HashMap or HashSet.

Uses a constructor to assign value and a custom hashCode() implementation.

Code
public class Hash_String_withobj {

    private final String str;

    public Hash_String_withobj(String str) {
        this.str = str;
    }

    @Override
    public int hashCode() {
        return 31 * 17 + str.hashCode();
    }

    public static void main(String[] args) {
        System.out.println(new Hash_String_withobj("RAM").hashCode());
    }
}

Features

str is private and final → immutable

hashCode() is deterministic and safe

One-liner object creation in main()

Ideal for enterprise or interview use

2️⃣ Hash_String – Mutable, Default Value
Description

This class demonstrates a simpler, mutable approach.

str is a non-final instance variable with a default value.

Includes null-safe hashCode() calculation.

Code
public class Hash_String {

    String str = "RAM";

    public static void main(String[] args) {

        Hash_String obj = new Hash_String(); // create object
        System.out.println("Hash value : " + obj.hashCode());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (str == null ? 0 : str.hashCode());
        return result;
    }
}

Features

str is mutable → can change after object creation

hashCode() includes null check

Safe for learning and demos, not recommended for hash collections

🔹 Key Differences
Feature	Hash_String_withobj	Hash_String
Mutability	❌ Immutable	✅ Mutable
Constructor enforced	✅ Yes	❌ No
Null-safe	Implicit	Explicit
HashMap safe	✅ Yes	⚠️ Risky if str changes
Use-case	Production & Interviews	Learning / Demo
🔹 Notes / Best Practices

Fields used in hashCode() must not change after object creation.

Always override equals() when overriding hashCode().

final fields + constructor assignment → safest design.

For short immutable objects, Java records (Java 16+) are recommended:

public record Hash_String_Record(String str) {}

🔹 Output Example

For both classes (using "RAM" as str):

Hash value: 2275


The exact integer depends on the hashCode() formula used.

🔹 Summary

Hash_String_withobj → Modern, immutable, safe for collections

Hash_String → Simple, mutable, good for demonstration

Rule of thumb: Immutable + constructor assignment = ✅ hash-safe