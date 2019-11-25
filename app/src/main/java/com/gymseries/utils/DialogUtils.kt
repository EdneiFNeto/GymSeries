package com.gymseries.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.generics.AddEntityGenericAsync
import com.gymseries.model.Biceps

class DialogUtils {

    companion object {
        private fun <T> showDialogAddSerie(
            context: Context,
            list: ArrayList<T>,
            adapter: RecyclerView.Adapter<*>
        ) {

            var dialog = AlertDialog.Builder(context)
            dialog.setIcon(R.drawable.ic_info)
            dialog.setTitle(ResourcesUtils.getString(context, R.string.add_serie))
            dialog.setCancelable(false)
            val view = LayoutInflater.from(context).inflate(R.layout.layout_dialog_add_serie, null)
            var treino = view.findViewById<EditText>(R.id.edt_text_dialog_treino)
            var num_repeticao = view.findViewById<EditText>(R.id.edt_text_dialog_num_repeticao)
            var peso = view.findViewById<EditText>(R.id.edt_text_dialog_peso)

            dialog.setPositiveButton(
                ResourcesUtils.getString(
                    context,
                    R.string.button_confirmar
                )
            ) { dialog, which ->

                var biceps: ArrayList<Biceps> = ArrayList()
                biceps.add(
                    Biceps(
                        id = 0L,
                        descr = treino.text.toString(),
                        status = false,
                        repeticoes = num_repeticao.text.toString(),
                        peso = peso.text.toString(),
                        serie = null

                    )
                )

                AddEntityGenericAsync(context, 0, biceps, adapter).execute()
                dialog.dismiss()
            }

            dialog.setNegativeButton(
                ResourcesUtils.getString(
                    context,
                    R.string.button_cancelar
                )
            ) { dialog, _ ->
                dialog.dismiss()
            }

            dialog.setView(view)
            var alert = dialog.create()
            alert.show()
        }
    }
}
