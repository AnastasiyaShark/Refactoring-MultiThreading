package RefactoringAndMultiThreading;

import java.io.*;

public class Main {
    final static int portNumber = 9999;
    public static void main(String[] args) throws IOException {
        new Server(portNumber).connectServer();
    }
}

