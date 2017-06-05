package android.kunitsa.com.androidcalculator.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.kunitsa.com.androidcalculator.DBHelper;
import android.kunitsa.com.androidcalculator.OnFragmentInteractionListener;
import android.kunitsa.com.androidcalculator.fragments.FragmentBin;
import android.kunitsa.com.androidcalculator.fragments.FragmentDec;
import android.kunitsa.com.androidcalculator.R;
import android.kunitsa.com.androidcalculator.fragments.FragmentOct;
import android.kunitsa.com.androidcalculator.tools.ExpressionUtils;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends FragmentActivity implements View.OnClickListener, OnFragmentInteractionListener {

    Button allClear, equals, divide, multiply, minus, plus, square, percent, exponent, left, right, backspace;
    Button one, two, three, four, five, six, seven, eight, nine, zero, point;
    TextView display;
    TextView symbolDisplay;
    FragmentDec fragDec;
    FragmentBin fragBin;
    FragmentOct fragOct;
    RadioButton rOne, rTwo, rThree, rFour;
    android.app.FragmentTransaction fTrans;

    SQLiteOpenHelper dbHelper;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_polska);
        registerSimpleComponents();
        registerPolskaComponents();
        dbHelper = new DBHelper(this);
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
            registerEngeneeringComponents();
            rThree.setChecked(true);
            decInit();
            //rThree.setChecked(true);
            /*registerSimpleComponents();
            registerPolskaComponents();*/
        }
    }

    public void registerSimpleComponents() {
        display = (TextView) findViewById(R.id.editText1);
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
        backspace = (Button) findViewById(R.id.btnBackSpace);
        backspace.setOnClickListener(this);
    }

    void registerEngeneeringComponents() {
        /*square = (Button) findViewById(R.id.btnSquare);
        square.setOnClickListener(this);
        percent = (Button) findViewById(R.id.btnPercent);
        percent.setOnClickListener(this);
        exponent = (Button) findViewById(R.id.btnExponent);
        exponent.setOnClickListener(this);*/
        rOne = (RadioButton) findViewById(R.id.rOne);
        rTwo = (RadioButton) findViewById(R.id.rTwo);
        rThree = (RadioButton) findViewById(R.id.rThree);
        rFour = (RadioButton) findViewById(R.id.rFour);
        rOne.setOnClickListener(this);
        rTwo.setOnClickListener(this);
        rThree.setOnClickListener(this);
        rFour.setOnClickListener(this);

    }

    @Override
    public void onFragmentInteraction(String link) {
        //FragmentBin fragment = (FragmentBin) getFragmentManager().findFragmentById(R.id.frgmCont);
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

                break;
            case R.id.rOne:
                binInit();
                break;
            case R.id.rTwo:
                octInit();
                break;
            case R.id.rThree:
                decInit();
                break;
            case R.id.rFour:

                break;
            default:
                break;
            case R.id.btnBackSpace:
                if (display.getText().toString().length() > 0) {
                    display.setText(display.getText().toString().substring(0, display.getText().toString().length() - 1));
                }
                break;
            case R.id.btnResult:
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                String date = new Date().toString();
                String expression = display.getText().toString();
                String result = ExpressionUtils.calculateExpression(expression).toPlainString();
                cv.put("date", date);
                cv.put("expression", expression);
                cv.put("result", result);
                long id = db.insert("calcHistory", null, cv);
                Log.i("info", "the data has added. Id - " + id);
                dbHelper.close();
                symbolDisplay.setText(result);
                break;
            case R.id.editText2:
                Intent i = new Intent(this, HistoryActivity.class);
                startActivityForResult(i, 404);
                break;
            case R.id.btnClear:
                display.setText("");
                symbolDisplay.setText("");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        String expression = data.getStringExtra("expression");
        symbolDisplay.setText(String.valueOf(ExpressionUtils.calculateExpression(expression).toPlainString()));
        display.setText(String.valueOf(expression));
    }

/*    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.rOne:
                    binInit();
                    break;
                case R.id.rTwo:

                    break;
                case R.id.rThree:
                    decInit();
                    break;
                case R.id.rFour:

                    break;
                default:
                    break;
            }
        }
    };*/

    public void decInit(){
        fragDec = new FragmentDec();
        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frgmCont, fragDec);
        fTrans.commit();
    }

    public void binInit(){
        fragBin = new FragmentBin();
        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frgmCont, fragBin);
        fTrans.commit();
    }

    public void octInit(){
        fragOct = new FragmentOct();
        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frgmCont, fragOct);
        fTrans.commit();
    }
}
