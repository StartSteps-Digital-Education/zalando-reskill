package org.startsteps.week12.class_01;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.List;

public class MongoCrudLab {
    // no-sql => mongodb
    // data is schemaless -
    // flexible data model => key - value, document based, graph based
    // scalability => horizontally or vertically.
    // performance => often prioritize performance over strict consistency
    // json format =>
    // users: { type: employees, }
    // category: { managers, }


    public static void main(String[] args) {
        // connect to mongodb
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // get database
        MongoDatabase database = mongoClient.getDatabase("crudlab");
        MongoCollection<Document> collection = database.getCollection("employees");

        // document (mongodb) <=>  table rows (mysql)
        Document employee1 = new Document("name", "John Doe")
                .append("position", "Software Engineer")
                .append("salary", 8000);
        Document employee2 = new Document("name", "Jane Smith")
                .append("position", "Data Analyst")
                .append("salary", 60000);
        Document employee3 = new Document("name", "Bob Johnson")
                .append("position", "Product Manager")
                .append("salary", 90000);

        // insert multiple documents
        InsertManyResult insertManyResult = collection.insertMany(List.of(employee1, employee2, employee3));
        System.out.println("Document inserted. " + insertManyResult.getInsertedIds());


        // read all documents in the collection
        System.out.println("Querying all documents");
        printDocuments(collection.find());

        // delete
        DeleteResult deleteResult = collection.deleteOne(new Document("name", "Bob Johnson"));
        System.out.println("Deleted " + deleteResult.getDeletedCount() + " document successfully!");

        // update
        UpdateResult updateResult = collection.updateOne(
                new Document("name", "John Doe"),
                new Document("$set", new Document("position", "Senior Software Engineer"))
        );
        System.out.println("Updated " + updateResult.getModifiedCount() + " document successfully!");
    }

    private static void printDocuments(FindIterable<Document> documents) {
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }
    }
}
