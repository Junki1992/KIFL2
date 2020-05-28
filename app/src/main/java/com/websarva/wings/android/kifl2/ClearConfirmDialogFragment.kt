package com.websarva.wings.android.kifl2

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ClearConfirmDialogFragment : DialogFragment() {

    // Use this instance of the interface to deliver action events
    private lateinit var listener: NoticeDialogListener

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    interface NoticeDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = context as NoticeDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }

    override fun onCreateDialog(cancelledInstanceState: Bundle?): Dialog {
        //ダイアログビルダを生成。
        val builder = AlertDialog.Builder(activity)
        //ダイアログのタイトルを設定。
        builder.setTitle(R.string.dialog_title)
        //ダイアログのメッセージを設定・
        builder.setMessage(R.string.dialog_msg)

        //Positive Buttonを設定。
        builder.setPositiveButton(R.string.dialog_btn_ok,
            DialogInterface.OnClickListener { _, _ ->
            // Send the positive button event back to the host activity
            listener.onDialogPositiveClick(this)
                //クリア用のメッセージを格納。
                val msg = getString(R.string.dialog_ok_toast)
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
        })
        //Negative Buttonを設定。
        builder.setNegativeButton(R.string.dialog_btn_ok,
            DialogInterface.OnClickListener { _, _ ->
                // Send the positive button event back to the host activity
                listener.onDialogNegativeClick(this)
                //キャンセル用のメッセージを格納。
                val msg = getString(R.string.dialog_ng_toast)
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            })

        //Neutral Buttonを設定。
        builder.setNeutralButton(R.string.dialog_btn_nu,
            DialogInterface.OnClickListener { _, _ ->
                // Send the positive button event back to the host activity
                //問合せ用のメッセージを格納。
                val msg = getString(R.string.dialog_nu_toast)
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
            })
        //ダイアログオブジェクトを生成し、リターン。
        return builder.create()
    }

    //ダイアログアクションボタンがタップされた時の処理が記述されたメンバクラス。
//    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
//        override fun onClick(dialog: DialogInterface, which: Int) {
//            //トーストメッセージ用の文字列を用意。
//            var msg = ""
//            //タップされたアクションボタンで分岐。
//            when (which) {
//                //Positive Buttonならば・・・
//                DialogInterface.BUTTON_POSITIVE ->
//                    //クリア用のメッセージを格納。
//                    msg = getString(R.string.dialog_ok_toast)
//                //Negative Buttonならば・・・
//                DialogInterface.BUTTON_NEGATIVE ->
//                    //キャンセル用のメッセージを格納。
//                    msg = getString(R.string.dialog_ng_toast)
//                //Neutral Buttonならば・・・
//                DialogInterface.BUTTON_NEUTRAL ->
//                    //問合せ用のメッセージを格納。
//                    msg = getString(R.string.dialog_nu_toast)
//            }
//            //トーストの表示。
//            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
//        }
//    }
}