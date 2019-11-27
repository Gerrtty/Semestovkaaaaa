import DAO.ReviewDaO;
import ORM.Review;

import ORM.ServiceBuildinng;
import utills.SearchUtil;



public class Main {
    public static void main(String[] args) {
        SearchUtil searchUtil = new SearchUtil();

//        searchUtil.getBuildingsByDescriptionWithPrice("dentist", "<400").stream().forEach(s -> System.out.println(s.getAddress().getStreet()));

//        System.out.println(new ServiceDAO().getIdByDescription("dentist"));

//        System.out.println(new BuildingDAO().getByID(5).getAddress().getStreet());
//
//        Building building = new BuildingDAO().getByID(1);
//
//        List service = new ServiceBuildingDAO().getAllyBuildingID(building);
//
//        service.stream().forEach(s -> System.out.println(((Service) s).getDescription()));

        ServiceBuildinng s = new ServiceBuildinng();
        s.setService_id(1);

        Review review = (Review) new ReviewDaO().getAllByID(s).get(0);

        System.out.println(review.getUser_name());

    }
}
