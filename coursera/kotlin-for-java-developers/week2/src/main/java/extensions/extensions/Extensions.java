package extensions.extensions;

import kotlin.text.StringsKt;

public class Extensions {
    public static void main(String[] args) {
        System.out.println(ExtensionsKt.lastChar("abc"));
        assert ExtensionsKt.lastChar("abc") == 'c';
        System.out.println(StringsKt.last("abc"));
        assert StringsKt.last("abc") == 'c';
        System.out.println(ExtensionsKt.repeat("abc", 5));
        assert ExtensionsKt.repeat("abc", 5).equals("abcabcabcabcabc");
    }
}
