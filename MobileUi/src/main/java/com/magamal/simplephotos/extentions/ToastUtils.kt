import android.widget.Toast
import androidx.annotation.StringRes
import com.magamal.simplephotos.app.SimplePhotosApp

private var toast: Toast? = null

fun toast(@StringRes messageResId: Int) =
    showToast(
        SimplePhotosApp.instance.getString(
            messageResId
        ), Toast.LENGTH_SHORT
    )

fun toast(message: String?) =
    showToast(message, Toast.LENGTH_SHORT)

fun longToast(@StringRes messageResId: Int) =
    showToast(
        SimplePhotosApp.instance.getString(
            messageResId
        ), Toast.LENGTH_LONG
    )

fun longToast(message: String?) =
    showToast(message, Toast.LENGTH_LONG)

private fun showToast(message: String?, duration: Int) {
    toast?.cancel()
    toast = Toast.makeText(SimplePhotosApp.instance, "$message", duration).apply { show() }
}