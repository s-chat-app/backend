package indi.midreamsheep.schatapp.backend.util.protocol;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
 
public class ECCUtils {
 
    /**
     * 生成密钥对(公钥和私钥)
     *
     */
    public static KeyPair initKey(int keySize, String KEY_ALGORITHM) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(keySize);
        return keyPairGen.generateKeyPair();
    }
 
    /**
     * 公钥加密
     *
     * @param data      源数据
     * @param publicKey 公钥
     */
    public static String encryptByPublicKey(String data, String publicKey)
            throws Exception {
        byte[] decode = Base64.getDecoder().decode(publicKey);
        Security.addProvider(new BouncyCastleProvider());
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        Cipher cipher = Cipher.getInstance("ECIES", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, keyFactory.generatePublic(x509KeySpec));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
 
    }
 
    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥
     */
    public static String decryptByPrivateKey(String encryptedData, String privateKey)
            throws Exception {
        byte[] decode = Base64.getDecoder().decode(encryptedData);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("ECIES", "BC");
        cipher.init(Cipher.DECRYPT_MODE, keyFactory.generatePrivate(pkcs8KeySpec));
        return Base64.getEncoder().encodeToString(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
 
    /**
     * 用私钥对信息生成数字签名
     *
     * @param content     已加密数据 base64
     * @param priKey      私钥(BASE64编码)
     * @param signatureAl 签名算法
     */
    public static String sign(String content, String priKey, String signatureAl) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(priKey));
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECPrivateKey privateK = (ECPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        Signature sign = Signature.getInstance(signatureAl);//"SHA256withECDSA/"
        sign.initSign(privateK);
        sign.update(Base64.getDecoder().decode(content));
        return Base64.getEncoder().encodeToString(sign.sign());
    }
 
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                //初始化获取公钥和私钥
                KeyPair keypair = initKey(256, "EC");

                PublicKey publicKey = keypair.getPublic();
                PrivateKey privateKey = keypair.getPrivate();

                String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());
                String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());
                String con = "这是一条测试加密的数据，哈哈哈哈";
                System.out.println("加密之前：" + con);
                //加密
                String content = encryptByPublicKey(con, publicKeyBase64);
                //解密
                String contentDe = decryptByPrivateKey(content, privateKeyBase64);
                //解密之后
                String deStr = new String(Base64.getDecoder().decode(contentDe));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}