package irfan.sampling.testjetpack.data.db_only

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask
import irfan.sampling.testjetpack.data.data_model.People
import irfan.sampling.testjetpack.data.data_net.PeopleListInfo


/**
 *   created by Irfan Assidiq on 3/31/19
 *   email : assidiq.irfan@gmail.com
 **/
@Database(entities = [People::class], version = 1)
abstract class PeopleDb  : RoomDatabase(){
    abstract fun peopleDao(): PeopleDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "people.db"
        private var INSTANCE: PeopleDb? = null

        fun getInstance(application: Application): PeopleDb{
//            synchronized(lock){
//                if (INSTANCE == null){
//                    INSTANCE = Room.databaseBuilder(
//                        application, PeopleDb::class.java, DB_NAME)
//                        .allowMainThreadQueries()
//                        .build()
//                }
//                return INSTANCE!!
//            }
            synchronized(PeopleDb.lock){
                if (PeopleDb.INSTANCE == null){
                    PeopleDb.INSTANCE =
                            Room.databaseBuilder(application,
                                PeopleDb::class.java, PeopleDb.DB_NAME)
                                .allowMainThreadQueries()
                                .addCallback(
                                    object : RoomDatabase.Callback(){
                                        override fun onCreate(db: SupportSQLiteDatabase) {
                                            super.onCreate(db)
                                            PeopleDb.INSTANCE?.let{
                                                PeopleDb.prePopulated(it, PeopleListInfo.peopleList)
                                            }
                                        }
                                    }
                                ).build()
                }
                return PeopleDb.INSTANCE!!
            }
        }

        fun prePopulated(database: PeopleDb, peopleList : List<People>){
            for(people in peopleList) {
                AsyncTask.execute { database.peopleDao().insert(people) }
            }
        }
    }
}
