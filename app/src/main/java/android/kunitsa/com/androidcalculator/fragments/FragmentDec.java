package android.kunitsa.com.androidcalculator.fragments;

import android.app.Fragment;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.kunitsa.com.androidcalculator.OnFragmentInteractionListener;
import android.kunitsa.com.androidcalculator.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Администратор on 01.06.2017.
 */

public class FragmentDec extends Fragment implements View.OnClickListener {

    Button allClear, equals, divide, multiply, minus, plus, square, percent, exponent, left, right, backspace;
    Button one, two, three, four, five, six, seven, eight, nine, zero, point;
    View v;
    TextView display;
    TextView symbolDisplay;

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dec, null);
        registerSimpleComponents();

        return v;
    }

    public void registerSimpleComponents() {
        display = (TextView) v.findViewById(R.id.editText1);
        symbolDisplay = (TextView) v.findViewById(R.id.editText2);
        symbolDisplay.setOnClickListener(this);
        allClear = (Button) v.findViewById(R.id.btnClear);
        allClear.setOnClickListener(this);
        equals = (Button) v.findViewById(R.id.btnResult);
        equals.setOnClickListener(this);
        one = (Button) v.findViewById(R.id.btn1);
        one.setOnClickListener(this);
        two = (Button) v.findViewById(R.id.btn2);
        two.setOnClickListener(this);
        three = (Button) v.findViewById(R.id.btn3);
        three.setOnClickListener(this);
        four = (Button) v.findViewById(R.id.btn4);
        four.setOnClickListener(this);
        five = (Button) v.findViewById(R.id.btn5);
        five.setOnClickListener(this);
        six = (Button) v.findViewById(R.id.btn6);
        six.setOnClickListener(this);
        seven = (Button) v.findViewById(R.id.btn7);
        seven.setOnClickListener(this);
        eight = (Button) v.findViewById(R.id.btn8);
        eight.setOnClickListener(this);
        nine = (Button) v.findViewById(R.id.btn9);
        nine.setOnClickListener(this);
        zero = (Button) v.findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        point = (Button) v.findViewById(R.id.btnPoint);
        point.setOnClickListener(this);
        divide = (Button) v.findViewById(R.id.btnDevide);
        divide.setOnClickListener(this);
        multiply = (Button) v.findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);
        plus = (Button) v.findViewById(R.id.btnPlus);
        plus.setOnClickListener(this);
        minus = (Button) v.findViewById(R.id.btnMinus);
        minus.setOnClickListener(this);
        backspace = (Button) v.findViewById(R.id.btnBackSpace);
        backspace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
}
