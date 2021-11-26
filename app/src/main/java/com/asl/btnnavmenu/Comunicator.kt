package com.asl.btnnavmenu

import androidx.fragment.app.Fragment

interface Comunicator {
    fun PassData(fragment: Fragment, editTextData : String)
}