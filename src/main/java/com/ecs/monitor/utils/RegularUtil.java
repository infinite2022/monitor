package com.ecs.monitor.utils;

import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

public class RegularUtil {

    public static boolean checkMobile(String mobile) {
        String str = "^1[3-8]\\d{9}";
        return Pattern.matches(str, mobile);
    }

    public static boolean checkPasswd(String passwd) {
        if (passwd.length() < 6) return false;
        String str = "^[a-zA-Z]\\w{5,17}$";
        return Pattern.matches(str, passwd);
    }
    public static String generalAbsoluteFilePath(String absoluteFilePath) {
        String str = "^/[a-zA-Z]\\w/";
        String str1 = "^/[a-zA-Z]\\w";
        String str2 = "^[a-zA-Z]\\w/";

        if(Pattern.matches(str, absoluteFilePath))
            return absoluteFilePath;
        if(Pattern.matches(str1, absoluteFilePath))
            return absoluteFilePath+"/";
        if(Pattern.matches(str2, absoluteFilePath))
            return "/"+absoluteFilePath;
        return null;
    }

    public static String generalBashFileName(String bashFileName) {
        String str = "^[a-zA-Z]\\w.sh";
        String str1 = "^[a-zA-Z]\\w";
        if(Pattern.matches(str, bashFileName))
            return bashFileName;
        if(Pattern.matches(str1, bashFileName))
            return bashFileName+".sh";
        return null;
    }
    public static boolean checkNumber(@NotNull  String numberString) {
        if (numberString.length() < 4) return false;
        String str = "^\\d{4,5}$";
        return Pattern.matches(str, numberString);
    }
}
