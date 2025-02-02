School of CSE
Program-10: Develop a simple application with one EditText so that the user can write some text
in it. Create a button called “Convert Text to Speech” that converts the user input text into voice
Xml code:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">
<TextView
android:id="@+id/textView"
android:layout_width="335dp"
android:layout_height="wrap_content"
android:layout_alignParentEnd="true"
android:layout_alignParentBottom="true"
android:layout_marginEnd="21dp"
android:layout_marginBottom="486dp"
android:text="Text2Speech"
android:textSize="30sp" />
<EditText
android:id="@+id/editText"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentEnd="true"
android:layout_alignParentBottom="true"
android:layout_marginEnd="142dp"
android:layout_marginBottom="377dp"
android:ems="10"
android:hint="Enter text here"
android:inputType="textPersonName" />
<Button
android:id="@+id/convert"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentEnd="true"
android:layout_alignParentBottom="true"
android:layout_marginEnd="196dp"
android:layout_marginBottom="236dp"
android:onClick="convert"
android:background="#6CEC71"
android:text="CONVERT" />
</RelativeLayout>
Java code:
package com.example.program7;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
EditText e1;
TextToSpeech t1;
School of CSE
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
e1=findViewById(R.id.editText);
t1=new TextToSpeech(getApplicationContext(), new
TextToSpeech.OnInitListener()
{
@Override
public void onInit(int status) {
if(status!=TextToSpeech.ERROR){
t1.setLanguage(Locale.UK);
}
}
});
}
public void convert(View V){
String tospeak=e1.getText().toString();
t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
}
