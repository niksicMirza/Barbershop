package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ContactUs extends AppCompatActivity{
    private EditText sendTo;
    private EditText subject;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        sendTo = findViewById(R.id.edit_text_to);
        subject = findViewById(R.id.edit_text_subject);
        message = findViewById(R.id.edit_text_message);

        sendTo.setText("hohbarbershop@gmail.com");
        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    private void sendMail() {
        if(sendTo.getText().toString().equals("") || subject.getText().toString().equals("") || message.getText().toString().equals("") ) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        } else {
            String recipientList = sendTo.getText().toString();
        String[] recipients = recipientList.split(",");
        String subjectE = subject.getText().toString();
        String messageE = message.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subjectE);
        intent.putExtra(Intent.EXTRA_TEXT, messageE);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
