package datastructure.stack;

import java.util.EmptyStackException;

/**
 * Ueberschrift: Stapel-Schnittstelle
 * Beschreibung: Schnittstelle zur
 * Implementierung des Stapel
 * Eine Schnittstelle macht keine Annahme ueber
 * die Implementierung daher der Name Stack.
 */

public interface Stack<E> {

    /**
     * Falls der Stapel noch nicht voll ist, wird das Element 'e' dem
     * Stapel als oberstes Element hinzugefuegt, andernfalls wird ein
     * FullStackException-Objekt erzeugt.
     *
     * @param e zu speicherndes Element
     * @throws FullStackException
     */
    public void push(E e) throws FullStackException;

    /**
     * Falls der Stapel nicht leer ist, wird das oberste Element des Stapels
     * entfernt und als Ergebnis zurueckgegeben, andernfalls wird ein
     * EmptyStackException-Objekt erzeugt.
     *
     * @return entferntes Element
     * @throws EmptyStackException
     */
    public E pop() throws EmptyStackException,  datastructure.stack.EmptyStackException;

    /**
     * Ueberprueft, ob der Stapel leer ist.
     *
     * @return true falls der Stapel leer ist, false sonst
     */
    public boolean empty();

    /**
     * Ueberprueft, ob der Stapel voll ist.
     *
     * @return true falls der Stapel voll ist, false sonst
     */
    public boolean full();

    /**
     * Liefert eine Darstellung des Stapels als Zeichenkette.
     *
     * @return die Darstellung als Zeichenkette.
     */
    @Override
    public String toString();
}
