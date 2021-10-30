package com.example.pemrogmobile2021.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pemrogmobile2021.R
import com.example.pemrogmobile2021.model.DataItem
import com.example.pemrogmobile2021.model.ResponseAddPetani
import com.example.pemrogmobile2021.model.ResponsePetani
import com.example.pemrogmobile2021.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPetaniActivity : AppCompatActivity() {
    lateinit var edNama : EditText
    lateinit var edAlamat : EditText
    lateinit var edProvinsi : EditText
    lateinit var edKabupaten : EditText
    lateinit var edKecamatan : EditText
    lateinit var edKelurahan : EditText
    lateinit var edNamaistri : EditText
    lateinit var edJumlahlahan : EditText
    lateinit var edFoto : EditText
    lateinit var btnSimpanPetani : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_petani)

        edNama = findViewById(R.id.edNama)
        edAlamat = findViewById(R.id.edAlamat)
        edProvinsi = findViewById(R.id.edProvinsi)
        edKabupaten = findViewById(R.id.edKabupaten)
        edKecamatan = findViewById(R.id.edKecamatan)
        edKelurahan = findViewById(R.id.edKelurahan)
        edNamaistri = findViewById(R.id.edNamaistri)
        edJumlahlahan = findViewById(R.id.edJumlahlahan)
        edFoto = findViewById(R.id.edFoto)
        btnSimpanPetani = findViewById(R.id.btnSimpanPetani)

        btnSimpanPetani.setOnClickListener(View.OnClickListener { view ->
            var ptn = DataItem()
            ptn.nama = edNama.text.toString()
            ptn.alamat = edAlamat.text.toString()
            ptn.provinsi = edProvinsi.text.toString()
            ptn.kabupaten = edKabupaten.text.toString()
            ptn.kecamatan = edKecamatan.text.toString()
            ptn.kelurahan = edKelurahan.text.toString()
            ptn.namaIstri = edNamaistri.text.toString()
            ptn.jumlahLahan = edJumlahlahan.text.toString()
            ptn.foto = edFoto.text.toString()
            ptn.id = null

            NetworkConfig().getService()
                .addPetani(ptn)
                .enqueue(object : Callback<ResponseAddPetani?> {
                    override fun onFailure(call: Call<ResponseAddPetani?>, t: Throwable) {
                        Toast.makeText(
                            this@AddPetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseAddPetani?>,
                        response: Response<ResponseAddPetani?>
                    ) {
                        Toast.makeText(this@AddPetaniActivity, "Berhasil Tambah", Toast.LENGTH_SHORT).show()
                    }
                })
        })
    }
}