package com.github.fe2s;

/**
 * @author Oleksiy_Dyagilev
 */
public class CommandExecutor {

    public CommandExecutor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    CommandHelloWorld commandHelloWorld = new CommandHelloWorld("World");
                    String s = commandHelloWorld.execute();
                    System.out.println("s = " + s);
                }
            }
        }).start();
    }
}
