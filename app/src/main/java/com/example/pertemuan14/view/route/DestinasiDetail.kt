package com.example.pertemuan14.route.view

import com.example.pertemuan14.R
import com.example.pertemuan14.view.route.DestinasiNavigasi

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}