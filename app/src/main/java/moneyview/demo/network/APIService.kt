package moneyview.demo.network

import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import moneyview.demo.model.ResponseTopMovies
import moneyview.demo.utili.API_KEY
import moneyview.demo.utili.APP_LANGUAGE
import moneyview.demo.utili.MOVIE_TOP_RATED_API
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface APIService {

    @GET(MOVIE_TOP_RATED_API)
    fun getTopRatedMovies(@Query("api_key") apiKey: String = API_KEY
                          , @Query("language") language: String = APP_LANGUAGE
                          , @Query("page") pageIndex: Int): Deferred<Response<ResponseTopMovies>>

   /* @GET("posts")
    fun getPosts(): Observable<PostAPIResponse>

    @GET("posts/{post_Id}/comments")
    fun getPostsComments(@Path("post_Id") post_Id: Int): Observable<PostCommentResponse>

*/
    companion object {
        const val Base_Url = "http://jsonplaceholder.typicode.com/"
    }
}
