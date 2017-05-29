package android.kunitsa.com.androidcalculator.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.kunitsa.com.androidcalculator.R;
import android.kunitsa.com.androidcalculator.tools.Calculate;
import android.kunitsa.com.androidcalculator.tools.ExpressionUtils;
import android.kunitsa.com.androidcalculator.tools.HistoryItem;
import android.kunitsa.com.androidcalculator.tools.HistoryKeeper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button allClear, equals, divide, multiply, minus, plus, square, percent, exponent, left, right, polska;
    Button one, two, three, four, five, six, seven, eight, nine, zero, point;
    EditText display;
    TextView symbolDisplay;
    String line;

    private BigDecimal valueOne, valueTwo;
    private boolean bPlus, bMinus, bMultiply, bDivide, bPercent, bExponent;
    Calculate calc = new Calculate();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_polska);
        registerSimpleComponents();
        registerPolskaComponents();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main_polska);
            registerSimpleComponents();
            registerPolskaComponents();
        } else {
            setContentView(R.layout.activity_main_landscape);
            registerSimpleComponents();
            registerEngeneeringComponents();
        }
    }

    public void polska() {
        setContentView(R.layout.activity_main_polska);
        registerSimpleComponents();
        registerPolskaComponents();
    }

    public void registerSimpleComponents() {
        display = (EditText) findViewById(R.id.editText1);
        symbolDisplay = (TextView) findViewById(R.id.editText2);
        symbolDisplay.setOnClickListener(this);
        allClear = (Button) findViewById(R.id.btnClear);
        allClear.setOnClickListener(this);
        equals = (Button) findViewById(R.id.btnResult);
        equals.setOnClickListener(this);
        one = (Button) findViewById(R.id.btn1);
        one.setOnClickListener(this);
        two = (Button) findViewById(R.id.btn2);
        two.setOnClickListener(this);
        three = (Button) findViewById(R.id.btn3);
        three.setOnClickListener(this);
        four = (Button) findViewById(R.id.btn4);
        four.setOnClickListener(this);
        five = (Button) findViewById(R.id.btn5);
        five.setOnClickListener(this);
        six = (Button) findViewById(R.id.btn6);
        six.setOnClickListener(this);
        seven = (Button) findViewById(R.id.btn7);
        seven.setOnClickListener(this);
        eight = (Button) findViewById(R.id.btn8);
        eight.setOnClickListener(this);
        nine = (Button) findViewById(R.id.btn9);
        nine.setOnClickListener(this);
        zero = (Button) findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        point = (Button) findViewById(R.id.btnPoint);
        point.setOnClickListener(this);
        divide = (Button) findViewById(R.id.btnDevide);
        divide.setOnClickListener(this);
        multiply = (Button) findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);
        plus = (Button) findViewById(R.id.btnPlus);
        plus.setOnClickListener(this);
        minus = (Button) findViewById(R.id.btnMinus);
        minus.setOnClickListener(this);
    }

    void registerPolskaButton() {
        polska = (Button) findViewById(R.id.btnPolska);
        polska.setOnClickListener(this);
    }

    void registerEngeneeringComponents() {
        square = (Button) findViewById(R.id.btnSquare);
        square.setOnClickListener(this);
        percent = (Button) findViewById(R.id.btnPercent);
        percent.setOnClickListener(this);
        exponent = (Button) findViewById(R.id.btnExponent);
        exponent.setOnClickListener(this);
    }

    void registerPolskaComponents() {
        left = (Button) findViewById(R.id.btnLeft);
        left.setOnClickListener(this);
        right = (Button) findViewById(R.id.btnRight);
        right.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPolska:
                polska();
                break;
            case R.id.btnLeft:
                display.append("(");
                break;
            case R.id.btnRight:
                display.append(")");
                break;
            case R.id.btn1:
                display.append("1");
                break;
            case R.id.btn2:
                display.append("2");
                break;
            case R.id.btn3:
                display.append("3");
                break;
            case R.id.btn4:
                display.append("4");
                break;
            case R.id.btn5:
                display.append("5");
                break;
            case R.id.btn6:
                display.append("6");
                break;
            case R.id.btn7:
                display.append("7");
                break;
            case R.id.btn8:
                display.append("8");
                break;
            case R.id.btn9:
                display.append("9");
                break;
            case R.id.btn0:
                display.append("0");
                break;
            case R.id.btnPoint:
                display.append(".");
                break;
            case R.id.btnPlus:
                display.append("+");
                break;
            case R.id.btnMinus:
                display.append("-");
                break;
            case R.id.btnDevide:
                display.append("/");
                break;
            case R.id.btnMultiply:
                display.append("*");
                break;
            case R.id.btnSquare:

                break;
            case R.id.btnPercent:

                break;
            case R.id.btnExponent:
                if (TextUtils.isEmpty(display.getText())){
                    display.setText("");
                }else {
                    valueOne = new BigDecimal(display.getText().toString());
                    bExponent = true;
                    display.setText("");
                    symbolDisplay.setText("^");
                }
                break;
            case R.id.btnResult:
                line = display.getText().toString();
                String result;
                result = ExpressionUtils.calculateExpression(line).toPlainString();
                symbolDisplay.setText(result);
                HistoryKeeper.addItem(new HistoryItem(new Date(), line, result));
                display.setText("");
                break;
            case R.id.editText2:
                Intent intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.btnClear:
                display.setText("");
                symbolDisplay.setText("");
                break;
        }
    }
}
