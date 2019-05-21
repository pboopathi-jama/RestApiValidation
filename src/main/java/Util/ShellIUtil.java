package Util;

import java.io.IOException;

public class ShellIUtil {

    public static void runCommandWithTwoParam(String executableFilePath, String param1, String param2)
    {
        String[] cmd = {executableFilePath, param1, param2};
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
