package utills;

import ORM.Address;
import ORM.Building;
import some_usefull_classes.ConnectionToDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchUtil {
    private static String db = "semestrovka.";

    private static String BUILDING_BY_DESCRIPTION =
            "select * from semestrovka.Building join semestrovka.ServiceBuilding on " +
            "Building.building_id = ServiceBuilding.building_id join semestrovka.Service on Service.service_id = ServiceBuilding.service_id "
            + "where description = ?";

    public List<Building> getBuildingsByDescription(String s) {

        List<Building> list = new ArrayList<>();

        try {
            PreparedStatement ps = ConnectionToDataBase.getConnection().prepareStatement(BUILDING_BY_DESCRIPTION);
            ps.setString(1,s);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Address address = new Address(rs.getString("town"),
                        rs.getString("street"),
                        rs.getString("district"),
                        rs.getInt("number"));

                Building building = new Building(rs.getInt("building_id"), address);
                building.setName(rs.getString("name"));
                building.setPath(rs.getString("path"));
                list.add(building);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
