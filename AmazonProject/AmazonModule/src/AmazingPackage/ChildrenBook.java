package AmazingPackage;

public class ChildrenBook extends Book{
    int recommendedAgeInfo;

    public ChildrenBook(long productId, String title, String author, int price, int recommendedAgeInfo) throws Exception {
        super(productId, title, author, price);
        this.recommendedAgeInfo = recommendedAgeInfo;
    }

    public int getRecommendedAgeInfo() {
        return recommendedAgeInfo;
    }

    public void setRecommendedAgeInfo(int recommendedAgeInfo) {
        this.recommendedAgeInfo = recommendedAgeInfo;
    }

    @Override
    public void printDetails(){
        super.printDetails();
        System.out.println(String.format("%8s","Age from: ") +  recommendedAgeInfo);
    }

}
