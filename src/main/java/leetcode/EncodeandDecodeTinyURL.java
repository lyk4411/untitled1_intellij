package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/4/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class EncodeandDecodeTinyURL {
    public static void main(String[] args) {
        EncodeandDecodeTinyURL edtu = new EncodeandDecodeTinyURL();
        System.out.println(edtu.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(edtu.decode("0"));
    }
    List<String> urls = new ArrayList<String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index<urls.size())?urls.get(index):"";
    }
}
