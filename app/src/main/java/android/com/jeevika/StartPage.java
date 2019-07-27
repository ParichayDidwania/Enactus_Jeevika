package android.com.jeevika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {
    private Button mLoginBtn;
    private Button mSignUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        mLoginBtn = findViewById(R.id.start_login_btn);
        mSignUpBtn = findViewById(R.id.start_signUp_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLoginIntent();
            }
        });

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUpIntent();
            }
        });
    }

    private void startSignUpIntent() {
        Intent signup_intent = new Intent(StartPage.this,SignUpPage.class);
        startActivity(signup_intent);
    }

    private void startLoginIntent() {
        Intent login_intent = new Intent(StartPage.this,LoginPage.class);
        startActivity(login_intent);
    }
}
