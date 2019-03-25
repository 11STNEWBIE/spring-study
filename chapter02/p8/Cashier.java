package com.example.ch2.p8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class Cashier {

    private String fileName;
    private String path;
    private BufferedWriter writer;

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void openFile() throws IOException {

        File targetDir = new File(path);
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }

        File checkoutFile = new File(path, fileName +".txt");
        if (!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }
    }
}
