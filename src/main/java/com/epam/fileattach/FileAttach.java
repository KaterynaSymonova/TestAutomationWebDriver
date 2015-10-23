package com.epam.fileattach;

import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by Kateryna_Symonova on 10/14/2015.
 */
public class FileAttach {

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

    public static void uploadFile(String path) throws InterruptedException, AWTException {
        File file = new File(path);
        setClipboardData(file.getAbsolutePath());
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(100);
    }
}

