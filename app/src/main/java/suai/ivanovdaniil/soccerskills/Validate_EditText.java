package suai.ivanovdaniil.soccerskills;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;

public class Validate_EditText
{
    private EditText edit_text; private Context context;

    public Validate_EditText(EditText edit_text, Context context) { this.edit_text = edit_text; this.context = context; }

    public void onEditTextValid()
    {
        edit_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                edit_text.setHintTextColor(Color.parseColor("#66000000"));
            }
        });
    }

    public void onEditTextInvalid(String error_message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                edit_text.setHintTextColor(Color.parseColor("#55FF0000"));
            }
        });
        builder.setMessage(error_message).setTitle("Ошибка");
        AlertDialog dialog = builder.create(); dialog.show();
    }
}
