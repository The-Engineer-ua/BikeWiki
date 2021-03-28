package com.glushkov.bike_wiki.service

import com.glushkov.bike_wiki.data.BikeRemoteRepository
import javax.inject.Inject

class GraphQlService @Inject constructor(private val dataSource: BikeRemoteRepository) {

//    /**
//     * Returns a set of paginated data
//     * @param page number of page to calculate offset
//     * @return [MissionsQuery.Mission] list of data
//     */
//    suspend fun getMissions(page: Int): List<MissionsQuery.Mission>? {
//        try {
//            return dataSource.getMissions(page)?.missions()
//        }
//        catch (e: Exception) {
//            Log.e(GraphQlService::class.java.simpleName, "Error gathering data. Sending log or handling behavior", e)
//        }
//        return listOf()
//    }
//
//    /**
//     * Returns a set of filtered missions
//     * @param query search text that can be found in the name of the target
//     * @return [MissionsQuery.Mission] List to be compatible with feed
//     */
//    suspend fun getFilteredMissions(query: String): List<MissionsQuery.Mission>? {
//        try {
//            val data = dataSource.getMissionsFilteredByName(query)?.missions()
//            //Mapping collections so it will work inside general feed fragment. In case of separate search fragment: not needed
//            return data?.map {
//                MissionsQuery.Mission(it.__typename(), it.name(), it.description())
//            }
//        }
//        catch (e: Exception) {
//            Log.e(GraphQlService::class.java.simpleName, "Error gathering data. Sending log or handling behavior", e)
//        }
//        return listOf()
//    }

}