package principal;

import dao.OrdenDAO;

public class Main {

    public static void main(String[] args) {

        OrdenDAO dao = new OrdenDAO();

        dao.eliminarOrden(2);
    }
}