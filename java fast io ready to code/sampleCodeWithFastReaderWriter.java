//package codeforces;

import java.util.*;
import java.io.*;
//import javafx.util.Pair;

class sampleCodeWithFastReaderWriter {

  static FastReader scan;
  //static PrintWriter pw;
  static OutputWriter pw;
  static int count = 0;
  static final int mod = 1000000007;

  public static void main(String[] args) {

    new Thread(null, null, "Thread 1", 1 << 27) {
      public void run() {
        try {
          setup();
          solve();
          closeResources();
        } catch (Exception e) {
          e.printStackTrace();
          System.exit(1);
        }
      }
    }.start();
  }

  private static void solve() throws IOException {
    int t = ni();

  }

  static String ns() throws IOException {
    return scan.readString();
  }


  static int ni() throws IOException {
    return scan.ni();
  }

  static long nl() throws IOException {
    return scan.nl();
  }

  static long[] nla(int n) throws IOException {
    long[] data = new long[n];
    for (int i = 0; i < n; i++) {
      data[i] = nl();
    }
    return data;
  }

  static int[] nia(int n) throws IOException {
    int[] data = new int[n];
    for (int i = 0; i < n; i++) {
      data[i] = ni();
    }
    return data;
  }

  static class FastReader {

    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;

    public FastReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (snumChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= snumChars) {
        curChar = 0;
        try {
          snumChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (snumChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }

    public int ni() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public long nl() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      long res = 0;
      do {
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public int[] nextIntArray(int n) {
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = ni();
      }
      return a;
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public String nextLine() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isEndOfLine(c));
      return res.toString();
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }

    public void close() throws IOException {
      if (stream == null) {
        return;
      }
      stream.close();
    }
  }

  static class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream, boolean autoFlush) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)), autoFlush);
    }

    public OutputWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
      for (int i = 0; i < objects.length; i++) {
        if (i != 0)
          writer.print(' ');
        writer.print(objects[i]);
      }
    }

    public void printLine(Object...objects) {
      print(objects);
      writer.println();
    }

    public void printLine() {
      writer.println();
    }

    public void close() {
      writer.close();
    }
  }

  private static void setup() {
    scan = new FastReader(System.in);
    pw= new OutputWriter(System.out, false); // set auto flush to true if you want to directly flush to the output stream.
  }

  private static void closeResources() throws IOException {
    //pw.flush();
    pw.close();
    scan.close();
  }

}
