package at.multiflex.Logic;


import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Hashing {
    public void hash(String input)  {
        String password = "passme";

        String md5Hex = DigestUtils.md5Hex(input).toUpperCase();

        System.out.println(md5Hex);
        //System.out.println(md5Hex.equals(hash));
    }
}
