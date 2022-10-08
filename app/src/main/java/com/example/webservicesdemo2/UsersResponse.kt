package com.example.webservicesdemo2

import com.google.gson.annotations.SerializedName

data class UsersResponse (
    @SerializedName("page")
    var pageNumber : Int,

    @SerializedName("per_page")
    var usersPerPage : Int,

    @SerializedName("total")
    var userCount : Int,

    @SerializedName("total_pages")
    var totalPages : Int = 0,

    @SerializedName("data")
    var users : ArrayList<User>
){
    override fun toString(): String {
        return "page = $pageNumber -- perPage = $usersPerPage -- total = $userCount -- total_pages = $totalPages"
    }
}

