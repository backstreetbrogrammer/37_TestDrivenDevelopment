package com.backstreetbrogrammer.model;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(final ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("Java", 9, 3),
                Arguments.of("Python", 2, 1),
                Arguments.of("JavaScript", 1, 7)
                        );
    }
}
