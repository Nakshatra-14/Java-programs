package com.example.nn;

import io.javalin.Javalin;

public class Main {
    record Test(int id, int value) {}
    public static void main(String[] args) {
        var app = Javalin.create()
            .get("/", ctx -> ctx.result("Hellooo"))
            .start(7070);
    }
}
