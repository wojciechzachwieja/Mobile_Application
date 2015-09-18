package com.example.wojciech.partytime;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



/**
 * A placeholder fragment containing a simple view.
 */
public class Sign_up_Fragment extends Fragment implements  View.OnClickListener {
    private Button signUp;
    private EditText email;
    private EditText password;
    private EditText login;
    public Sign_up_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up,container,false);
        signUp = (Button) view.findViewById(R.id.button);
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        login = (EditText) view.findViewById(R.id.login);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                signUpClick();
                break;
        }
    }

    private void signUpClick() {
        String email = this.email.getText().toString();
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();
        boolean flagCorrectData = true;


        if(TextUtils.isEmpty(email)){
            this.email.setError("Please enter email.");
            flagCorrectData = false;
        }
        if(TextUtils.isEmpty(login)){
            this.login.setError("Please enter login.");
            flagCorrectData = false;
        }
        if(TextUtils.isEmpty(password)){
            this.password.setError("Please enter password.");
            flagCorrectData = false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Email is incorrect.");
            flagCorrectData = false;
        }

        if(flagCorrectData) {
            signUp(email,password);
        }
    }
    private void signUp(String email,String password){
        ParseUser user = new ParseUser();
        user.setUsername(email);
        user.setPassword(password);
        user.setEmail(email);


        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    if(getActivity() != null){
                        getActivity().setResult(Activity.RESULT_OK);
                        getActivity().finish();
                    }
                } else {
                    Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }
}
