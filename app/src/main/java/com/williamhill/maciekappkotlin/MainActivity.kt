package com.williamhill.maciekappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.williamhill.maciekappkotlin.databinding.ActivityMainBinding
import com.williamhill.maciekappkotlin.model.Data
import com.williamhill.maciekappkotlin.model.DataObject
import com.williamhill.maciekappkotlin.model.Embedded
import com.williamhill.maciekappkotlin.model.Example
import com.williamhill.maciekappkotlin.model.Examples
import com.williamhill.maciekappkotlin.networking.KiedyApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var kiedyApiService: KiedyApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logging = HttpLoggingInterceptor()

        logging.apply {
            logging.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
        client.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://kiedysmieci.op7.pl/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client.build())
            .build()
        kiedyApiService = retrofit.create(KiedyApiService::class.java)

        getExamples()
    }

    private fun getExamples() {
        val call = kiedyApiService.getExamples()

        call.enqueue(object : Callback<DataObject> {
            override fun onResponse(call: Call<DataObject>, response: Response<DataObject>) {
                if (!response.isSuccessful) {
                    binding.textBlock.text = response.code().toString()
                    return
                }
                val data = response.body()
                data?.let {
                    val dataObject = it
                    val data1: Data? = dataObject.data
                    val embedded: Embedded? = data1?.embedded
                    val examples: Examples? = embedded?.examples
                    val exampleList: MutableList<Example?> = mutableListOf()
                    exampleList.add(examples?.x1)
                    exampleList.add(examples?.x1)
                    exampleList.add(examples?.x1)
                    exampleList.add(examples?.x1)
                    exampleList.add(examples?.x1)
                    exampleList.add(examples?.x2)
                    exampleList.add(examples?.x2)
                    exampleList.add(examples?.x2)
                    exampleList.add(examples?.x2)
                    exampleList.add(examples?.x2)
                    exampleList.add(examples?.x2)
                    exampleList.add(examples?.x3)
                    exampleList.add(examples?.x3)
                    exampleList.add(examples?.x3)
                    exampleList.add(examples?.x3)
                    exampleList.add(examples?.x3)
                    exampleList.add(examples?.x3)
                    binding.recycler.apply {
                        layoutManager = LinearLayoutManager(applicationContext)
                        adapter = KiedyAdapter(exampleList, applicationContext)
                        hasFixedSize()
                    }
                }
            }

            override fun onFailure(call: Call<DataObject>, t: Throwable) {
                binding.textBlock.text = t.message
            }
        })
    }
}
