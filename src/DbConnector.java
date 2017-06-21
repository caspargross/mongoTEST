import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.unwind;
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
    String UserID;


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


    public void storeUser(String googleUserData) {

        Document userDoc = Document.parse(googleUserData);

        userColl.insertOne(userDoc);
    }


    public void storeSteps(String stepData) {
        System.out.println("Started storing stepData");
        Document stepDoc = Document.parse(stepData);
        stepColl.insertOne(stepDoc);
        System.out.println(unwind("$bucket"));

        stepColl.aggregate(Arrays.asList(unwind("$bucket"))).forEach(printBlock);




    }



}
