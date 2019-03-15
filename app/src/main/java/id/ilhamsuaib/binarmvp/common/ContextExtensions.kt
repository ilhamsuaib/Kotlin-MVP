package id.ilhamsuaib.binarmvp.common

import android.content.Context
import android.widget.Toast

/**
 * Created by @ilhamsuaib on 15/03/19.
 * github.com/ilhamsuaib
 */

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}