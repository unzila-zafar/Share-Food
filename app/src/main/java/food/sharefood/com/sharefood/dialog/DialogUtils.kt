package food.sharefood.com.sharefood.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import food.sharefood.com.sharefood.R

class DialogUtils {


    companion object {
        internal var progressDialog: AlertDialog? = null
        var dialogBuilder: AlertDialog.Builder? = null
        internal lateinit var dialogView: View

        fun ShowProgressDialog(context: Context) {
            dialogBuilder = AlertDialog.Builder(context)
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            dialogView = inflater.inflate(R.layout.progress_layout, null)
            dialogView.visibility = View.VISIBLE
            dialogBuilder!!.setView(dialogView)
            dialogBuilder!!.setCancelable(false)
            progressDialog = dialogBuilder!!.create()
            progressDialog!!.window!!.decorView.setBackgroundResource(android.R.color.transparent)
            if (progressDialog != null)
                progressDialog!!.show()
        }

        fun HideProgressDialog() {

            if (progressDialog != null && progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }
        }
    }
}