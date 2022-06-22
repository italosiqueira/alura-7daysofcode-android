package br.com.alura.devhub.webclient

import br.com.alura.devhub.webclient.service.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    val gitHubService: GitHubService
        get() =
            retrofit.create(GitHubService::class.java);

}