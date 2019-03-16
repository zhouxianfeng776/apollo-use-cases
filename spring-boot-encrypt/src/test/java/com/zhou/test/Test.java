package com.zhou.test;

import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {
    public static void main(String[] args) {
        jdkBase64("周先锋--zhouxianfeng");
        jdkMD5("周先锋--zhouxianfeng");
        jdkMD2("周先锋--zhouxianfeng");
    }

    /**
     * Base64用于网络中传输的数据进行编码，严格意义上属于编码的格式，有64个字符的对应的编码，Base64
     * 就是将内容按照该格式进行编码。可以对数据编码和解码，是可逆的，安全度较低，不过，也可以作为最基础最简单的加密算法用于加密要求较弱的情况
     */
    public static void jdkBase64(String src) {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(src.getBytes());
            System.out.println("encode: " + encode);

            BASE64Decoder decoder = new BASE64Decoder();
            String decode = new String(decoder.decodeBuffer(encode));
            System.out.println("decode: " + decode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 摘要算法#
     * 摘要算法主要分为MD，SHA和Hmac算法，摘要算法其实是用于效验数据完整性的，我们在下载某些文件时，会有MD5和SHA1
     * 值提供我们效验下载的文件是否完整，可以用于根据数据生成其唯一的摘要值，无法根据摘要值知道原数据，属于不可逆的
     */
    public static void jdkMD5(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(src.getBytes());
            System.out.println("JDK MD5: " + Hex.encodeHexString(digest));           //使用的是cc中带的Hex需要转换为十六进制
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public static void jdkMD2(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] digest = md.digest(src.getBytes());
            System.out.println("JDK MD2: " + Hex.encodeHexString(digest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    /**
     * 对称加密算法#
     * 严格意义上的加密算法，分为对称和非对称加密算法，所谓对称是说发送方和接收方的密钥是一样的，而非对称我们后面再说。因为密钥一样所以安全性跟非对称比较来说就不太安全了
     *
     * 对称加密算法主要分为:DES , 3DES(3重DES) , AES(想要替代DES)  , PBE(基于口令的对称算法)
     */
    /**
     * 非对称的算法：#
     * 非对称算法就是发送方和接收方的密钥是不一样的，非对称相对于对称来说，有公钥和私钥的概念，基本上公钥是公开的，比如会在网络上传输，而私钥安全性要求就要高很多了，因为私钥是要保密的
     *
     * 基本的非对称算法有DH，RSA，ELGamal算法
     */

}
