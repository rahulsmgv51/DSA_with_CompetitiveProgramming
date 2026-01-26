package HashMaps.Hashing;

public class Hash_String {

    String str = "RAM";

    public static void main(String[] args) {

        Hash_String obj = new Hash_String(); // create object
        System.out.println("Hash value : " + obj.hashCode());
        System.out.println("Default Hash value : " + "RAM".hashCode());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (str == null ? 0 : str.hashCode());
        return result;
    }
}