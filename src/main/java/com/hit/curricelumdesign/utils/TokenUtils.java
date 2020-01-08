package com.hit.curricelumdesign.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xbr
 * @Date 2019-12-17
 * @ClassName TokenUtils
 * @Description
 */
public class TokenUtils {

    public static String getToken(int userId, String userName, String pwd, String uuid) {
        String seed = String.format("userId=%s&userName=%s&pwd=%s&uuid=%s", userId, userName, pwd, uuid);
        return DigestUtils.md5Hex(seed);
    }
}
