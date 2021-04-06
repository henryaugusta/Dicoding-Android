package com.feylabs.fgithub.model;

data class User(
    var url: String,
    var name: String? = "",
    var username: String? = "",
    var photo: String?,
    var company: String?,
    var location: String,
    var blog: String,
    var bio: String,
    var repoCount: String,
    var followingCount: Int,
    var followersCount: Int,
    var followersLink: String,
    var followingLink: String
){

}