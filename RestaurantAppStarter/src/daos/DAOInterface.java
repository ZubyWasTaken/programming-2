package daos;

// import repositories.Repository;

import repositories.Repository;


/**
 *
 * @author mga
 */
public interface DAOInterface {

    /**
     *
     * @param filename
     * @return
     */
    public Repository load(String filename);

    /**
     *
     * @param filename
     * @param repository
     */
    public void store(String filename, Repository repository);
}
