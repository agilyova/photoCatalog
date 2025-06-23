package quru.qa.photocatalog.domain;

import java.util.Date;

public record Photo(String description,
                    Date lastModifiedDate,
                    String content) {
}
