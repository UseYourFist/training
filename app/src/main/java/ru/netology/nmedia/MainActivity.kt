package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                authorName.text = post.author
                textArea.text = post.content
                date.text = post.published
                likesNumber.text = post.likesNumber
                sharesNumber.text = post.sharesNumber
                viewsNumber.text = post.viewsNumber

                likes.setImageResource(
                    if (post.likedByMe) R.drawable.ic_favorited_24 else R.drawable.ic_favorite_24
                )
                likesNumber.setText(
                    numFormat(post.likesNumber)
                )
                sharesNumber.setText(
                    numFormat(post.sharesNumber)
                )

                binding.likes.setOnClickListener{
                    viewModel.like()
                }

                binding.share.setOnClickListener{
                    viewModel.share()
                }

                viewsNumber.setText(numFormat(post.viewsNumber))

            }
        }
    }
}