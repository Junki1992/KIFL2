package com.websarva.wings.android.kifl2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //保存ボタンであるButtonオブジェクトを取得。
        val btSave = findViewById<Button>(R.id.btSave)
        //リスナクラスのインスタンスを生成。
        val listener = ButtonClickListener()
        //保存ボタンにリスナを設定。
        btSave.setOnClickListener(listener)
        //クリアボタンにリスなを設定。
        btClear.setOnClickListener(listener)

        //クリアボタンであるButtonオブジェクトを取得。
        val btClear = findViewById<Button>(R.id.btClear)
        //クリアボタンにリスナを設定。
        btClear.setOnClickListener(listener)
    }

    //ボタンをタップした時の処理を記述したリスナクラス。
    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            //進路選択欄であるCheckBoxオブジェクトを取得。
            val cbBoxes = findViewById<MyCustomCheckBoxesView>(R.id.cbCheckBoxes)
            //希望学科欄であるSpinnerオブジェクトを取得。
            val courseList = findViewById<Spinner>(R.id.spCourseList)
            //名前入力欄であるEditTextオブジェクトを取得。
            val input = findViewById<EditText>(R.id.etInput)
            //メッセージ表示欄であるTextViewオブジェクトを取得。
            val output = findViewById<TextView>(R.id.tvOutput)

            //クリア確認ダイアログフラグメントオブジェクトを生成。
            val dialogFragment = ClearConfirmDialogFragment()

            //idのR値によって処理を分岐。
            when(view.id) {
                //保存ボタンの場合・・・
                R.id.btSave -> {
                    //選択された進路先を取得。
                    var string = ""
                    cbBoxes.getCheckList().forEach {
                        string += it
                        string += " "
                    }
                    //選択された学科を取得。
                    val course = courseList.getSelectedItem()
                    //入力された名前文字列を取得。
                    val inputStr = input.text.toString()
                    //メッセージを表示。
                    output.text = "希望進路：" + string + "\n" + "選択学科：" + course + "\n" + "氏名：" + inputStr
                }
                //クリアボタンの場合・・・
                R.id.btClear -> {
                    //ダイアログを表示。
                    dialogFragment.show(supportFragmentManager, "ClearConfirmDialogFragment")
                    //メッセージ表示欄に空文字を設定。
                    output.text = ""
                }
            }
        }
    }
}
