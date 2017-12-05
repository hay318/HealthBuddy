package edu.unc.hanbit.healthbuddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class AlarmActivity  extends AppCompatActivity implements SensorEventListener {

    TextView alarmTextView;
    public float x,y,z;
    public SensorManager SM;
    public Sensor mySensor;
    int counter =0;
    double total = 0;
    double variance = 0;
    double mean = 0;
    double value = 0;

    public SensorManager sensor_manager;
    public Sensor sensor_light;
    public SensorEventListener listener_light;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        //sensor
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor = SM.getDefaultSensor(Sensor.TYPE_LIGHT);
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        sensor_manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_light =  sensor_manager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensor_manager.registerListener(listener_light, sensor_light, SensorManager.SENSOR_DELAY_NORMAL);
    }


    public void buttonOnClick(View v) {
        alarmTextView= (TextView) findViewById(R.id.alarmText);
        if (v.getId() == R.id.start_alarm) {
            alarmTextView.setText("alarm set");
        }
        if(v.getId()==R.id.stop_alarm){
            alarmTextView.setText("alarm cancelled");
        }
        if(v.getId()==R.id.test){
            MediaPlayer mMediaPlayer = MediaPlayer.create(this, R.raw.sound);
            mMediaPlayer.start();
        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //plotting
        x = sensorEvent.values[0];
        if(x + y + z> 50 ){
            MediaPlayer mMediaPlayer = MediaPlayer.create(this, R.raw.sound);
            mMediaPlayer.start();

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
