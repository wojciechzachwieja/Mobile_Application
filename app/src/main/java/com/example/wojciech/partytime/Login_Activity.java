package com.example.wojciech.partytime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login_Activity extends AppCompatActivity {

    public static final int REQUEST_CODE = 111;
    private EditText emailView;
    private EditText passView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        emailView = (EditText)findViewById(R.id.email);
        passView = (EditText)findViewById(R.id.pass);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            changeActivityToMain();
        }
    }

    private void changeActivityToMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void createAccount(View view) {
        Intent intent = new Intent(this,Sign_up_Activity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void loginClick(View view) {
        String email = emailView.getText().toString();
        String password = passView.getText().toString();
        boolean flagCorrectData = true;


        if(TextUtils.isEmpty(email)){
            emailView.setError("Please enter email.");
            flagCorrectData = false;
        }
        if(TextUtils.isEmpty(password)){
            passView.setError("Please enter password.");
            flagCorrectData = false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailView.setError("Email is incorrect.");
            flagCorrectData = false;
        }

        if(flagCorrectData) {
            logIn(email, password);
        }
    }

    private void logIn(String email, String password) {
        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {
                    changeActivityToMain();
                } else {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }
}
