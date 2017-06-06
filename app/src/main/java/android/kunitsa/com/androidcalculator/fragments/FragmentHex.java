package android.kunitsa.com.androidcalculator.fragments;

import android.app.Fragment;
import android.content.Context;
import android.kunitsa.com.androidcalculator.Converter;
import android.kunitsa.com.androidcalculator.Notation;
import android.kunitsa.com.androidcalculator.OnFragmentInteractionListener;
import android.kunitsa.com.androidcalculator.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Администратор on 06.06.2017.
 */

public class FragmentHex extends Fragment implements View.OnClickListener {

    Button allClear, equals, divide, multiply, minus, plus, backspace;
    Button one, two, three, four, five, six, seven, eight, nine, zero, a, b, c, d, e, f, point;
    View v;
    TextView display;
    TextView symbolDisplay;

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_hex, null);
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
        a = (Button) v.findViewById(R.id.btnA);
        a.setOnClickListener(this);
        b = (Button) v.findViewById(R.id.btnB);
        b.setOnClickListener(this);
        c = (Button) v.findViewById(R.id.btnC);
        c.setOnClickListener(this);
        d = (Button) v.findViewById(R.id.btnD);
        d.setOnClickListener(this);
        e = (Button) v.findViewById(R.id.btnE);
        e.setOnClickListener(this);
        f = (Button) v.findViewById(R.id.btnF);
        f.setOnClickListener(this);
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
            case R.id.btnA:
                display.append("A");
                break;
            case R.id.btnB:
                display.append("B");
                break;
            case R.id.btnC:
                display.append("C");
                break;
            case R.id.btnD:
                display.append("D");
                break;
            case R.id.btnE:
                display.append("E");
                break;
            case R.id.btnF:
                display.append("F");
                break;
            case R.id.btnResult:
                display.setText(Converter.convertByNotation(Notation.HEX, Notation.DEC, display.getText().toString()));
                break;
            case R.id.btnBackSpace:
                if (display.getText().toString().length() > 0) {
                    display.setText(display.getText().toString().substring(0, display.getText().toString().length() - 1));
                }
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