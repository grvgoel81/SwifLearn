package com.example.swiflearn.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by gauravgoel on 02/August/2020
 */
@Parcelize
data class PastClassInfo (
    val subjectName: String? = null,
    val topic: String? = null,
    val date: String? = null,
    val teacherName: String? = null
): Parcelable