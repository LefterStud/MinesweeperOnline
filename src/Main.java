
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;


public class Main {

    public static void startServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/back", new Server());
        server.start();
        System.out.println(System.lineSeparator() + "Server started at: localhost:8080");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        startServer();
        mineGen();
    }

    private static void mineGen() {
        int fieldWidth = 10;
        int fieldHeight = 10;
        int mineCount = 20;
        String[][] field = new String[fieldHeight][fieldWidth];
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                field[i][j] = "0";
            }
        }
        //Генерація мін
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                int tempX = (int) ((Math.random() * (fieldHeight)));
                int tempY = (int) ((Math.random() * (fieldWidth)));
                if ((mineCount > 0) && (field[tempX][tempY] != "*")) {
                    field[tempY][tempX] = "*";
                    mineCount--;
                }
            }
        }

        /*for (int i = 0; i < 10; i++) {
            field[0][i] = "*";
            field[i][0] = "*";
            field[9][i] = "*";
            field[i][9] = "*";
        }*/

        //Розрахунок чисел
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                if (field[i][j].equals("*")) {
                    //Цифри для мін посеред поля
                    if (i > 0 && i < fieldHeight - 1 && j > 0 && j < fieldWidth - 1) {
                        if (!field[i - 1][j - 1].equals("*")) {
                            field[i - 1][j - 1] = (Integer.parseInt(field[i - 1][j - 1]) + 1) + "";
                        }
                        if (!field[i][j - 1].equals("*")) {
                            field[i][j - 1] = (Integer.parseInt(field[i][j - 1]) + 1) + "";
                        }
                        if (!field[i + 1][j - 1].equals("*")) {
                            field[i + 1][j - 1] = (Integer.parseInt(field[i + 1][j - 1]) + 1) + "";
                        }
                        if (!field[i - 1][j].equals("*")) {
                            field[i - 1][j] = (Integer.parseInt(field[i - 1][j]) + 1) + "";
                        }
                        if (!field[i + 1][j].equals("*")) {
                            field[i + 1][j] = (Integer.parseInt(field[i + 1][j]) + 1) + "";
                        }
                        if (!field[i - 1][j + 1].equals("*")) {
                            field[i - 1][j + 1] = (Integer.parseInt(field[i - 1][j + 1]) + 1) + "";
                        }
                        if (!field[i][j + 1].equals("*")) {
                            field[i][j + 1] = (Integer.parseInt(field[i][j + 1]) + 1) + "";
                        }
                        if (!field[i + 1][j + 1].equals("*")) {
                            field[i + 1][j + 1] = (Integer.parseInt(field[i + 1][j + 1]) + 1) + "";
                        }

                    }

                    //Цифри для мін в 0,0
                    if (i == 0 && j == 0) {
                        if (!field[i + 1][j].equals("*")) {
                            field[i + 1][j] = (Integer.parseInt(field[i + 1][j]) + 1) + "";
                        }
                        if (!field[i][j + 1].equals("*")) {
                            field[i][j + 1] = (Integer.parseInt(field[i][j + 1]) + 1) + "";
                        }
                        if (!field[i + 1][j + 1].equals("*")) {
                            field[i + 1][j + 1] = (Integer.parseInt(field[i + 1][j + 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін в 0,m
                    if (i == 0 && j == fieldWidth - 1) {
                        if (!field[i + 1][j].equals("*")) {
                            field[i + 1][j] = (Integer.parseInt(field[i + 1][j]) + 1) + "";
                        }
                        if (!field[i][j - 1].equals("*")) {
                            field[i][j - 1] = (Integer.parseInt(field[i][j - 1]) + 1) + "";
                        }
                        if (!field[i + 1][j - 1].equals("*")) {
                            field[i + 1][j - 1] = (Integer.parseInt(field[i + 1][j - 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін в m,0
                    if (i == fieldHeight - 1 && j == 0) {
                        if (!field[i][j + 1].equals("*")) {
                            field[i][j + 1] = (Integer.parseInt(field[i][j + 1]) + 1) + "";
                        }
                        if (!field[i - 1][j].equals("*")) {
                            field[i - 1][j] = (Integer.parseInt(field[i - 1][j]) + 1) + "";
                        }
                        if (!field[i - 1][j + 1].equals("*")) {
                            field[i - 1][j + 1] = (Integer.parseInt(field[i - 1][j + 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін в m,m
                    if (i == fieldHeight - 1 && j == fieldWidth - 1) {
                        if (!field[i - 1][j].equals("*")) {
                            field[i - 1][j] = (Integer.parseInt(field[i - 1][j]) + 1) + "";
                        }
                        if (!field[i][j - 1].equals("*")) {
                            field[i][j - 1] = (Integer.parseInt(field[i][j - 1]) + 1) + "";
                        }
                        if (!field[i - 1][j - 1].equals("*")) {
                            field[i - 1][j - 1] = (Integer.parseInt(field[i - 1][j - 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін у верхньої грані
                    if (i == 0 && j != 0 && j != fieldWidth - 1) {
                        if (!field[i][j].equals("*")) {
                            field[i][j] = (Integer.parseInt(field[i][j]) + 1) + "";
                        }
                        if (!field[i][j + 1].equals("*")) {
                            field[i][j + 1] = (Integer.parseInt(field[i][j + 1]) + 1) + "";
                        }
                        if (!field[i][j - 1].equals("*")) {
                            field[i][j - 1] = (Integer.parseInt(field[i][j - 1]) + 1) + "";
                        }
                        if (!field[i + 1][j].equals("*")) {
                            field[i + 1][j] = (Integer.parseInt(field[i + 1][j]) + 1) + "";
                        }
                        if (!field[i + 1][j + 1].equals("*")) {
                            field[i + 1][j + 1] = (Integer.parseInt(field[i + 1][j + 1]) + 1) + "";
                        }
                        if (!field[i + 1][j - 1].equals("*")) {
                            field[i + 1][j - 1] = (Integer.parseInt(field[i + 1][j - 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін у нижньої грані
                    if (i == fieldHeight - 1 && j != 0 && j != fieldWidth - 1) {
                        if (!field[i][j].equals("*")) {
                            field[i][j] = (Integer.parseInt(field[i][j]) + 1) + "";
                        }
                        if (!field[i][j + 1].equals("*")) {
                            field[i][j + 1] = (Integer.parseInt(field[i][j + 1]) + 1) + "";
                        }
                        if (!field[i][j - 1].equals("*")) {
                            field[i][j - 1] = (Integer.parseInt(field[i][j - 1]) + 1) + "";
                        }
                        if (!field[i - 1][j].equals("*")) {
                            field[i - 1][j] = (Integer.parseInt(field[i - 1][j]) + 1) + "";
                        }
                        if (!field[i - 1][j + 1].equals("*")) {
                            field[i - 1][j + 1] = (Integer.parseInt(field[i - 1][j + 1]) + 1) + "";
                        }
                        if (!field[i - 1][j - 1].equals("*")) {
                            field[i - 1][j - 1] = (Integer.parseInt(field[i - 1][j - 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін у лівої грані
                    if (j == 0 && i != 0 && i != fieldHeight - 1) {
                        if (!field[i][j].equals("*")) {
                            field[i][j] = (Integer.parseInt(field[i][j]) + 1) + "";
                        }
                        if (!field[i + 1][j].equals("*")) {
                            field[i + 1][j] = (Integer.parseInt(field[i + 1][j]) + 1) + "";
                        }
                        if (!field[i - 1][j].equals("*")) {
                            field[i - 1][j] = (Integer.parseInt(field[i - 1][j]) + 1) + "";
                        }
                        if (!field[i][j + 1].equals("*")) {
                            field[i][j + 1] = (Integer.parseInt(field[i][j + 1]) + 1) + "";
                        }
                        if (!field[i + 1][j + 1].equals("*")) {
                            field[i + 1][j + 1] = (Integer.parseInt(field[i + 1][j + 1]) + 1) + "";
                        }
                        if (!field[i - 1][j + 1].equals("*")) {
                            field[i - 1][j + 1] = (Integer.parseInt(field[i - 1][j + 1]) + 1) + "";
                        }
                    }

                    //Цифри для мін у правої грані
                    if (j == fieldWidth - 1 && i != 0 && i != fieldHeight - 1) {
                        if (!field[i][j].equals("*")) {
                            field[i][j] = (Integer.parseInt(field[i][j]) + 1) + "";
                        }
                        if (!field[i + 1][j].equals("*")) {
                            field[i + 1][j] = (Integer.parseInt(field[i + 1][j]) + 1) + "";
                        }
                        if (!field[i - 1][j].equals("*")) {
                            field[i - 1][j] = (Integer.parseInt(field[i - 1][j]) + 1) + "";
                        }
                        if (!field[i][j - 1].equals("*")) {
                            field[i][j - 1] = (Integer.parseInt(field[i][j - 1]) + 1) + "";
                        }
                        if (!field[i + 1][j - 1].equals("*")) {
                            field[i + 1][j - 1] = (Integer.parseInt(field[i + 1][j - 1]) + 1) + "";
                        }
                        if (!field[i - 1][j - 1].equals("*")) {
                            field[i - 1][j - 1] = (Integer.parseInt(field[i - 1][j - 1]) + 1) + "";
                        }
                    }
                }
            }
        }

        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldHeight; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }
}