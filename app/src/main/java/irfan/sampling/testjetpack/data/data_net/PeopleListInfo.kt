package irfan.sampling.testjetpack.data.data_net

import irfan.sampling.testjetpack.data.data_model.People


/**
 *   created by Irfan Assidiq on 3/29/19
 *   email : assidiq.irfan@gmail.com
 **/
class PeopleListInfo{
    companion object {
        var peopleList = initPeopleList()

        /*
        add dummy data to apps
         */

        private fun initPeopleList() : MutableList<People>{
            var po_peoples = mutableListOf<People>()
            po_peoples.add(People(
                "Wahid",
                "RW Campus",
                "+62-840332240",
                "ray@razeware.com",
                "facebook.com/ones_",
                "twitter.com/ones_",
                1))
            po_peoples.add(People(
                "Isnain",
                "Alter Bridge Concert",
                "+62-844012312",
                "mark@alterbridge.com",
                "facebook.com/two_",
                "twitter.com/two_",
                2))
            po_peoples.add(People(
                "Salasu",
                "Amazon HQ",
                "+62-826622992",
                "j.bezos@amazon.com",
                "facebook.com/three_",
                "twitter.com/three_",
                3))
            return  po_peoples
        }
    }
}