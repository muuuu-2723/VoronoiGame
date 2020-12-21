# VoronoiGame
以下のボロノイゲームのシステムを変更しました.  
https://github.com/a14ehsr/VoronoiGame/  
ゲームの詳細とシステムの説明はURL先を参照してください.  
<br>
<br>
**2020/12/22更新**<br>
システムファイルをすべてアップロードしました.<br>
これによってcloneもしくはすべてダウンロードすることでシステムを動かすことができます.<br>
ただし変更方法の方法1に示しているファイル以外は元のシステムと変更はありません.<br>
ですのでシステムがすでに動いている方は更新する必要はありません.<br>
## 変更点
#### 1. N×Mの格子グラフに対応  
10×10と11×11の格子グラフを交互にプレイします.  
#### 2. 1に伴いサンプルプログラムの変更  
受け取るグラフ情報に以下のデータを追加.  
    
| 変数名 | 内容 |  
| ---- | ---- |  
| n | 格子グラフの縦サイズ |  
| m | 格子グラフの横サイズ |  
  
サンプルプログラムの関数`loadGraph`で変数`numberOfNodes`の直前で2行にわたって読み込んでいます.<br>
#### 3. グラフの重みの分布を変更
1～10の一様乱数で重みを定義.　　
<br>
## 変更方法
### 方法1
以下のファイルをダウンロードして更新してください.  

- /java/src/ac/a14ehsr/platform/VoronoiGame.java
- /java/src/ac/a14ehsr/platform/graph/GridGraph.java
- /java/src/ac/a14ehsr/sample_ai/P_4Neighbours.java
- /java/src/ac/a14ehsr/sample_ai/P_8Neighbours.java
- /java/src/ac/a14ehsr/sample_ai/P_Chaise.java
- /java/src/ac/a14ehsr/sample_ai/P_Copy.java
- /java/src/ac/a14ehsr/sample_ai/P_Max.java
- /java/src/ac/a14ehsr/sample_ai/P_Random.java
- /sample_programs/cpp/P_sample.cpp
- /sample_programs/java/P_Sample.java
- /sample_programs/python/P_sample.py  

その後, 上記URLの1.4以降を再度実行してください.  
### 方法2
システムを再構築<br>
以下のコマンドを実行<br>
```
git clone https://github.com/muuuu-2723/VoronoiGame.git
```
もしくはdownroad zipからダウンロードして適当なディレクトリで解凍してください.<br>
その後は上記URLの1.3以降に従ってください. 
