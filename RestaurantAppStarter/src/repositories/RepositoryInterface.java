package repositories;

import java.util.List;
import model.Restaurant;

/**
 *
 * @author Zuby
 */
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

    /**
     *
     * @return
     */
    List<Restaurant> getItems();

    /**
     *
     * @param id
     */
    
    void remove(int id);

    /**
     *
     * @param items
     */
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
