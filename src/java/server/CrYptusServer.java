/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Marco Mancuso
 */
@WebService(serviceName = "CrYptusServer")
public class CrYptusServer {

    /**
     * This is a sample web service operation
     */
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "SHA1")
    public String SHA1(@WebParam(name = "text") String text) {
        try {
            //TODO write your implementation code here:
            return sha1(text);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SHA256")
    public String SHA256(@WebParam(name = "text") String text) {
        try {
            //TODO write your implementation code here:
            return sha256(text);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "SHA384")
    public String SHA384(@WebParam(name = "text") String text) {
        try {
            //TODO write your implementation code here:
            return sha384(text);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "MD2")
    public String MD2(@WebParam(name = "text") String text) {
        try {
            //TODO write your implementation code here:
            return md2(text);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "MD5")
    public String MD5(@WebParam(name = "text") String text) {
        try {
            //TODO write your implementation code here:
            return md5(text);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CrYptusServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @WebMethod(operationName = "cryptus")
    public String cryptus(@WebParam(name = "text") String text) {
        //TODO write your implementation code here:
        String res = custom();
        return res;
    }
    
    @WebMethod(operationName = "CaesarCode")
    public String CesarC(@WebParam(name = "text") String text) {
        return CaesarCode(text);
    }
    
    private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    }
    
    public static String sha1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
    public static String sha256(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-256");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
    public static String sha384(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-384");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
    public static String md2(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
        MessageDigest md;
        md = MessageDigest.getInstance("MD2");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
    public static String md5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
    public static String CesarCodeAlt(String s) {
        StringBuffer sb = new StringBuffer("");
        CesarCodeAlt(s, 0, sb);
        return sb.toString();
    }
    
    
    private static void CesarCodeAlt(String s, int i, StringBuffer sb) {
        if(i==s.length()) {
            return;
        }
        else {
            char c = s.charAt(i);
            c+=1;
            sb.append(c);
            CesarCodeAlt(s, i+1, sb);
        }
    }
    
    private static String CaesarCode(String s) {
        StringBuffer res = new StringBuffer("");
        res.append(s.substring(4, s.length()-1));
        res.append(s.substring(0, 3));
        return res.toString();
        
    }
    
    private static String custom() {
        Charset latin1Charset = Charset.forName("ISO-8859-1"); 
        StringBuffer cb = new StringBuffer("");
        ByteBuffer bb = ByteBuffer.allocate(128);
        for(int i = 0; i<64; i++) {
            int t = (int)(Math.random() * Math.pow(10,3)); 
            t=(t%96)+32;
            cb.append((char) t);
                         
        }
        //System.out.println(cb.toString());
        bb = latin1Charset.encode(CharBuffer.wrap(cb));
        byte[] temp = new byte[64];
        temp = bb.array();
        byte[] key = new byte[64];
        new Random().nextBytes(key);
        for(int i = 0; i<64; i++) {
            temp[i] |= key[i];
        }
        bb = ByteBuffer.wrap(temp);
        CharBuffer sb = latin1Charset.decode(bb);
        String res = sb.toString();
        return res;
        
    }
        
}

    /**
     * Web service operation
     */
    

