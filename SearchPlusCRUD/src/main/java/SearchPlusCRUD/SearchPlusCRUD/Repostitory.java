package SearchPlusCRUD.SearchPlusCRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repostitory extends JpaRepository<Laliga,Integer> {

    @Query("SELECT p FROM Laliga p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.team) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.about) LIKE LOWER(CONCAT('%', :keyword, '%'))")



    List<Laliga> searchFromkeyword(String keyword);
}
