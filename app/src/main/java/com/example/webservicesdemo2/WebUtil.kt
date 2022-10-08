package com.example.webservicesdemo2

import android.util.Log
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WebUtil {
    companion object{
        fun getUsers2(pageNumber: Int) : UsersResponse{
            var getUserApiUrl = URL("https://reqres.in/api/users?page=$pageNumber")
            var httpURLConnection = getUserApiUrl.openConnection() as HttpURLConnection
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.connect()

            var resReader = InputStreamReader(httpURLConnection.inputStream)
            var gson = Gson()
            var usersResponse = gson.fromJson<UsersResponse>(
                resReader,
                UsersResponse::class.java
            )

            Log.e("tag",usersResponse.toString())
            for(user in usersResponse.users){
                Log.e("tag","$user")
            }
            return usersResponse
        }

        fun getUsers1(pageNumber : Int) : UsersResponse{
                var getUserApiUrl = URL("https://reqres.in/api/users?page=$pageNumber")
                var httpURLConnection = getUserApiUrl.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "GET"
                httpURLConnection.connect()

                var inStream = httpURLConnection.inputStream

                var responseBuffer = StringBuffer()
                var count = 0
                var data =  ByteArray(1024 * 1)
                count = inStream.read(data)

                while(count != -1){
                    responseBuffer.append(String(data,0,count))
                    count = inStream.read(data)
                }

                inStream.close()

                Log.e("tag",responseBuffer.toString())

                var gson = Gson()

                var usersResponse = gson.fromJson<UsersResponse>(
                    responseBuffer.toString(),
                    UsersResponse::class.java
                )
                Log.e("tag",usersResponse.toString())
                for(user in usersResponse.users){
                    Log.e("tag","$user")
                }
                return usersResponse
        }
    }
}