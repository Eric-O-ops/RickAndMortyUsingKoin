package com.geektech.rickandmortyusingkoin.data.repository.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.geektech.rickandmortyusingkoin.data.network.api.CharacterApi
import com.geektech.rickandmortyusingkoin.model.CharacterModel
import retrofit2.HttpException
import java.io.IOException

class CharacterPagingSources(
    private val characterApi: CharacterApi
) : PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: 1
        return try {
            val response = characterApi.fetchCharacter(position)
            val nextPage = response.info.next
            val nextPageNumber =
                if (nextPage == null) null
                else Uri.parse(response.info.next).getQueryParameter("page")?.toInt()
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(anchorPosition = it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
