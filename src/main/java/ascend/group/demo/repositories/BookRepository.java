package ascend.group.demo.repositories;

import java.util.List;
import ascend.group.demo.entity.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Long> {
    @Query("select b from Books b where b.author = :author ")
    public List<Books> findBooksByAuthor(String author);
}
