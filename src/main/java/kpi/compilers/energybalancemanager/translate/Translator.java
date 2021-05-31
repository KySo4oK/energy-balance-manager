package kpi.compilers.energybalancemanager.translate;

import kpi.compilers.energybalancemanager.expression.AbstractExpression;
import kpi.compilers.energybalancemanager.translate.optimization.OptimizationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Translator {

    private static final String path = "translated.txt";

    private final List<OptimizationStrategy> optimizationStrategies;

    public void translate(List<AbstractExpression> expressions) {

        for (OptimizationStrategy optimizationStrategy : optimizationStrategies) {
            expressions = optimizationStrategy.optimize(expressions);
        }

        String translated = expressions.stream()
                .map(AbstractExpression::translate)
                .collect(Collectors.joining("\n"));
        Path path = Paths.get(Translator.path);
        byte[] strToBytes = translated.getBytes();
        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
