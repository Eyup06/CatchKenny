# CatchKenny
Android Studio da, Java ile oyun

1.build.gradle dosyasına aşşadaki implamenti ekleyin.

dependencies {
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.25'
}



2. olarak yine build.gradle dosyasına maven deposunu ekleyin

buildscript {
    repositories {
        mavenCentral()
    }
}
allprojects {
    repositories {
        mavenCentral()
    }
}



3.Sonra XML dosyasına xml kodlarını ekleyin.

<pl.droidsonroids.gif.GifImageView
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:src="@drawable/src_anim"
    android:background="@drawable/bg_anim"
    />
