package com.mycompany.caesarcipherdecryption;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;

public class CaesarCipherDecryption {
    
    public final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the text you want decrypted: ");
        String cipherText = sc.nextLine();
        
        System.out.println("Enter the skip key: ");
        int skipKey = sc.nextInt();
        
        System.out.println("The return text is: " + decryptString_Solution1(cipherText, skipKey));
        System.out.println("The return text is: " + decryptString_Solution2(cipherText, skipKey));
    }
    
    
    public static String decryptString_Solution1(String cipherText, int skipKey) {
        if(cipherText.isEmpty() || skipKey < 1) {
            return cipherText;
        }
        
        String plainText = "";
        String cipherToLower = cipherText.toLowerCase().trim();
        
        for(int i = 0; i < cipherToLower.length(); i++) {
            
            int charPos = ALPHABET.indexOf(cipherToLower.charAt(i));
            int keyValue = getKeyValue(charPos, skipKey);
            
            if(keyValue < 0) {
                keyValue = ALPHABET.length() + keyValue;
            }
            
            if(String.valueOf(cipherToLower.charAt(i)).equals(" ")) {
                plainText += cipherToLower.charAt(i);
            }
            else {
                char replaceValue = ALPHABET.charAt(keyValue);
                plainText += replaceValue;
            }
        }
        
        return plainText;
    }
    
    public static String decryptString_Solution2(String cipherText, int skipKey) {
        if(cipherText.isEmpty() || skipKey == 0) {
            return cipherText;
        }
        
        List<String> cipherCharList = Arrays.asList(cipherText.toLowerCase().trim().split(""));
        List<String> plainTextList = cipherCharList.stream().map(c -> getChar(c, skipKey)).collect(Collectors.toList());
        return String.join("", plainTextList);
    }
    
    private static String getChar(String cipherChar, int key) {
        if(String.valueOf(cipherChar).equals(" ")){
            return String.valueOf(cipherChar);
        }
        
        int charPos = ALPHABET.indexOf(cipherChar);
        int keyValue = getKeyValue(charPos, key);
            
        if(keyValue < 0) {
            keyValue = ALPHABET.length() + keyValue;
        }
            
        return String.valueOf(ALPHABET.charAt(keyValue));
    }
    
    private static int getKeyValue(int charPosition, int skipKey) {
        return (charPosition - skipKey) % 26;
    }
}
