package android.com.jeevika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpPage extends AppCompatActivity {
    private Button mSignUpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        mSignUpBtn = findViewById(R.id.signup_sign_btn);

        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHomeIntent();
            }
        });
    }

    private void startHomeIntent() {
        Intent home_intent = new Intent(SignUpPage.this,HomeActivity.class);
        startActivity(home_intent);
    }
}
