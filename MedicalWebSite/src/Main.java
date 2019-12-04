import DAO.BuildingDAO;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BuildingDAO().getLastId());
    }
}
