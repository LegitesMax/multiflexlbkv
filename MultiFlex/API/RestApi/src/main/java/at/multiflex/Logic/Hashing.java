package at.multiflex.Logic;


import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.ApplicationScoped;

/**
 * A class that handles all regarding hashes
 */
@ApplicationScoped
public class Hashing {
    /**
     * hashes an input string with md5
     * @param input the input string
     * @return the hash string
     */
    public String hash(String input)  {
        return DigestUtils.md5Hex(input).toUpperCase();
    }
}
