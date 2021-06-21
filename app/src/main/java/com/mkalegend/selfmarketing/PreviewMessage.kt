package com.mkalegend.selfmarketing

import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

data class PreviewMessage(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val availableDate: String?,
    val checkboxJunior: Boolean,
    val checkboxStart: Boolean,
    val spinnerPosition: String?
) : Serializable {

    fun addJuniorStatus() = if (checkboxJunior) "a Junior " else "an "

    fun getDate() = if (checkboxStart) "immediately" else "from $availableDate"

}