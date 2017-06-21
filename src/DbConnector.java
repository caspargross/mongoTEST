import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

/**
 * Created by caspar on 21.06.17.
 */
public class DbConnector extends MongoClient {

    MongoDatabase db;
    MongoCollection<Document> userColl;
    MongoCollection<Document> stepColl;
    MongoCollection<Document> daysColl;

    Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };

    public DbConnector() {

        // Accesses DB, creates an Instance if it does not exist yet.c
        this.db = getDatabase("trackFitTest");
        userColl = db.getCollection("users");
        stepColl = db.getCollection("steps");
        daysColl = db.getCollection("days");
    }

    public boolean findUser (String userName) {
        //db.getCollection("users")

        return true;
    }


    public void storeSteps(String stepData) {
        System.out.println("Started storing stepData");

        Document stepDoc= Document.parse(stepData);

        System.out.println(stepDoc.get("bucket").toString());

        //stepColl.insertOne(stepTotal);

    }

}
