package com.websarva.wings.android.kifl2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class ClearConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(cancelledInstanceState: Bundle?): Dialog {
        //ダイアログビルダを生成。
        val builder = AlertDialog.Builder(activity)
        //ダイアログのタイトルを設定。
        builder.setTitle(R.string.dialog_title)
        //ダイアログのメッセージを設定・
        builder.setMessage(R.string.dialog_msg)
        //Positive Buttonを設定。
        builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
        //Negative Buttonを設定。
        builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
        //Neutral Buttonを設定。
        builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener())
        //ダイアログオブジェクトを生成し、リターン。
        val dialog = builder.create()
        return dialog
    }
    //ダイアログアクションボタンがタップされた時の処理が記述されたメンバクラス。
    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface, which: Int) {
            //トーストメッセージ用の文字列を用意。
            var msg = ""
            //タップされたアクションボタンで分岐。
            when(which) {
                //Positive Buttonならば・・・
                DialogInterface.BUTTON_POSITIVE ->
                    //クリア用のメッセージを格納。
                msg = getString(R.string.dialog_ok_toast)
                //Negative Buttonならば・・・
                DialogInterface.BUTTON_NEGATIVE ->
                    //キャンセル用のメッセージを格納。
                msg = getString(R.string.dialog_ng_toast)
                //Neutral Buttonならば・・・
                DialogInterface.BUTTON_NEUTRAL ->
                    //問合せ用のメッセージを格納。
                msg = getString(R.string.dialog_nu_toast)
            }
            //トーストの表示。
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        }
    }
}