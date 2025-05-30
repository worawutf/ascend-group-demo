package ascend.group.demo.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import java.util.stream.Collectors;
import ascend.group.demo.dto.BooksDto;
import ascend.group.demo.entity.Books;
import org.springframework.stereotype.Service;
import ascend.group.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookServiceImpl implements BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BooksDto createBook(BooksDto bookDTO) throws Exception{
        Books book = modelMapper.map(bookDTO, Books.class);
        book = bookRepository.save(book);
        return modelMapper.map(book, BooksDto.class);
    }

    @Override
    public List<BooksDto> getBooksByAuthor(String author) throws Exception{
        List<Books> books = this.bookRepository.findBooksByAuthor(author);

        List<BooksDto> booksDtoList = books.stream()
                .map(book -> modelMapper.map(book, BooksDto.class))
                .collect(Collectors.toList());
        return booksDtoList;
    }
}
