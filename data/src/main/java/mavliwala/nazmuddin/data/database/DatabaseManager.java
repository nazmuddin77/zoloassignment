package mavliwala.nazmuddin.data.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;

import mavliwala.nazmuddin.data.database.entities.DaoMaster;
import mavliwala.nazmuddin.data.database.entities.DaoSession;
import mavliwala.nazmuddin.data.disc.ApplicationContext;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public class DatabaseManager {

    private final DaoSession daoSession;

    @Inject
    public DatabaseManager(@ApplicationContext Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,"users-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }
}
