/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author ronal
 */
public class Extractor {
    private static String GMAIL = "d=gmail";
    private static String HOTMAIL = "d=hotmail";
    private static String YAHOO = "d=yahoo";
    private static String OUTLOOK= "d=outlook";
    
    
    public static Email getEmail(String plain_text){
        return new Email(getFrom(plain_text),getSubject(plain_text));
    }
    
    private static String getFrom(String plain_text){
        String search = "Return-Path: <";
        int index_begin = plain_text.indexOf(search) + search.length();
        int index_end = plain_text.indexOf(">");
        return plain_text.substring(index_begin, index_end);
    }
    
    private static String getTo(String plain_text){
        String to = "";
        if(plain_text.contains(GMAIL)){
            to = getToFromGmail(plain_text);
        } else if(plain_text.contains(HOTMAIL)){
            to = getToFromHotmail(plain_text);
        } else if(plain_text.contains(YAHOO)){
            to = getToFromYahoo(plain_text);
        }
        return to;
    }
    
    private static String getSubject(String plain_text){
        String search = "Subject: ";
        int i = plain_text.indexOf(search) + search.length();
        String end_string = "";
        if(plain_text.contains(GMAIL)){
            end_string = "To:";
        } else if(plain_text.contains(HOTMAIL)){
            end_string = "Thread-Topic";
        } else if(plain_text.contains(YAHOO)){
            end_string = "MIME-Version:";
        }
        int e = plain_text.indexOf(end_string, i);
        return plain_text.substring(i, e);
    }
    
    private static String getToFromGmail(String plain_text){
        return getToCommon(plain_text);
    }
    
    private static String getToFromHotmail(String plain_text){
        String aux = getToCommon(plain_text);
        return aux.substring(1, aux.length() - 1);
    }
    
    private static String getToFromYahoo(String plain_text){
        int index = plain_text.indexOf("To: ");
        int i = plain_text.indexOf("<", index);
        int e = plain_text.indexOf(">", i);
        return plain_text.substring(i + 1, e);
    }
    
    private static String getToCommon(String plain_text){
        String aux = "To: ";
        int index_begin = plain_text.indexOf(aux) + aux.length();
        int index_end = plain_text.indexOf("\n", index_begin);
        return plain_text.substring(index_begin, index_end);
    }
}
