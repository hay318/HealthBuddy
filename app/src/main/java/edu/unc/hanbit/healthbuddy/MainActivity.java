package edu.unc.hanbit.healthbuddy;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PHONE_CALL = 0;
    String uri = "tel://911";
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v) {
        if (v.getId() == R.id.profile) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        if (v.getId() == R.id.alarm) {
            startActivity(new Intent(getApplicationContext(), AlarmActivity.class));
        }
        if (v.getId() == R.id.activity) {
            startActivity(new Intent(getApplicationContext(), ExerciseActivity.class));
        }

        //911
        if (v.getId() == R.id.emergency) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            }
            else { startActivity(intent);}
        }

    }

    //911 Permission
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch(requestCode) {
            case REQUEST_PHONE_CALL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intent);
                }
                return;
            }
        }
    }
}
