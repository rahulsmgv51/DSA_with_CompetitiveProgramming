package HashMaps.Hashing;

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