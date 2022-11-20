package service;

import java.util.List;

import repo.DbService;

public class ProcessorService {
    DbService dbService =  DbService.getInstance();

    public void startTracking(int id, List<String> tags) {
        if (dbService.isEntityPresent(id)) {
            System.out.println("\n Duplicate key " + id);
            return;
        }

        dbService.saveEntity(id, tags);

        System.out.println("\n Inserted - " + id + " :: " + tags.toString());
    }

    public void getCounts(List<String> tags) {
        System.out.println("\n Fetching count for :: " + tags.toString());

        int count = dbService.fetchCount(tags);

        System.out.println("\n Total Count :: " + count);
    }

    public void stopTracking(int id) {
        if (!dbService.isEntityPresent(id)) {
            System.out.println("Entity not found");
            return;
        }

        dbService.deleteEntity(id);

        System.out.println("\n Stopped - " + id);
    }
}
