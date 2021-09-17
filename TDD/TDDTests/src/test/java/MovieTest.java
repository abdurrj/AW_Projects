import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {



    @Test
    public void movieDetailsPrintedWithDirector() {
        Movie movieWithDirector = new Movie(
                "Lord of the Rings",
                200,
                "peter jackson"
        );
        assertEquals("Title: Lord of the Rings\nPrice: 200\nDirector: PETER JACKSON\n",
                movieWithDirector.getDetails()
        );
    }

    @Test
    public void movieDetailsPrintedWithUnknownDirector() {
        Movie movieWithUnknownDirector = new Movie(
                "Star Wars",
                100
        );
        assertEquals(
                "Title: Star Wars\nPrice: 100\nUnknown director\n",
                movieWithUnknownDirector.getDetails())
        ;
    }

    @Test
    public void moviePricePrintedWithVat(){
        Movie movieWithUnkownDirector = new Movie(
                "Star Wars",
                100
        );

        assertEquals("Price: 125 (25% vat incl.)", movieWithUnkownDirector.getPriceWithVat());
    }
}
