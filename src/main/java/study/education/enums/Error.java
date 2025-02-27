package study.education.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Error {

    // problem 관련
    TITLE_IS_EMPTY("title", "title is empty"),
    LEVEL_IS_EMPTY("level", "level is empty"),
    LEVEL_IS_NOT_VALID("level", "level is not valid"),
    CONTENT_IS_EMPTY("content", "content is empty"),
    INPUT_CASE_IS_EMPTY("input", "input case is empty"),
    OUTPUT_CASE_IS_EMPTY("output", "output case is empty");

    private final String key;
    private final String message;
}
