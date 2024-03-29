package ru.netology.nmedia

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likesNumber: String,
    var sharesNumber: String,
    var viewsNumber: String,
    val likedByMe: Boolean
)