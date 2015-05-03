package br.com.leandro.viajabessaandroid.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by leandro on 5/3/15.
 */
public final class StringUtil
{
    public static String replacePlus(String value)
    {
        String s = "";
        try {
            s = URLDecoder.decode(value.replace("+", " "), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
