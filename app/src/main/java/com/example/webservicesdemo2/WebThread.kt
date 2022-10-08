package com.example.webservicesdemo2

import android.os.AsyncTask

class WebThread : AsyncTask<Any?,Any?,UsersResponse?>(){
    override fun doInBackground(vararg params: Any?): UsersResponse? {
       return WebUtil.getUsers2(1)
    }

    override fun onPostExecute(result: UsersResponse?) {
        super.onPostExecute(result)
    }
}