package at.multiflex.Logic;


import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Hashing {
    public String hash(String input)  {
        //String password = "passme";
        return DigestUtils.md5Hex(input).toUpperCase();
        //var md5Hex = DigestUtils.md5Hex(input).toUpperCase();

        //System.out.println(md5Hex);
        //System.out.println(input);
        //System.out.println(md5Hex.equals(hash));
        //return md5Hex;
    }
}
