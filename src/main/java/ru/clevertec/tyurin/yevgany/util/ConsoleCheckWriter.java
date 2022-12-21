package ru.clevertec.tyurin.yevgany.util;


import ru.clevertec.tyurin.yevgany.model.Check;

public class ConsoleCheckWriter extends CheckWriter {

    private Check check;

    public ConsoleCheckWriter(Check check) {
        super();
        this.check = check;
    }

    @Override
    public void write() {
        System.out.println(createCheck(check));
    }
}
