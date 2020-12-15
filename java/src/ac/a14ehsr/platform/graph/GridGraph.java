package ac.a14ehsr.platform.graph;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class GridGraph extends Graph {
    private int n;
    private int m;
    private int[][] planeGain;

    /**
     * コンストラクタ
     * 
     * @param n // 縦のサイズ
     * @param m // 横のサイズ
     */
    public GridGraph(int n, int m) {
        super(n * m, m * (n - 1) + n * (m - 1));
        this.n = n;
        this.m = m;
        setWeight();
        setEdge();
    }

    /**
     * @return the planeGain
     */
    public int[][] getPlaneGain() {
        return planeGain;
    }

    /**
     * @return n // 縦のサイズ
     */
    public int getN() {
        return n;
    }

    /**
     * @return m // 横のサイズ
     */
    public int getM() {
        return m;
    }

    @Override
    public void printWeight() {
        System.out.println("n = " + n + "m = " + m);
        System.out.println("node weight");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%2d", nodeWeight[i * n + j]);
            }
            System.out.println();
        }
    }

    @Override
    public int[] evaluate(final int[] gain, int numberOfPlayers, int numberOfSelectNodes) {
        int[] value = new int[numberOfPlayers];

        int[][] gainNodeList = new int[numberOfPlayers][numberOfSelectNodes];
        int[] count = new int[numberOfPlayers];
        for (int i = 0; i < gain.length; i++) {
            if (gain[i] != -1) {
                gainNodeList[gain[i]][count[gain[i]]++] = i;
            }
            // gainNodeList[i / m][i % m] = gain[i];
        }

        int[][][] distance = new int[numberOfPlayers][n][m];
        for (int[][] planeDistance : distance) {
            for (int[] array : planeDistance) {
                Arrays.fill(array, n * m);
            }
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < numberOfSelectNodes; j++) {
                int node = gainNodeList[i][j];
                int x = node / m;
                int y = node % m;
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < m; b++) {
                        int tmp = Math.abs(x - a) + Math.abs(y - b);
                        if (tmp < distance[i][a][b]) {
                            distance[i][a][b] = tmp;
                        }

                    }
                }
            }
        }
        planeGain = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = distance[0][i][j];
                int gainPlayer = 0;
                for (int p = 1; p < numberOfPlayers; p++) {
                    if (distance[p][i][j] < min) {
                        min = distance[p][i][j];
                        gainPlayer = p;
                    } else if (distance[p][i][j] == min) {
                        gainPlayer = -1;
                    }
                }
                planeGain[i][j] = gainPlayer;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (planeGain[i][j] != -1) {
                    value[planeGain[i][j]] += nodeWeight[i * m + j];
                }

            }
        }
        return value;
    }

    /**
     * 重みの設定．一様乱数で1～10の値を決める. シード値は現在時刻. 
     */
    @Override
    void setWeight() {
        Random rnd = new Random();

        for (int i = 0; i < numberOfNodes; i++) {
            nodeWeight[i] = rnd.nextInt(10) + 1;
        }
    }

    /**
     * 辺の設定.
     */
    @Override
    void setEdge() {
        int edgeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                edges[edgeCount][0] = i * n + j;
                edges[edgeCount][1] = i * n + j + 1;
                edgeCount++;
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 1; i++) {
                edges[edgeCount][0] = i * n + j;
                edges[edgeCount][1] = (i + 1) * n + j;
                edgeCount++;
            }
        }
    }

    /**
     * n × mの情報を追加. 
     */
    @Override
    public String toString() {
        String str = n + "\n" + m + "\n";
        str += super.toString();
        return str;
    }

    public static void main(String[] args) {
        Graph obj = new GridGraph(10, 10);
        System.out.println(obj);
    }
}