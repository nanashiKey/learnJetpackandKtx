package irfan.sampling.testjetpack.data

import android.app.Application
import android.arch.lifecycle.LiveData
import irfan.sampling.testjetpack.data.data_model.People
import irfan.sampling.testjetpack.data.data_net.PeopleListInfo
import irfan.sampling.testjetpack.data.db_only.PeopleDao
import irfan.sampling.testjetpack.data.db_only.PeopleDb


/**
 *   created by Irfan Assidiq on 3/29/19
 *   email : assidiq.irfan@gmail.com
 **/
class ContactRepo(application : Application) {

    /**
     * init database
     */
    private val peopleDao : PeopleDao

    init {
        val peopleDb = PeopleDb.getInstance(application)
        peopleDao = peopleDb.peopleDao()
    }

    /**
     * return list people from latest added
     */
    fun getAllPeple() : LiveData<List<People>>{
//        val allpeople  = PeopleListInfo.peopleList
//        return  allpeople.reversed()
        return peopleDao.getAll()
    }

    /**
     * add new people information
     */

    fun insertingPeople(people: People){
//        PeopleListInfo.peopleList.add(people)
        peopleDao.insert(people)
    }

    /**
     * find people with id
     * not yet functional
     * unhide when to use it
     */
    fun findPeople(id: Int): LiveData<People> {
//        for (people in PeopleListInfo.peopleList) {
//            if (people.id == id) {
//                return people
//            }
//        }
//        return null
        return peopleDao.find(id)
    }
//
//    /**
//     * Finds people with similar name
//     */
//    fun searchPeople(name: String): List<People> {
//        var peoples = mutableListOf<People>()
//        for (people in PeopleListInfo.peopleList) {
//            if (people.name.toLowerCase().contains(name.toLowerCase())) {
//                peoples.add(people)
//            }
//        }
//        return peoples
//    }
}