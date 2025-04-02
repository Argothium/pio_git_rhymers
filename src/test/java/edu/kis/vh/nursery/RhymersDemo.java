package edu.kis.vh.nursery;

import edu.kis.vh.nursery.defaultCountingOutRhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

/**
 * Klasa demonstrująca działanie różnych typów stosów (rhymerów).
 * Program tworzy różne typy stosów przy użyciu fabryki, zapełnia je liczbami i następnie wypisuje zawartość każdego z nich.
 * Program również wyświetla liczbę odrzuconych elementów dla typu HanoiRhymer.
 */
class RhymersDemo {

    /**
     * Główna metoda programu, która tworzy instancję fabryki rhymerów i wywołuje metodę testującą.
     * Metoda testuje działanie różnych typów rhymerów poprzez zapełnienie ich liczbami
     * i wypisanie elementów z poszczególnych stosów.
     */
    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    /**
     * Testuje działanie różnych typów rhymerów.
     * Tworzy tablicę rhymerów, zapełnia ją liczbami i losowymi liczbami, a następnie wypisuje elementy z każdego stosu.
     * Dodatkowo, dla typu HanoiRhymer, wypisuje liczbę odrzuconych elementów.
     */
    public static void testRhymers(Rhymersfactory factory) {
        defaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFIFORhymer(), factory.GetHanoiRhymer() };
        for (int i = 1; i < 15; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);


        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++)
            rhymers[3].countIn(rn.nextInt(20));


        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
    }
}
