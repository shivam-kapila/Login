package com.shivamkapila.myfirstfirebaseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    private TextView editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText = findViewById(R.id.personName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String person1 = "Logged in as" + getIntent().getStringExtra("person");

//        Log.d("seeeeee", editText.getText().toString().trim());

        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });
    }
}
