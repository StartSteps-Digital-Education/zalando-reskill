package org.startsteps.week06.class02;

import java.util.List;
import java.util.Random;

public class ChildNameGenerator<T> {
    private List<T> names;
    private Random random;

    public ChildNameGenerator(List<T> names) {
        this.names = names;
        this.random = new Random();
    }

    public T generateName() {
        if(names.isEmpty()) {
            throw new IllegalStateException("Name is empty");
        }

        int randomIndex = random.nextInt(names.size());
        return names.get(randomIndex);
    }


    public static void main(String[] args) {

        List<String> girlNames = List.of("Emma", "Olivia", "Alicia");
        ChildNameGenerator<String> girlNameGenerator = new ChildNameGenerator<>(girlNames);
        String generatedName = girlNameGenerator.generateName();
        System.out.println(generatedName);

        List<Integer> boysName = List.of(1, 2, 3 ,4 );
        ChildNameGenerator<Integer> boyNameGenerator = new ChildNameGenerator<>(boysName);
        Integer generatedBoyName = boyNameGenerator.generateName();
        System.out.println(generatedBoyName);


    }
}



// static <T> void add(T nums) {
// }

// interface addCollection<T>
