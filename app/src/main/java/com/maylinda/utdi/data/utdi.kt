package com.maylinda.utdi.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maylinda.utdi.R

data class Utdi(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
    )
val utdis = listOf(
    Utdi(R.drawable.bigdata, R.string.matkul_name_1, 2, R.string.matkul_description_1),
    Utdi(R.drawable.prakbigdata, R.string.matkul_name_2, 1, R.string.matkul_description_2),
    Utdi(R.drawable.pnm, R.string.matkul_name_3, 3, R.string.matkul_description_3),
    Utdi(R.drawable.prakpnm, R.string.matkul_name_4, 2, R.string.matkul_description_4),
    Utdi(R.drawable.proyek3, R.string.matkul_name_5, 2, R.string.matkul_description_5),
    Utdi(R.drawable.pwbl, R.string.matkul_name_6, 3, R.string.matkul_description_6),
    Utdi(R.drawable.prakweblanjut, R.string.matkul_name_7, 2, R.string.matkul_description_7),
    Utdi(R.drawable.pancasila, R.string.matkul_name_8, 2, R.string.matkul_description_8),
    Utdi(R.drawable.etika, R.string.matkul_name_9, 2, R.string.matkul_description_9)


)