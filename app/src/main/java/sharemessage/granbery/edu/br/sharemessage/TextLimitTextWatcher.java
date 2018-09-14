package sharemessage.granbery.edu.br.sharemessage;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class TextLimitTextWatcher implements TextWatcher {

    private final EditText text;
    private final TextView limitView;
    private final int limit;
    private final int defaultColor;

    public TextLimitTextWatcher(EditText text, TextView limitView, int limit) {
        this.text = text;
        this.limitView = limitView;
        this.limit = limit;
        this.defaultColor = limitView.getTextColors().getDefaultColor();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        count = limit - text.length();
        if (count >= 0) {
            limitView.setText(Integer.toString(count));
            limitView.setTextColor(Color.GREEN);
            if (count < 10) {
                limitView.setTextColor(Color.RED);
            } else if (count < 25) {
                limitView.setTextColor(Color.YELLOW);
            } else {
                limitView.setTextColor(defaultColor);
            }
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
