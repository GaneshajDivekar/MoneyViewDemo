package moneyview.demo.repository

import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moneyview.demo.model.ResponseTopMovies
import moneyview.demo.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: APIService
) {/*
    var topMovieLiveData=MutableLiveData<ResponseTopMovies>()

    fun loadPage(topMoviesResponse: MutableLiveData<Any>, page : Int) {
        apiHelper.getTopRatedMovies(pageIndex = page).enqueue(object : Callback<ResponseTopMovies> {
            override fun onFailure(call: Call<ResponseTopMovies>, t: Throwable) {
                topMoviesResponse.value = t
            }

            override fun onResponse(
                call: Call<ResponseTopMovies>,
                response: Response<ResponseTopMovies>
            ) {

                if (response.isSuccessful){
                    topMoviesResponse.value = response.body()
                }else{
                    topMoviesResponse.value = "error"
                }
            }
        })
    }*/



}