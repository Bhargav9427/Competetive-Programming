import java.util.*;
import java.io.*;

public class sampleCodeWithFastReaderWriter {
  static FastReader scan;
  static PrintWriter pw;

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

  private static void solve() throws IOException{
    int n = ni();
    pl(n);
    int x = ni();
    pl(x);
  }

  static int ni() throws IOException {
    return scan.nextInt();
  }

  static long nl() throws IOException {
    return scan.nextLong();
  }

  static double nd() throws IOException {
    return scan.nextDouble();
  }

  static void pl() {
    pw.println();
  }

  static void p(Object o) {
    pw.print(o + " ");
  }

  static void pl(Object o) {
    pw.println(o);
  }

  static void psb(StringBuilder sb) {
    pw.print(sb);
  }

  static void pa(String arrayName, Object arr[]) {
    pl(arrayName + " : ");
    for (Object o : arr) {
      p(o);
    }
    pl();
  }

  static void pa(String arrayName, int arr[]) {
    pl(arrayName + " : ");
    for (int o : arr) {
      p(o);
    }
    pl();
  }

  static void pa(String arrayName, long arr[]) {
    pl(arrayName + " : ");
    for (long o : arr) {
      p(o);
    }
    pl();
  }

  static void pa(String arrayName, double arr[]) {
    pl(arrayName + " : ");
    for (double o : arr) {
      p(o);
    }
    pl();
  }

  static void pa(String arrayName, char arr[]) {
    pl(arrayName + " : ");
    for (char o : arr) {
      p(o);
    }
    pl();
  }

  static void pa(String listName, List list) {
    pl(listName + " : ");
    for (Object o : list) {
      p(o);
    }
    pl();
  }

  static void pa(String arrayName, Object[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
      for (Object o : arr[i]) {
        p(o);
      }
      pl();
    }
  }

  static void pa(String arrayName, int[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
      for (int o : arr[i]) {
        p(o);
      }
      pl();
    }
  }

  static void pa(String arrayName, long[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
      for (long o : arr[i]) {
        p(o);
      }
      pl();
    }
  }

  static void pa(String arrayName, char[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
      for (char o : arr[i]) {
        p(o);
      }
      pl();
    }
  }

  static void pa(String arrayName, double[][] arr) {
    pl(arrayName + " : ");
    for (int i = 0; i < arr.length; ++i) {
      for (double o : arr[i]) {
        p(o);
      }
      pl();
    }
  }

  static class FastReader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
      byte[] buf = new byte[1000009];  //Line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n') {
          break;
        }
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) {
        c = read();
      }
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg) {
        return -ret;
      }
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) {
        c = read();
      }
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg) {
        return -ret;
      }
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) {
        c = read();
      }
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }
      if (neg) {
        return -ret;
      }
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) {
        buffer[0] = -1;
      }
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead) {
        fillBuffer();
      }
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null) {
        return;
      }
      din.close();
    }
  }

  private static void setup() {
    scan = new FastReader();
    pw = new PrintWriter(System.out, false); // set auto flush to true if you want to directly flush to the output stream.
  }

  private static void closeResources() throws IOException {
    pw.flush();
    pw.close();
    scan.close();
  }

}
