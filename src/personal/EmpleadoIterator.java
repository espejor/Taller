package personal;

import listas.ListaDeEmpleados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmpleadoIterator implements Iterator<Empleado>{
    ArrayList<Empleado> lista;
    int pointer;
    public EmpleadoIterator(ListaDeEmpleados lista) {
        this.lista = lista.getColection();
        pointer = 0;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return pointer < lista.size();
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Empleado next() {
        pointer++;
        return lista.get(pointer-1);
    }
}
