package com.gymseries.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gymseries.R
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class ChartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var supportActionBar = (activity as AppCompatActivity).supportActionBar
        ActionBarUtils.show(supportActionBar)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.layout_settings, container, false)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        val item = menu.add(ResourcesUtils.getString(context, R.string.title_dialog_chart))
        item.setIcon(R.drawable.ic_calculator)
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        item.setOnMenuItemClickListener {

            if (context != null) {

                var builder = AlertDialog.Builder(context!!)
                builder.setIcon(R.drawable.ic_calculator)
                builder.setTitle(ResourcesUtils.getString(context, R.string.title_calcular_imc))
                val myView = LayoutInflater.from(context).inflate(R.layout.layout_dialog_medidas, null)
                builder.setView(myView)

                var peso = myView.findViewById<EditText>(R.id.edt_text_peso_imc)
                var altura = myView.findViewById<EditText>(R.id.edt_text_altura_imc)
                var dialog = builder.create()
                dialog.show()
            }

            true
        }

        super.onCreateOptionsMenu(menu, inflater)
    }
}
