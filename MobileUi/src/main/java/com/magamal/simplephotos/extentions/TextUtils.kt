package com.magamal.simplephotos.extentions

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * @author Mahmoud Gamal on 17/10/2021.
 */

fun EditText.addTextWatcher(onTextChanged: (String?) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            onTextChanged(s?.toString())
        }

    })
}