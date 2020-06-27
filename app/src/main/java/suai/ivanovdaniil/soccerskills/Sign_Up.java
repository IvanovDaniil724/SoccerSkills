package suai.ivanovdaniil.soccerskills;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_Up extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final EditText Login_EditText = findViewById(R.id.Login_PlainText);
        final EditText Email_EditText = findViewById(R.id.Email_PlainText);
        final EditText Password_EditText = findViewById(R.id.Password_PlainText);
        final EditText RepeatPassword_EditText = findViewById(R.id.RepeatPassword_PlainText);

        Button Create_Button = findViewById(R.id.Create_Button);

        final Validate_EditText validate_login = new Validate_EditText(Login_EditText, Sign_Up.this);
        final Validate_EditText validate_email = new Validate_EditText(Email_EditText, Sign_Up.this);
        final Validate_EditText validate_password = new Validate_EditText(Password_EditText, Sign_Up.this);
        final Validate_EditText validate_repeat_password = new Validate_EditText(RepeatPassword_EditText, Sign_Up.this);

        Create_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Login_EditText_text = Login_EditText.getText().toString(),
                       Email_EditText_text = Email_EditText.getText().toString(),
                       Password_EditText_text = Password_EditText.getText().toString(),
                       RepeatPassword_EditText_text = RepeatPassword_EditText.getText().toString();
                if (Login_EditText_text.equals("") || Password_EditText_text.equals("") || Email_EditText_text.equals(""))
                {
                    if (Login_EditText_text.equals(""))
                    {
                        validate_login.onEditTextInvalid("Поле логина не может оставаться пустым");
                    }

                    if (Password_EditText_text.equals(""))
                    {
                        validate_password.onEditTextInvalid("Поле пароля не может оставаться пустым");
                    }

                    if (Email_EditText_text.equals(""))
                    {
                        validate_email.onEditTextInvalid("Поле электронной почты не может оставаться пустым");
                    }
                }
                else
                {
                    if (!Email_EditText_text.matches("^[0-9a-z-\\.]+\\@[0-9a-z-]{2,}\\.[a-z]{2,}$"))
                    {
                        validate_email.onEditTextInvalid("Неверный ввод электронной почты");
                    }
                    else
                    {
                        if (!RepeatPassword_EditText_text.equals(Password_EditText_text))
                        {
                            validate_repeat_password.onEditTextInvalid("Пароли должны совпадать");
                        }
                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Sign_Up.this);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int id)
                                {
                                    Intent intent = new Intent(Sign_Up.this, Sign_In.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            builder.setMessage("Регистрация прошла успешно. " +
                                    "Пожалуйста, вернитесь на экран авторизации, чтобы войти в систему")
                                    .setTitle("Регистрация");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                    }
                }
            }
        });

        validate_login.onEditTextValid(); validate_email.onEditTextValid();
        validate_password.onEditTextValid(); validate_repeat_password.onEditTextValid();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            Intent intent = new Intent(Sign_Up.this, Sign_In.class);
            startActivity(intent); finish(); return true;
        }
        else { return super.onOptionsItemSelected(item); }
    }
}

