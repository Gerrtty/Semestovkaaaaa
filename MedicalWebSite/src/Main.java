import DAO.ServiceDAO;
import utills.SearchUtil;


public class Main {
    public static void main(String[] args) {
        SearchUtil searchUtil = new SearchUtil();
//        searchUtil.getBuildingsByDescriptionWithPrice("dentist", "<400").stream().forEach(s -> System.out.println(s.getAddress().getStreet()));

        System.out.println(new ServiceDAO().getIdByDescription("dentist"));

    }
}
