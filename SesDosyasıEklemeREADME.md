# CatchKenny
Android Studio da, Java ile oyun
res klasörünün içine yeni bir klasör oluşturuyoruz. raw klasörü adında. Ses dosyasını buraya yüklüyoruz. Sonra MainActivity de şunu yazıyoruz.



public void increaseScore(View view){
       
       MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mysound_player);
        mediaPlayer.start();

}
