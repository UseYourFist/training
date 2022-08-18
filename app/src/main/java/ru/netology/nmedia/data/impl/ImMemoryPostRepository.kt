package ru.netology.nmedia.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post
import ru.netology.nmedia.data.PostRepository

class ImMemoryPostRepository : PostRepository {
    private var post = Post(
        id = 1,
        author = "Kostantin",
        content = "Home Work",
        published = "09.08.22",
        likesNumber = "999",
        sharesNumber = "0",
        viewsNumber = "1120000",
        likedByMe = false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        var numberLikes = post.likesNumber.toLong()
        if (post.likedByMe) numberLikes++ else numberLikes--
        post = post.copy (likesNumber = numberLikes.toString())
        data.value = post
    }

    override fun share() {
        var numberShares = post.sharesNumber.toLong()
        numberShares++
        post = post.copy(sharesNumber = numberShares.toString())
        data.value = post
    }

}