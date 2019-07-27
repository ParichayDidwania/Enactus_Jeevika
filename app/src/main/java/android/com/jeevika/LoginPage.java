package android.com.jeevika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginPage extends AppCompatActivity {

    private Button mLoginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mLoginbtn = findViewById(R.id.login_page_btn);

        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHomeIntent();
            }
        });
    }

    private void startHomeIntent() {
        Intent start_intent = new Intent(LoginPage.this,HomeActivity.class);
        startActivity(start_intent);
    }
}
