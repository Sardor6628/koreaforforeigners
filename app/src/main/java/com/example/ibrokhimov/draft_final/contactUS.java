package com.example.ibrokhimov.draft_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contactUS extends AppCompatActivity {
    Button send;
    EditText subject, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        subject=(EditText)findViewById(R.id.topic);
        content=(EditText)findViewById(R.id.message);
        Button sendMessage=(Button)findViewById(R.id.sendMessage);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to=" koreaforforeigners@gmail.com";
                String sub=subject.getText().toString();
                String con=content.getText().toString();
                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT,sub);
                email.putExtra(Intent.EXTRA_TEXT,con);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose app to send mail"));



            }
        });
    }
}
