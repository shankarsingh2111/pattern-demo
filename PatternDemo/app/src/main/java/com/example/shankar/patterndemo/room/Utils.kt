package com.example.shankar.patterndemo.room

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class Utils{

    companion object {

        public fun showSoftKeyboard(view: View){
            val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInputFromWindow(view.applicationWindowToken, InputMethodManager.SHOW_FORCED, 0)
        }

    }

}