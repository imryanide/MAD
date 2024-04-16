School of CSE
Program-7: Develop an application to set an image as wallpaper. On click of a button, the
wallpaper image should start to change randomly every 30 seconds.
XML file:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">
<Button
android:id="@+id/button1"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentEnd="true"
android:layout_alignParentRight="true"
android:layout_alignParentBottom="true"
android:layout_marginEnd="167dp"
android:layout_marginRight="167dp"
android:layout_marginBottom="409dp"
android:text="CLICK HERE" />
</RelativeLayout>
Java file:
package com.example.program4;
import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
Button wallpaperChange;
Timer mytimer;
Drawable drawable;
WallpaperManager wpm;
int prev=1;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
mytimer=new Timer();
wpm = WallpaperManager.getInstance(this);
wallpaperChange=(Button)findViewById(R.id.button1);
wallpaperChange.setOnClickListener(new View.OnClickListener() {
School of CSE
@Override public void onClick(View view) {
setwallpaper();
}
});
}
private void setwallpaper() {
Toast.makeText(this,"setting Wallpaper please
wait.",Toast.LENGTH_LONG).show();
mytimer.schedule(new TimerTask() {
@Override
public void run()
{
if(prev==1) {
drawable = getResources().getDrawable(R.drawable.i1);
prev = 2;
}
else if(prev==2) {
drawable = getResources().getDrawable(R.drawable.i2);
prev=3;
}
else if(prev==3) {
drawable = getResources().getDrawable(R.drawable.i3);
prev=4;
}
else if(prev==4) {
drawable = getResources().getDrawable(R.drawable.i4);
prev=5;
}
else if(prev==5) {
drawable = getResources().getDrawable(R.drawable.i5);
prev=1;
}
Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
try {
wpm.setBitmap(wallpaper);
}
catch (IOException e)
{ e.printStackTrace();
}
}
},0,30000);
}
}