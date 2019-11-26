import DAO.BuildingDAO;
import ORM.Building;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BuildingDAO buildingDAO = new BuildingDAO();
        List<Building> arrayList = buildingDAO.getAll();
        arrayList.stream().forEach(s -> System.out.println(s.getAddress().getStreet()));
    }
}
