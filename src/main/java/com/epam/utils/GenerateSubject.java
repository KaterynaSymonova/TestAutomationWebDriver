package com.epam.utils;

/**
 * Created by Kateryna_Symonova on 10/23/2015.
 */
public class GenerateSubject {

// метод генерирует уникальную тему сообщения
    public static String getUniqueSubject (int lengthSubject ) {

        StringBuffer stringBuffer = new StringBuffer(lengthSubject);
        String validChars = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int forRandom = validChars.length()-1;
        for (int i = 0; i < lengthSubject; i++)
        {   int index =(int) (Math.random()*forRandom);
            stringBuffer.append(validChars.charAt(index));
        }
        return stringBuffer.toString();
    }
}
