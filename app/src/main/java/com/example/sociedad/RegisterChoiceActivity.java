package com.example.sociedad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterChoiceActivity extends AppCompatActivity {

    private Button admin, member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_choice);

        //storing button reference in variables
        admin = (Button) findViewById(R.id.admin_button);
        member = (Button) findViewById(R.id.member_button);

        //admin onclick method

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterChoiceActivity.this, RegisterAdminActivity.class);
                startActivity(intent);
            }
        });

        member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterChoiceActivity.this, RegisterMemberSocietyActivity.class);
                startActivity(intent);
            }
        });
    }
}
