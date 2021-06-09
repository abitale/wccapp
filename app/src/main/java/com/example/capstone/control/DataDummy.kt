package com.example.capstone.control

import com.example.capstone.entity.Report

object DataDummy {

    fun generateDummyReports(): List<Report> {
        val reportsData = ArrayList<Report>()

        reportsData.add(
            Report(
                0,
                "Unassigned",
                "Tolong Segera kirim bantuan",
                "Budiwan",
                1,
                "13 Desember 2020"
            )
        )

        reportsData.add(
            Report(
                1,
                "Unassigned",
                "Lapor duga terjadi KDRT pada anak",
                "Susi",
                2,
                "12 Desember 2020"
            )
        )

        reportsData.add(
            Report(
                2,
                "Unassigned",
                "Anak saya selalu terlihat murung setelah pulang sekolah",
                "Adijaya",
                2,
                "13 Desember 2020"
            )
        )

        reportsData.add(
            Report(
                3,
                "Unassigned",
                "Adik saya belum sampai kerumah dari 2 hari kemarin",
                "Tomas",
                3,
                "14 Desember 2020"
            )
        )

        return reportsData
    }

}