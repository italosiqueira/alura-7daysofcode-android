package br.com.alura.devhub.webclient.model

import com.google.gson.annotations.SerializedName

data class GitHubProfileWeb(
    val login: String,
    @SerializedName("avatar_url")
    val avatar: String,
    val name: String,
    val bio: String
)
