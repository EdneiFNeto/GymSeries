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
import com.gymseries.model.Triceps
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class Tricesctivity : AppCompatActivity() {

    private lateinit var triceps: ArrayList<Triceps>
    private lateinit var adapter: MyGenericAdapter<Triceps>
    private val op: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tricesctivity)

        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_triceps).toUpperCase()
        )

        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_triceps)
        triceps = ArrayList<Triceps>()
        adapter = MyGenericAdapter(this, triceps, op, true)
        recyclerViewTriceps.adapter = adapter
        ListEntityGenericAsync(this, triceps, adapter, op).execute()
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
            triceps.add(
                Triceps(
                    id = 0L,
                    descr = treino.text.toString(),
                    status = false,
                    repeticoes = num_repeticao.text.toString(),
                    peso = peso.text.toString(),
                    serie = null
                )
            )

            AddEntityGenericAsync(context, 1, triceps, adapter).execute()
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

