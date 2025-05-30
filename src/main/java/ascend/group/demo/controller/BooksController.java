package ascend.group.demo.controller;

import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ascend.group.demo.dto.BooksDto;
import ch.qos.logback.core.util.StringUtil;
import ascend.group.demo.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BooksController {
    @Autowired
    private BooksService bookService;

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam(required = false) String author) throws Exception {
        if(StringUtil.isNullOrEmpty(author))
            return ResponseEntity
                    .badRequest()
                    .body("Error: author parameter is missing or empty");
        List<BooksDto> resp = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody @Valid BooksDto bookDto) throws Exception {
        BooksDto created = bookService.createBook(bookDto);
        return ResponseEntity.ok(created);
    }
}
