package irfan.sampling.testjetpack.data

import android.app.Application
import irfan.sampling.testjetpack.data.data_model.People
import irfan.sampling.testjetpack.data.data_net.PeopleListInfo


/**
 *   created by Irfan Assidiq on 3/29/19
 *   email : assidiq.irfan@gmail.com
 **/
class ContactRepo(application : Application) {
    /**
     * return list people from latest added
     */
    fun getAllPeple() : List<People>{
        val allpeople  = PeopleListInfo.peopleList
        return  allpeople.reversed()
    }

    /**
     * add new people information
     */

    fun insertingPeople(people: People){
        PeopleListInfo.peopleList.add(people)
    }

    /**
     * find people with id
     * not yet functional
     * unhide when to use it
     */
    fun findPeople(id: Int): People? {
        for (people in PeopleListInfo.peopleList) {
            if (people.id == id) {
                return people
            }
        }
        return null
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