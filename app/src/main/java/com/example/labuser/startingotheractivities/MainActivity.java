package com.example.labuser.startingotheractivities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void sendSMS(View view){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String input=((EditText)findViewById(R.id.userInput)).getText().toString();

        intent.putExtra(Intent.EXTRA_TEXT,input);
        PackageManager packageManager=getPackageManager();
        List activities=packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
        if(activities.size()>0){
            startActivity(intent);
        }

    }
    protected void makeCall(View view){
        String input=((EditText)findViewById(R.id.userInput)).getText().toString();
        Uri data=Uri.parse("tel:"+input);
        Intent intent=new Intent(Intent.ACTION_DIAL);

        PackageManager packageManager=getPackageManager();
        List activities=packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
        if(activities.size()>0){
            startActivity(intent);
        }
    }
    protected void mapIt(View view){
        String input=((EditText)findViewById(R.id.userInput)).getText().toString();
        int i;

        for(i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                //input.charAt(i)='+';
            }
        }
        Uri location=Uri.parse("geo:0,0?q="+input);
        Intent intent=new Intent(Intent.ACTION_VIEW,location);

        PackageManager packageManager=getPackageManager();
        List activities=packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
        if(activities.size()>0){
            startActivity(intent);
        }
    }

}
