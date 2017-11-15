package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * 加密工具类
 *
 * @author wwj <wangweijie@techwolf.cn>
 * @ClassName: SecurityUtils
 * @date 2014年2月10日 下午2:59:26
 */
public class SecurityUtils {
    private final static Log logger = LogFactory.getLog(SecurityUtils.class);
    private static final String DEFAULT_CHARSET = "UTF-8";
    //注意：请不要随意修改当前Key，IOS同样依赖当前key进行解密
    private static final String RC4_DEFAULT_PASSWORD = "3984aF333#@213";

    /**
     * 取MD5加密的secretKey的后8位当做密钥
     *
     * @param sourceSecretKey
     * @return
     */
    private static String getSecretKey(String sourceSecretKey) {
        String md5secretKey = MD5Encode(sourceSecretKey);
        return md5secretKey.substring(md5secretKey.length() - 8);
    }

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * MD5加密
     *
     * @param str
     * @return
     */
    public static String MD5Encode(String str) {
        if (str == null) return null;

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            return byteArrayToHexString(md.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * MD5加密
     *
     * @param str
     * @return
     */
    public static String MD5Encode(String str, String encoding) {
        if (str == null) return null;

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            return byteArrayToHexString(md.digest(str.getBytes(encoding)));
        } catch (Exception e) {
            return null;
        }
    }

    public static String MD5Encode(InputStream input) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            byte[] b = new byte[1024 * 10];
            int length = -1;

            while ((length = input.read(b)) > -1) {
                messagedigest.update(b, 0, length);
            }
            return bufferToHex(messagedigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("InputStream md5 name error");
        } finally {
            if (null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("InputStream md5 name close error");
                }
            }
        }
    }

    public static String sha1Encrypt(String str) {
        String result = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            result = hexString.toString();
            return result;

        } catch (NoSuchAlgorithmException e) {
        }
        return result;
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        String c0 = hexDigits[(bt & 0xf0) >> 4];
        String c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static final char[] c = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz".toCharArray();

    /**
     * 获得指定长度的随机字符串
     *
     * @param len
     * @return
     */
    public static String getRandomString(int len) {
        if (len < 1) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(c[random.nextInt(c.length)]);
        }
        return sb.toString();
    }

    public static String UUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 加密(空实现)
     * 加密字符串和原字符串长度基本相同
     * 主要针对页面ID的加密
     *
     * @param source
     * @return
     * @deprecated
     */
    public static String encryptRC4(Object source) {
/*        String encrypt = "";
        try {
            encrypt = Base64.encode(RC4.RC4encrypt(RC4_DEFAULT_PASSWORD.getBytes(DEFAULT_CHARSET),
                    String.valueOf(source).getBytes(DEFAULT_CHARSET)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encrypt.replaceAll("/", "_").replaceAll("\\+", "-").replaceAll("=", "~");*/
        return String.valueOf(source);
    }


    /**
     * 加密
     * 加密字符串和原字符串长度基本相同
     * 主要针对页面ID的加密
     *
     * @param source
     * @return
     */
    public static String rc4Encrypt(Object source) {
        return rc4Encrypt(source, RC4_DEFAULT_PASSWORD);
    }

    public static String rc4Encrypt(Object source, String rc4Password) {
        String encrypt = "";
        try {
            encrypt = Base64.encode(RC4.RC4encrypt(rc4Password.getBytes(DEFAULT_CHARSET),
                    String.valueOf(source).getBytes(DEFAULT_CHARSET)));
        } catch (UnsupportedEncodingException e) {
            logger.error("SecurityUtils.rc4Encrypt(" + source + ", " + rc4Password + ")", e);
        }
        return encrypt.replaceAll("/", "_").replaceAll("\\+", "-").replaceAll("=", "~");
    }

    /**
     * 解密
     * 加密字符串和原字符串长度基本相同
     * 主要针对页面ID的加密
     *
     * @return
     */
    public static String rc4Decrypt(String encryptStr) {
        return rc4Decrypt(encryptStr, RC4_DEFAULT_PASSWORD);
    }

    public static String rc4Decrypt(String encryptStr, String rc4Password) {
        String decrypt = "";
        try {
            encryptStr = encryptStr.replaceAll("_", "/").replaceAll("-", "+").replaceAll("\\~", "=");
            byte[] keyBytes = rc4Password.getBytes(DEFAULT_CHARSET);
            byte[] plainDataBytes = Base64.decode(encryptStr);
            if (plainDataBytes == null) {
                return decrypt;
            }

            byte[] bytes = RC4.RC4encrypt(keyBytes, plainDataBytes);
            decrypt = new String(bytes, DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            logger.error("SecurityUtils.rc4Decrypt(" + encryptStr + ", " + rc4Password + ")", e);
        }
        return decrypt;
    }

    /**
     * public static void main(String[] args) {
     * String plainText = "54";
     * String s = encryptRC4(plainText);
     * System.out.println("Bing Go: " + encryptRC4(plainText));
     * System.out.println("---Bing Go: " + decryptRC4(s));
     * }
     */

    public static String rc4EncryptUseBase24(String source, String rc4Password) {
        return Base24.encode(rc4Encrypt(source, rc4Password));
    }

    public static String rc4DecryptUseBase24(String encryptStr, String rc4Password) {
        String decodeStr = Base24.decode(encryptStr);
        if (StringUtils.isNotEmpty(decodeStr)) {
            return rc4Decrypt(decodeStr, rc4Password);
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "1234";
        String pass = "1234";
        String strAfterEncode = rc4EncryptUseBase24(str, pass);
        String strAfterDecode = rc4DecryptUseBase24(strAfterEncode, pass);
        System.out.println(strAfterDecode);

        System.out.println(rc4Decrypt("-VfE6srIcsUtHxHvkHxTwgrPoD0siYqOFzLJYjHTpv49E3dbDcFHnZqzxZc2PBUTfDEfRObGe5ysbV0NVH69QGwLwgQcMcPGHSufXUlry0HbH3FXwgtxPSDfXddorCaOQcIVARlhkmPFnxpI8A~~", "1008"));
        System.out.println(rc4Decrypt("nw~~", "24274"));
        System.out.println(MD5Encode("articleId=5066133clientId=1000167df59e39e9b46419op106fa2583a7b9", "UTF-8"));
    }

}
