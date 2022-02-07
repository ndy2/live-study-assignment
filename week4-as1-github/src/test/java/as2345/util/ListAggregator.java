package as2345.util;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.util.ArrayList;
import java.util.List;

public class ListAggregator implements ArgumentsAggregator {
    @Override
    public List<Integer> aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        int size = arguments.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(arguments.getInteger(i));
        }
        return list;
    }
}
