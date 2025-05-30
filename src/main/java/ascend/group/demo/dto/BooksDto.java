package ascend.group.demo.dto;

import lombok.Data;
import java.util.Date;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import ascend.group.demo.validator.ValidPublishedDate;

@Data
public class BooksDto {
    private Long id;

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "author is required")
    private String author;

    @NotNull
    @ValidPublishedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Bangkok")
    private Date publishedDate;
}

