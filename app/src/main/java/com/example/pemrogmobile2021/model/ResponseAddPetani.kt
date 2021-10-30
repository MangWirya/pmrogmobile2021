package com.example.pemrogmobile2021.model

import com.google.gson.annotations.SerializedName

data class ResponseAddPetani (
    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
)