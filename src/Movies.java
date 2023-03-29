import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Movies {
    @JsonProperty("items")
    private ArrayList<Movie> items;

    @JsonProperty("errorMessage")
    private String errorMessage;

    public ArrayList<Movie> getItems() {
        return items;
    }

    public void setItems(ArrayList<Movie> items) {
        this.items = items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "items=" + items +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
