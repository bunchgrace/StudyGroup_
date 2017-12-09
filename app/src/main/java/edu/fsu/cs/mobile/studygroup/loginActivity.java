package edu.fsu.cs.mobile.studygroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by gracebunch on 11/2/17.
 */

public class loginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private FirebaseAuth auth;
    private String email1;
    private String pass;
    private Intent intent;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        auth= FirebaseAuth.getInstance();
        email= (EditText) findViewById(R.id.emailLog);
        password = (EditText) findViewById(R.id.password);


    }


    //clicking login opens mainActivity
    public void loginToMain(View view){



        email1=email.getText().toString().trim();
        pass= password.getText().toString().trim();

        auth.signInWithEmailAndPassword(email1, pass)
                .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //Log.d("TAG", "createUserWithEmail:onComplete:" + task.isSuccessful());

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(loginActivity.this, "Wrong Username or Password. Try Again!",
                                            Toast.LENGTH_LONG).show();
                                } else {


                                    intent = new Intent(loginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });

    }

                    public void registerPage(View view) {

                        intent = new Intent(loginActivity.this, registerActivity.class);
                        startActivity(intent);
                    }
}