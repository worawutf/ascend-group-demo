package ascend.group.demo.service;

import java.util.List;
import ascend.group.demo.dto.BooksDto;

public interface BooksService {
    BooksDto createBook(BooksDto bookDTO) throws Exception;
    public List<BooksDto> getBooksByAuthor(String author) throws Exception;
}
