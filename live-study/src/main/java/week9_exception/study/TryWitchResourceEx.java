package week9_exception.study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TryWitchResourceEx {

    public static final int BUFFER_SIZE = 512;

    public static void main(String[] args) {

    }

    static void copy1(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try{
            OutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    static void copy2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);

        }
    }
}