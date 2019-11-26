package repositories;

import java.util.List;
import model.Restaurant;

public interface RepositoryInterface {

    /**
     *
     * @param item
     */
    void add(Restaurant item);

    /**
     *
     * @param id
     * @return
     */
    Restaurant getItem(int id);

    List<Restaurant> getItems();

    /**
     *
     * @param id
     */
    
    void remove(int id);

    void setItems(List<Restaurant> items);

    /**
     *
     * @param filename
     */
    
    void store(String filename);

    /**
     *
     * @return
     */
    @Override
    String toString();
    
}
