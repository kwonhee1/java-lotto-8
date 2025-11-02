package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SplitUtil {

    public static final String COMMA = ",";

    public static <T> List<T> split(String input, String regex, Function<String ,T> mapper) {
        String[] split = input.split(regex);
        return Arrays.stream(split)
                .map(s->s.trim())
                .map(mapper::apply)
                .toList();
    }

}
