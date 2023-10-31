package org.motorcycles;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusBootApplication {

    public static void main(String[] args) {
        Quarkus.run(args);
    }

}
