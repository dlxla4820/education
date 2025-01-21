package enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Language {
    PYTHON("python"),
    JAVA("java"),
    C_LANG("c"),
    C_PLUS_PLUS("c++");
    private final String lang;
}
