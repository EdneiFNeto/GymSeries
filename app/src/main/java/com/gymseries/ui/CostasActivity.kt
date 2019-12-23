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
import com.gymseries.model.Costa
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class CostasActivity : AppCompatActivity() {

    private lateinit var adapter: MyGenericAdapter<Costa>
    private lateinit var costas: ArrayList<Costa>
    private val op: Int = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costas)

        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_costas)
        )

        var recyclerView = findViewById<RecyclerView>(R.id.recycle_view_costas)
        costas = ArrayList<Costa>()
        adapter = MyGenericAdapter(this, costas, op, true)
        recyclerView.adapter = adapter

        ListEntityGenericAsync<Costa>(this, costas, adapter, ResourcesUtils.getString(this, R.string.op_costa)).execute()
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
            costas.add(
                Costa(
                    id = 0L,
                    descr = treino.text.toString(),
                    status = false,
                    repeticoes = num_repeticao.text.toString(),
                    peso = peso.text.toString(),
                    serie = null
                )
            )

            AddEntityGenericAsync(context, 4, costas, adapter).execute()
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
