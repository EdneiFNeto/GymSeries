package com.gymseries.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.AddEntityGenericAsync
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Biceps
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils


class BicepsActivity : AppCompatActivity() {

    private lateinit var biceps: ArrayList<Biceps>
    private lateinit var adapter: MyGenericAdapter<Biceps>
    private val op: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_triceps)
        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_biceps)
        )

        var recyclerViewBiceps = findViewById<RecyclerView>(R.id.recycle_view_biceps)
        biceps = ArrayList()
        adapter = MyGenericAdapter(this, biceps, op, true)
        recyclerViewBiceps.adapter = adapter
        ListEntityGenericAsync(this, biceps, adapter, op).execute()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_serie, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.item_add -> {
                showDialogAddSerie(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDialogAddSerie(context: Context) {

        var dialog = AlertDialog.Builder(context)
        dialog.setIcon(R.drawable.ic_serie)
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
