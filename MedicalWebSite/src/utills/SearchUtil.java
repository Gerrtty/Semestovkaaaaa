package utills;

import DAO.BuildingDAO;
import ORM.Building;

import java.util.List;

public class SearchUtil {

    private static String BUILDING_BY_DESCRIPTION =
            "select * from semestrovka.Building join semestrovka.ServiceBuilding on " +
            "Building.building_id = ServiceBuilding.building_id join semestrovka.Service on Service.service_id = ServiceBuilding.service_id "
            + "where description = ?";

    private static String BUILDING_BY_DESCRIPTION_WITH_PRICE =
            "select * from semestrovka.Building join semestrovka.ServiceBuilding on " +
                    "Building.building_id = ServiceBuilding.building_id join semestrovka.Service on Service.service_id = ServiceBuilding.service_id "
                    + "where description = ? and price ";

    public List<Building> getBuildingsByDescription(String s) {

        return new BuildingDAO().getBuildingsBySQLString(BUILDING_BY_DESCRIPTION, s);
    }

    public List<Building> getBuildingsByDescriptionWithPrice(String s1, String s2) {
        String price = "";
        for (int i = 1; i < s2.length(); i++) {
            price += s2.charAt(i);
        }
        String sqlString = BUILDING_BY_DESCRIPTION_WITH_PRICE + s2.charAt(0) + "\'" + price + "\'";
        return new BuildingDAO().getBuildingsBySQLString(sqlString, s1);
    }
}
