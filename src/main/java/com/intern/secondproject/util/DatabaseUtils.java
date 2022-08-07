package com.intern.secondproject.util;

import java.io.IOException;

public class DatabaseUtils {

        public static boolean backup(String dbUsername, String dbPassword, String dbName,String tableName, String outputFile)
                throws IOException, InterruptedException {
            String command="";
            if (tableName!=null){
                command = String.format("mysqldump -u%s -p%s --add-drop-table %s %s -r %s",
                        dbUsername, dbPassword, dbName,tableName, outputFile);
            }else{
                command = String.format("mysqldump -u%s -p%s --add-drop-table %s -r %s",
                        dbUsername, dbPassword, dbName, outputFile);
            }
            Process process = Runtime.getRuntime().exec(command);
            int processComplete = process.waitFor();
            return processComplete == 0;
        }

    public static boolean restore(String dbUsername, String dbPassword, String dbName, String sourceFile)
            throws IOException, InterruptedException {
        String[] command = new String[]{
                "mysql",
                "-u" + dbUsername,
                "-p" + dbPassword,
                "-e",
                " source " + sourceFile,
                dbName
        };
        Process runtimeProcess = Runtime.getRuntime().exec(command);
        int processComplete = runtimeProcess.waitFor();
        return processComplete == 0;
    }

}
