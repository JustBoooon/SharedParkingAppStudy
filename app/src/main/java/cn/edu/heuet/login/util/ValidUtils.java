package cn.edu.heuet.login.util;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验、加密工具类
 */
public class ValidUtils {
    /**
     * 账号/手机号校验
     * 不能为空且必须是中国大陆手机号（宽松模式匹配）
     * @param account 手机号
     * @return 匹配校验结果
     */
    public static boolean isPhoneValid(String account) {
        if (account == null) {
            return false;
        }
        // 首位为1, 第二位为3-9, 剩下九位为 0-9, 共11位数字
        String pattern = "^[1]([3-9])[0-9]{9}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(account);
        return m.matches();
    }

    /**
     * 密码校验
     * 不能为空，且长度大于5
     * @param password 密码
     * @return 校验结果
     */
    public static boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    /**
     * 性别校验
     * @param gender 性别
     * @return 校验结果
     */
    public static boolean isGenderValid(String gender) {
        return gender.equals("1") || gender.equals("2");
    }

    /**
     * MD5加密+BASE64编码
     *
     * @return 加密后字符串
     */
    public static String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 注意这里是 Base64.NO_WRAP，不能用 Base64.DEFAULT，否则结尾会带一个 \n
        String newstr = new String(Base64.encode(md5.digest(str.getBytes("utf-8")), Base64.NO_WRAP));
        return newstr;
    }
}
