package jp.techacademy.daisuke.kobayashi.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


//アクセスコントロール classキーワード 新規クラス名 extendsキーワード 継承元のクラス {...}
//MainActiviyクラスは親であるAppCompatActivityクラスの機能を引き継いでいる
//ボタンにOnClickListenerを設定する時はsetOnClickListenerメソッドを使う
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;

    //@Overrideはオーバーライド（上書き）しているメソッドである
    @Override

    //アクセスコントロール 戻り値の型 関数名(引数) {...},voidは値を返さない
    protected void onCreate(Bundle savedInstanceState) {

        //呼び出し元.関数名(引数),superは継承元クラスの関数を呼び出し
        //superは子クラスのonCreate内で親クラスのonCreateを呼び出すような場合でのみ使用
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //(Button)というのはButtonクラスにキャスト
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

        /*  ボタン毎に動作設定をする際の書き方
        //setOnClickListenerメソッドの引数にはonClickメソッドを実装したクリックリスナークラスを渡す必要
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI_PARTS", "ボタンをタップしました");
            }
        });
        */

        /*　他クラスへ
        Human me = new Human("小林","プログラム",35);    //クラス、名前　

        me.say();
        me.think();
        */
    }

    @Override
    public void onClick(View v) {
            showTimePickerDialog();
        }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(hourOfDay <= 1){
                            mTextView.setText("こんばんは");
                        }else if (hourOfDay <= 9){
                            mTextView.setText("おはよう");
                        }else if (hourOfDay <= 17){
                            mTextView.setText("こんにちは");
                        }else{
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}