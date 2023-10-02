package com.darkness.sparkwomen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView menu;
    PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.logoutMenu);


        popup = new PopupMenu(MainActivity.this, menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(item -> {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    MainActivity.this.finish();
                    return true;
                });

                popup.show();
            }
        });

        findViewById(R.id.panicBtn).setOnClickListener(this);
        findViewById(R.id.fourth).setOnClickListener(this);
        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.fifth).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
       if(id == R.id.first){
            startActivity(new Intent(MainActivity.this, ContactActivity.class));
            MainActivity.this.finish();
        }
       /*else if(id == R.id.second)
       {
           startActivity(new Intent(MainActivity.this, LawsActivity.class));
           MainActivity.this.finish();
       }*/
       else{
           Toast.makeText(this, "Under Construction!", Toast.LENGTH_SHORT).show();
       }
    }
}