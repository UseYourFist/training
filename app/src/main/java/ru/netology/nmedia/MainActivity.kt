package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Kostantin",
            content = "Home Work",
            published = "09.08.22",
            likesNumber = "9",
            sharesNumber = "0",
            viewsNumber = "1120000",
            likedByMe = false
        )
        with(binding) {
            authorName.text = post.author
            textArea.text = post.content
            date.text = post.published
            likesNumber.text = post.likesNumber
            sharesNumber.text = post.sharesNumber
            viewsNumber.text = post.viewsNumber

            if (post.likedByMe) {
                likes?.setImageResource(R.drawable.ic_favorited_24)
            }

            likes?.setOnClickListener {
                post.likedByMe = !post.likedByMe
                var numberLikes = post.likesNumber.toLong()
                likes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_favorited_24 else R.drawable.ic_favorite_24
                )
                    if (post.likedByMe) numberLikes++ else numberLikes--
                post.likesNumber = numberLikes.toString()
                likesNumber.setText(
                    post.likesNumber
                )
            }

            share?.setOnClickListener {
                var numberShares = post.sharesNumber.toLong()
                numberShares++
                post.sharesNumber = numberShares.toString()
                sharesNumber.setText(
                    post.sharesNumber
                )
            }

            var numberViews = post.viewsNumber.toLong()
            val result = numberViews.toString()
            if (numberViews in 1000..1_099) {
                post.viewsNumber = "1K"
            }
            if (numberViews in 1_000..9_999) {
                post.viewsNumber = result[0] + "." + result[1] + "K"
            }
            if (numberViews in 10_000..999_999) {
                post.viewsNumber = result[0] + "" + result[1] + "K"
            }
            if (numberViews > 1_000_000) {
                post.viewsNumber = result[0] + "." + result[1] + "M"
            }
            viewsNumber.setText(post.viewsNumber)

            binding.root.setOnClickListener {}

            binding.likes.setOnClickListener{}
        }
    }
}