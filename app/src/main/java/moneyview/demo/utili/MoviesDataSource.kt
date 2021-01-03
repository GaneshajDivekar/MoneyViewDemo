package moneyview.demo.utili

import androidx.paging.PagingSource
import moneyview.demo.model.ResultsItem
import moneyview.demo.network.APIService

class MoviesDataSource(var apiService: APIService) : PagingSource<Int, ResultsItem>() {
    private val initialPageIndex: Int = 0
    override suspend fun load(params: LoadParams<Int>): PagingSource.LoadResult<Int, ResultsItem> {
        return try {
            val position = params.key ?: initialPageIndex
            val response = apiService.getTopRatedMovies(
                API_KEY, "en",perPage).await()
            val items = response.body()?.results
            LoadResult.Page(
                data = items!!,
                prevKey = if (position == initialPageIndex) null else position - 1,
                nextKey = if (items.isEmpty()) null else position + 1

            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
