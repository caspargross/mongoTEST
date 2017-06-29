import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;

public class Main {

    public static void main(String[] args) {
        System.out.println("MongoDB Data Tester");

        DbConnector dbConnector= new DbConnector("116026863562234915983");
        try {
            dbConnector.storeUser(readFile("userData.json", StandardCharsets.UTF_8));
            dbConnector.storeSteps(readFile("stepData.json", StandardCharsets.UTF_8));
            dbConnector.extractData(1495472532710l, 1498064532710l);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


}
