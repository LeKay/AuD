package Blatt4;// Abstrakte Datenstruktur Stack, realisiert als Java-Interface

interface StackI<E>
{
	public void push(E element);
	public void pop();
	public E top();
	public boolean isEmpty();
}
