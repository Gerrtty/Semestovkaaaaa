import utills.SearchUtil;


public class Main {
    public static void main(String[] args) {
        SearchUtil searchUtil = new SearchUtil();
        searchUtil.getBuildingsByDescription("dentist").stream().forEach(s -> System.out.println(s.getAddress().getStreet()));
    }
}
