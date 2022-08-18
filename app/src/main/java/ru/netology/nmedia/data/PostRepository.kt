package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import ru.netology.nmedia.Post

interface PostRepository  {
    fun get(): LiveData<Post>
    fun like()
    fun share()
}