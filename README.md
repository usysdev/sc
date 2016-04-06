========================================================================
常駐型スクリーンキャプチャ
========================================================================

1. インストール
---------------

(1) JDKまたはJREをインストールする。
    (1.8 系でビルド、テストしている。)

(2) 環境変数 JAVA_HOME を定義する。

(3) 以下の3ファイルをインストール先フォルダにコピーする。
      sc.bat
      sc.vbs
      sc.jar


2. 起動
-------

sc.vbs をたたく。
作業ディレクトリはインストール先フォルダを同じにしておかなければ
sc.bat、sc.jar が見つからなくて起動しないと思う。
タスクトレイに常駐したら成功。


3. キャプチャ画像の出力先
-------------------------

作業ディレクトリ(インストール先フォルダ)の下に、「yyyy-mm-dd」ディレクトリ
を作成し、「hh時mm分.jpg」でキャプチャ画像を書き出す。

出力タイミングは以下のとおり。
・起動時に書き出す。
・それ以降は、00、10、20、30、40、50分の区切りに書き出す。

メニュー「撮影」をクリックしても書き出す。

キャプチャ画像の出力先は、メニュー「設定」で変更できる。


4. 終了
-------

メニュー「終了」をクリックすると終了する。


5. 残念な点
-----------

・マルチモニタには未対応。主モニタのみがキャプチャされる。

・リモートデスクトップの場合どう撮れるかは未検証。

・起動スクリプトを用意しているのはWindowsのみ。
  本体はJavaなので起動スクリプトさえ用意すれば
  他のOSでも動くと思うが未検証。
