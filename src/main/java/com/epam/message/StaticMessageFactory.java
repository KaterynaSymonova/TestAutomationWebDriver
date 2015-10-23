package com.epam.message;

import java.util.Random;

/**
 * Created by Kateryna_Symonova on 10/7/2015.
 */
public class StaticMessageFactory {

    public static Message getEmptyMessage(String to) {
        Message message = new Message();
        message.setTo(to);
        message.setSubject(randomSubject());
        return message;
    }

    public static Message getMessageWithoutCopy(String to, String subject, String text) {
        Message message = new Message();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        return message;
    }

    public static Message getMessageWithCopy(String to, String subject, String text, String copy) {
        Message message = new Message();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setCopy(copy);
        return message;
    }

    public static String randomSubject() {
        int length = 6;
        StringBuffer stringBuffer = new StringBuffer(length);
        String validChars = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int forRandom = validChars.length()-1;
        for (int i = 0; i < length; i++)
        {   int index =(int) (Math.random()*forRandom);
          stringBuffer.append(validChars.charAt(index));
        }
        return stringBuffer.toString();

    }

    public static Message getDefaultMessage(String toEmail) {
        Message message = new Message();
        message.setTo(toEmail);
        message.setSubject(randomSubject());
        message.setText("Hi! It is test message");
        return message;
    }


}