package com.gymseries.utils

import java.text.DecimalFormat

class FormatUtils {

    companion object {
        fun formatarMoeda(imc: Double): String? {
            val formato = "#,##0.00"
            val d = DecimalFormat(formato)
            var imcFormatado = d.format(imc)
            return imcFormatado
        }
    }
}
