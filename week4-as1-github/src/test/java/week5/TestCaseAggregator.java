package week5;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCaseAggregator implements ArgumentsAggregator {

    @Override
    public TestCase aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {

        String inValues = argumentsAccessor.getString(0);
        String expectedOut = argumentsAccessor.getString(1);
        List<Integer> in = Arrays.stream(inValues.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        return new TestCase(in,expectedOut);
    }
}
