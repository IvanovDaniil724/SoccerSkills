package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_In extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        getSupportActionBar().hide();

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {

            @Override
            public void onSystemUiVisibilityChange(int visibility)
            {
                if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                {
                    decorView.setSystemUiVisibility(flags);
                }
            }
        });

        TextView SignUpNow_Text = findViewById(R.id.SignUpNow_Text);
        SignUpNow_Text.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Sign_In.this, Sign_Up.class);
                startActivity(intent); finish();
            }
        });

        final EditText Login_EditText = findViewById(R.id.Login_PlainText);
        final EditText Password_EditText = findViewById(R.id.Password_PlainText);
        Button SignIn_Button = findViewById(R.id.Create_Button);

        final Validate_EditText validate_login = new Validate_EditText(Login_EditText, Sign_In.this);
        final Validate_EditText validate_password = new Validate_EditText(Password_EditText, Sign_In.this);

        SignIn_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Login_EditText_text = Login_EditText.getText().toString(),
                       Password_EditText_text = Password_EditText.getText().toString();
                if (Login_EditText_text.equals("") || Password_EditText_text.equals(""))
                {
                    if (Login_EditText_text.equals(""))
                    {
                        validate_login.onEditTextInvalid("Поле логина не может оставаться пустым");
                    }

                    if (Password_EditText_text.equals(""))
                    {
                        validate_password.onEditTextInvalid("Поле пароля не может оставаться пустым");
                    }
                }
                else
                {
                    //Intent intent = new Intent(Sign_In.this, Sign_Up.class);
                    //startActivity(intent); finish();
                }
            }
        });

        validate_login.onEditTextValid(); validate_password.onEditTextValid();
    }
}
