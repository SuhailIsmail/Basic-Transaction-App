package com.example.myapplication.Login;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Activity_Login extends AppCompatActivity {


    EditText username, password;
    Button btnlogin, regis;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.loginbtn);
        regis = (Button) findViewById(R.id.regis);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Activity_Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);

                    if (checkuserpass == true) {

                        makenot();
                        Toast.makeText(Activity_Login.this, "Login in successfull", Toast.LENGTH_SHORT).show();

                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }

                    else{
                        Toast.makeText(Activity_Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_Register.class);
                startActivity(intent);
            }
        });
    }

    //Notification
    public void makenot() {

        String channelid = "Notification";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(), channelid)
                        .setSmallIcon(R.drawable.ic_n)
                        .setContentTitle("LOGIN")
                        .setContentText("Login Successfull")
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                    notificationManager.getNotificationChannel(channelid);

            if (notificationChannel == null){
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel.setLightColor(android.R.color.holo_green_dark);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        notificationManager.notify(0,builder.build());
    }
    @Override
    public void onBackPressed() {

    }

}
