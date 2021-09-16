module no.academy.tictac {
    requires javafx.controls;
    requires javafx.fxml;


    opens no.academy.tictac to javafx.fxml;
    exports no.academy.tictac;
}